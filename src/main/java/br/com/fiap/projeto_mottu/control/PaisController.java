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

import br.com.fiap.projeto_mottu.model.Pais;
import br.com.fiap.projeto_mottu.repository.PaisRepository;
import br.com.fiap.projeto_mottu.service.PaisCachingService;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

	@Autowired
	private PaisRepository repP;

	@Autowired
	private PaisCachingService cacheP;

	@GetMapping(value = "/todos")
	public List<Pais> retornaTodosPaises() {
		return repP.findAll();
	}

	@GetMapping(value = "/{idPais}")
	public Pais retornaPaisPorID(@PathVariable Long idPais) {
		Optional<Pais> op = cacheP.findById(idPais);

		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/inserir")
	public Pais inserirPais(@RequestBody Pais pais) {
		repP.save(pais);
		cacheP.limparCache();
		return pais;
	}

	@PutMapping(value = "/atualizar/{idPais}")
	public Pais atualizarPais(@RequestBody Pais pais, @PathVariable Long idPais) {
		Optional<Pais> op = cacheP.findById(idPais);

		if (op.isPresent()) {
			Pais paisAtual = op.get();

			paisAtual.setNmPais(pais.getNmPais());

			repP.save(paisAtual);
			cacheP.limparCache();

			return paisAtual;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/remover/{idPais}")
	public Pais removerPais(@PathVariable Long idPais) {
		Optional<Pais> op = cacheP.findById(idPais);

		if (op.isPresent()) {
			Pais pais = op.get();
			repP.delete(pais);
			cacheP.limparCache();
			return pais;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
