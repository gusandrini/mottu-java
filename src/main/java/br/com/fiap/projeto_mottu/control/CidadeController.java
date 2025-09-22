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

import br.com.fiap.projeto_mottu.dto.CidadeDTO;
import br.com.fiap.projeto_mottu.model.Cidade;
import br.com.fiap.projeto_mottu.repository.CidadeRepository;
import br.com.fiap.projeto_mottu.service.CidadeCachingService;
import br.com.fiap.projeto_mottu.service.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repC;

    @Autowired
    private CidadeService servC;

    @Autowired
    private CidadeCachingService cacheC;

    // Buscar todas as cidades
    @GetMapping(value = "/todas")
    public List<Cidade> retornaTodasCidades() {
        return repC.findAll();
    }

    // Buscar todas as cidades com cache
    @GetMapping(value = "/todas_cacheable")
    public List<Cidade> retornaTodasCidadesCacheable() {
        return cacheC.findAll();
    }

    // Paginação
    @GetMapping(value = "/paginadas")
    public ResponseEntity<Page<CidadeDTO>> paginarCidades(
            @RequestParam(value = "pagina", defaultValue = "0") Integer page,
            @RequestParam(value = "tamanho", defaultValue = "5") Integer size) {

        PageRequest pr = PageRequest.of(page, size);
        Page<CidadeDTO> paginas_cidades_dto = servC.paginar(pr);

        return ResponseEntity.ok(paginas_cidades_dto);
    }

    // Buscar por ID
    @GetMapping(value = "/{id_cidade}")
    public Cidade retornaCidadePorID(@PathVariable Long id_cidade) {
        Optional<Cidade> op = cacheC.findById(id_cidade);

        if (op.isPresent()) {
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada");
        }
    }

    // Inserir
    @PostMapping(value = "/inserir")
    public Cidade inserirCidade(@RequestBody Cidade cidade) {
        repC.save(cidade);
        cacheC.limparCache();
        return cidade;
    }

    // Atualizar
    @PutMapping(value = "/atualizar/{id_cidade}")
    public Cidade atualizarCidade(@RequestBody Cidade cidade, @PathVariable Long id_cidade) {
        Optional<Cidade> op = cacheC.findById(id_cidade);

        if (op.isPresent()) {
            Cidade cidade_atual = op.get();
            cidade_atual.setNmCidade(cidade.getNmCidade());
            cidade_atual.setEstado(cidade.getEstado());

            repC.save(cidade_atual);
            cacheC.limparCache();

            return cidade_atual;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada");
        }
    }

    // Remover
    @DeleteMapping(value = "/remover/{id_cidade}")
    public Cidade removerCidade(@PathVariable Long id_cidade) {
        Optional<Cidade> op = cacheC.findById(id_cidade);

        if (op.isPresent()) {
            Cidade cidade = op.get();
            repC.delete(cidade);
            cacheC.limparCache();
            return cidade;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada");
        }
    }
}
