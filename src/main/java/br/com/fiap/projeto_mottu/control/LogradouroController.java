package br.com.fiap.projeto_mottu.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_mottu.model.Logradouro;
import br.com.fiap.projeto_mottu.repository.LogradouroRepository;
import br.com.fiap.projeto_mottu.service.LogradouroCachingService;
import br.com.fiap.projeto_mottu.service.LogradouroService;

@RestController
@RequestMapping(value = "/logradouros")
public class LogradouroController {

	@Autowired
	private LogradouroRepository repL;

	@Autowired
	private LogradouroService servL;

	@Autowired
	private LogradouroCachingService cacheL;

	@GetMapping(value = "/todos")
	public List<Logradouro> retornaTodosLogradouros() {
		return repL.findAll();
	}

	@GetMapping(value = "/{idLogradouro}")
	public Logradouro retornaLogradouroPorID(@PathVariable Long idLogradouro) {
		Optional<Logradouro> op = cacheL.findById(idLogradouro);

		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/inserir")
	public Logradouro inserirLogradouro(@RequestBody Logradouro logradouro) {
		repL.save(logradouro);
		cacheL.limparCache();
		return logradouro;
	}

	@PutMapping(value = "/atualizar/{idLogradouro}")
	public Logradouro atualizarLogradouro(@RequestBody Logradouro logradouro, @PathVariable Long idLogradouro) {
		Optional<Logradouro> op = cacheL.findById(idLogradouro);

		if (op.isPresent()) {
			Logradouro logradouroAtual = op.get();

			logradouroAtual.setNmLogradouro(logradouro.getNmLogradouro());
			logradouroAtual.setNrLogradouro(logradouro.getNrLogradouro());
			logradouroAtual.setComplemento(logradouro.getComplemento());

			repL.save(logradouroAtual);
			cacheL.limparCache();

			return logradouroAtual;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/remover/{idLogradouro}")
	public Logradouro removerLogradouro(@PathVariable Long idLogradouro) {
		Optional<Logradouro> op = cacheL.findById(idLogradouro);

		if (op.isPresent()) {
			Logradouro logradouro = op.get();
			repL.delete(logradouro);
			cacheL.limparCache();
			return logradouro;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
