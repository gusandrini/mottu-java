package br.com.fiap.projeto_mottu.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_mottu.dto.FuncionarioDTO;
import br.com.fiap.projeto_mottu.model.Funcionario;
import br.com.fiap.projeto_mottu.projection.FuncionarioProjection;
import br.com.fiap.projeto_mottu.repository.FuncionarioRepository;
import br.com.fiap.projeto_mottu.service.FuncionarioCachingService;
import br.com.fiap.projeto_mottu.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repFunc;

	@Autowired
	private FuncionarioCachingService cacheFunc;

	@Autowired
	private FuncionarioService servFunc;

	@Autowired
	private PasswordEncoder passwordEncoder; // ✅ injetado



	@GetMapping(value = "/todos")
	public List<Funcionario> retornaTodosFuncionarios() {
		return repFunc.findAll();
	}

	@GetMapping(value = "/todos_cacheable")
	public List<Funcionario> retornaTodosFuncionariosCacheable() {
		return cacheFunc.findAll();
	}

	@GetMapping(value = "/paginados")
	public ResponseEntity<Page<FuncionarioDTO>> paginarFuncionarios(
			@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

		PageRequest pr = PageRequest.of(page, size);
		Page<FuncionarioDTO> paginas_funcionarios_dto = servFunc.paginar(pr);
		return ResponseEntity.ok(paginas_funcionarios_dto);
	}

	@GetMapping(value = "/{id_funcionario}")
	public Funcionario retornaFuncionarioPorID(@PathVariable Long id_funcionario) {
		return cacheFunc.findById(id_funcionario)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@PostMapping(value = "/inserir")
	public Funcionario inserirFuncionario(@RequestBody Funcionario funcionario) {
		// 🔒 já salva senha criptografada
		funcionario.setSenhaHash(passwordEncoder.encode(funcionario.getSenhaHash()));

		repFunc.save(funcionario);
		cacheFunc.limparCache();
		return funcionario;
	}

	@PutMapping(value = "/atualizar/{id_funcionario}")
	public Funcionario atualizarFuncionario(@RequestBody Funcionario funcionario,
											@PathVariable Long id_funcionario) {

		Optional<Funcionario> op = cacheFunc.findById(id_funcionario);

		if (op.isPresent()) {
			Funcionario funcionarioAtual = op.get();

			funcionarioAtual.setNome(funcionario.getNome());
			funcionarioAtual.setCargo(funcionario.getCargo());
			funcionarioAtual.setEmailCorporativo(funcionario.getEmailCorporativo());

			// 🔒 só atualiza senha se vier preenchida
			if (funcionario.getSenhaHash() != null && !funcionario.getSenhaHash().isBlank()) {
				funcionarioAtual.setSenhaHash(passwordEncoder.encode(funcionario.getSenhaHash()));
			}

			repFunc.save(funcionarioAtual);
			cacheFunc.limparCache();

			return funcionarioAtual;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/remover/{id_funcionario}")
	public Funcionario removerFuncionario(@PathVariable Long id_funcionario) {
		Optional<Funcionario> op = cacheFunc.findById(id_funcionario);

		if (op.isPresent()) {
			Funcionario funcionario = op.get();
			repFunc.delete(funcionario);
			cacheFunc.limparCache();
			return funcionario;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/buscar_por_filial")
	public ResponseEntity<List<FuncionarioProjection>> buscarPorFilial(@RequestParam String nomeFilial) {
		List<FuncionarioProjection> funcionarios = repFunc.buscarFuncionariosPorNomeFilial(nomeFilial);
		if (funcionarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/buscar_por_cargo")
	public ResponseEntity<List<FuncionarioProjection>> buscarPorCargo(@RequestParam String cargo) {
		List<FuncionarioProjection> funcionarios = repFunc.buscarFuncionariosPorCargoOrdenado(cargo);
		if (funcionarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionarios);
	}
}

