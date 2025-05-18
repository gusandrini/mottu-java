package br.com.fiap.projeto_mottu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_mottu.model.Cidade;
import br.com.fiap.projeto_mottu.projection.CidadeProjection;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	// Busca cidades por ID do estado
    @Query("select c.nm_cidade as nm_cidade, c.estado.nm_estado as estadoNome from Cidade c where c.estado.id_estado = :idEstado")
    List<CidadeProjection> buscarPorEstado(Long idEstado);

    // Busca cidades que contenham parte do nome
    @Query("select c.nm_cidade as nm_cidade, c.estado.nm_estado as estadoNome from Cidade c where lower(c.nm_cidade) like lower(concat('%', :substring, '%'))")
    List<CidadeProjection> buscarPorNome(String substring);
}
