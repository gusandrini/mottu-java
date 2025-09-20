package br.com.fiap.projeto_mottu.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.fiap.projeto_mottu.model.Logradouro;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

	// Busca logradouro por nome (usando atributo da classe)
	@Query("SELECT l FROM Logradouro l " +
			"WHERE LOWER(l.nmLogradouro) LIKE LOWER(CONCAT('%', :nome, '%'))")
	List<Logradouro> buscarPorNome(@Param("nome") String nome);
}
