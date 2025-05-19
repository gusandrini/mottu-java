package br.com.fiap.projeto_mottu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.projeto_mottu.model.Funcionario;
import br.com.fiap.projeto_mottu.projection.FuncionarioProjection;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	// Busca todos os funcionários de uma filial pelo nome da filial
	@Query("""
		    SELECT 
		        f.nm_funcionario AS nmFuncionario,
		        f.nm_cargo AS nmCargo,
		        f.nm_email_corporativo AS nmEmailCorporativo
		    FROM Funcionario f
		    WHERE f.filial.nome_filial = :nomeFilial
		""")
		List<FuncionarioProjection> buscarFuncionariosPorNomeFilial(@Param("nomeFilial") String nomeFilial);

    // Busca todos os funcionários com determinado cargo
    @Query("""
    	    SELECT 
    	        f.nm_funcionario AS nmFuncionario,
    	        f.nm_email_corporativo AS nmEmailCorporativo,
    	        f.filial.nome_filial AS filialNomeFilial
    	    FROM Funcionario f
    	    WHERE f.nm_cargo = :cargo
    	""")
    	List<FuncionarioProjection> buscarFuncionariosPorCargo(@Param("cargo") String cargo);
    
    // Busca funcionário por email corporativo
    Funcionario findByNmEmailCorporativo(String nmEmailCorporativo);
}
