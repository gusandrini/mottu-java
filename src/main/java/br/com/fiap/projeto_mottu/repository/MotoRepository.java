package br.com.fiap.projeto_mottu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.projeto_mottu.model.Moto;
import br.com.fiap.projeto_mottu.model.SituacaoEnum;
import br.com.fiap.projeto_mottu.projection.MotoProjection;

public interface MotoRepository extends JpaRepository<Moto, Long>{

	// Busca motos por situação, e ordena os resultados pelo campo nm_modelo, por ordem crescente alfabética
	@Query("SELECT m FROM Moto m WHERE m.st_moto = :situacao ORDER BY m.nm_modelo ASC")
	List<Moto> buscarPorSituacaoOrdenadoPorModelo(@Param("situacao") SituacaoEnum situacao);

    // Busca moto por placa
	@Query("SELECT m FROM Moto m WHERE LOWER(m.nm_placa) LIKE LOWER(CONCAT('%', :placa, '%'))")
	Optional<Moto> buscarPorPlaca(@Param("placa") String placa);

    //Busca moto por nome da filial, ordenada por modelo
	@Query("SELECT m.nm_placa AS nmPlaca, m.nm_modelo AS nmModelo, m.st_moto AS stMoto " +
		       "FROM Moto m " +
		       "WHERE LOWER(m.filial_departamento.filial.nome_filial) LIKE LOWER(CONCAT('%', :nomeFilial, '%')) " +
		       "ORDER BY m.nm_modelo")
	List<MotoProjection> buscarMotosPorNomeDaFilialOrdenadoPorModelo(@Param("nomeFilial") String nomeFilial);

}
