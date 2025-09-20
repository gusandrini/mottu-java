package br.com.fiap.projeto_mottu.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.com.fiap.projeto_mottu.dto.ManutencaoDTO;
import br.com.fiap.projeto_mottu.model.Manutencao;
import br.com.fiap.projeto_mottu.repository.ManutencaoRepository;
import br.com.fiap.projeto_mottu.service.ManutencaoCachingService;
import br.com.fiap.projeto_mottu.service.ManutencaoService;

@RestController
@RequestMapping(value = "/manutencoes")
public class ManutencaoController {

	@Autowired
	private ManutencaoRepository repMan;

	@Autowired
	private ManutencaoService servMan;

	@Autowired
	private ManutencaoCachingService cacheMan;

	@GetMapping(value = "/todas")
	public List<Manutencao> retornaTodosManutencoes() {
		return repMan.findAll();
	}

	@GetMapping(value = "/todos_cacheable")
	public List<Manutencao> retornaTodasManutencoesCacheable() {
		return cacheMan.findAll();
	}

	@GetMapping(value = "/paginados")
	public ResponseEntity<Page<ManutencaoDTO>> paginarManutencoes(
			@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "tamanho", defaultValue = "2") Integer size) {

		PageRequest pr = PageRequest.of(page, size);
		Page<ManutencaoDTO> paginasManutencoesDto = servMan.paginar(pr);

		return ResponseEntity.ok(paginasManutencoesDto);
	}

	@GetMapping(value = "/{idManutencao}")
	public Manutencao retornaManutencaoPorID(@PathVariable Long idManutencao) {
		Optional<Manutencao> op = cacheMan.findById(idManutencao);

		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/inserir")
	public Manutencao inserirManutencao(@RequestBody Manutencao manutencao) {
		repMan.save(manutencao);
		cacheMan.limparCache();
		return manutencao;
	}

	@GetMapping("/buscar_todas_ordenada_por_data")
	public List<Manutencao> buscarOrdenadasPorDataEntrada() {
		return repMan.buscarTodasOrdenadasPorDataEntrada();
	}

	@GetMapping("/buscar_em_aberto")
	public ResponseEntity<List<Manutencao>> buscarManutencoesEmAberto() {
		List<Manutencao> manutencoes = repMan.buscarManutencoesEmAberto();
		return manutencoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(manutencoes);
	}

	@GetMapping("/buscar_por_descricao")
	public ResponseEntity<List<Manutencao>> buscarPorDescricao(@RequestParam String keyword) {
		List<Manutencao> manutencoes = repMan.buscarPorDescricao(keyword);
		return manutencoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(manutencoes);
	}

	@PutMapping(value = "/atualizar/{idManutencao}")
	public Manutencao atualizarManutencao(@RequestBody Manutencao manutencao, @PathVariable Long idManutencao) {
		Optional<Manutencao> op = cacheMan.findById(idManutencao);

		if (op.isPresent()) {
			Manutencao manutencaoAtual = op.get();

			manutencaoAtual.setMoto(manutencao.getMoto());
			manutencaoAtual.setDsManutencao(manutencao.getDsManutencao());
			manutencaoAtual.setDtEntrada(manutencao.getDtEntrada());
			manutencaoAtual.setDtSaida(manutencao.getDtSaida());

			repMan.save(manutencaoAtual);
			cacheMan.limparCache();

			return manutencaoAtual;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/remover/{idManutencao}")
	public Manutencao removerManutencao(@PathVariable Long idManutencao) {
		Optional<Manutencao> op = cacheMan.findById(idManutencao);

		if (op.isPresent()) {
			Manutencao manutencao = op.get();
			repMan.delete(manutencao);
			cacheMan.limparCache();
			return manutencao;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
