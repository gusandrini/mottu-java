package br.com.fiap.projeto_mottu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_mottu.model.Estado;
import br.com.fiap.projeto_mottu.projection.EstadoProjection;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	@Query("SELECT e.nm_estado AS nm_estado, e.pais.nm_pais AS pais_Nm_pais " +
		       "FROM Estado e WHERE e.pais.nm_pais = :nomePais")
		List<EstadoProjection> buscarEstadosPorNomeDoPais(String nomePais);
}
