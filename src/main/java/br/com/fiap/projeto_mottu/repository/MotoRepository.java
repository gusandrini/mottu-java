package br.com.fiap.projeto_mottu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.projeto_mottu.model.Moto;
import br.com.fiap.projeto_mottu.model.SituacaoEnum;
import br.com.fiap.projeto_mottu.projection.MotoProjection;

public interface MotoRepository extends JpaRepository<Moto, Long> {

	// Busca por situação e ordena pelo modelo (atributos Java!)
	@Query("SELECT m FROM Moto m WHERE m.stMoto = :situacao ORDER BY m.nmModelo ASC")
	List<Moto> buscarPorSituacaoOrdenadoPorModelo(@Param("situacao") SituacaoEnum situacao);

	// Busca por placa (case-insensitive)
	@Query("SELECT m FROM Moto m WHERE UPPER(m.nmPlaca) = UPPER(:placa)")
	Optional<Moto> buscarPorPlaca(@Param("placa") String placa);

	// Busca por nome da filial (via relacionamento), ordenado por modelo
	@Query("""
           SELECT m.nmPlaca AS nmPlaca,
                  m.nmModelo AS nmModelo,
                  m.stMoto  AS stMoto
           FROM Moto m
           WHERE LOWER(m.filialDepartamento.filial.nomeFilial) LIKE LOWER(CONCAT('%', :nomeFilial, '%'))
           ORDER BY m.nmModelo
           """)
	List<MotoProjection> buscarMotosPorNomeDaFilialOrdenadoPorModelo(@Param("nomeFilial") String nomeFilial);
}
