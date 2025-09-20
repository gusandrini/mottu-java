package br.com.fiap.projeto_mottu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.projeto_mottu.model.Funcionario;
import br.com.fiap.projeto_mottu.projection.FuncionarioProjection;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Autenticação / validação
    Optional<Funcionario> findByEmailCorporativo(String emailCorporativo);
    boolean existsByEmailCorporativo(String emailCorporativo);

    // Exemplos de consultas com projeção (ajuste conforme seu modelo)
    @Query("""
           SELECT 
               f.nome             AS nmFuncionario,
               f.cargo            AS nmCargo,
               f.emailCorporativo AS nmEmailCorporativo
           FROM Funcionario f
           WHERE (:nomeFilial IS NULL OR :nomeFilial = '')
           ORDER BY f.nome ASC
           """)
    List<FuncionarioProjection> buscarFuncionariosPorNomeFilial(@Param("nomeFilial") String nomeFilial);

    @Query("""
           SELECT 
               f.nome             AS nmFuncionario,
               f.emailCorporativo AS nmEmailCorporativo
           FROM Funcionario f
           WHERE LOWER(f.cargo) LIKE LOWER(CONCAT('%', :cargo, '%'))
           ORDER BY f.nome ASC
           """)
    List<FuncionarioProjection> buscarFuncionariosPorCargoOrdenado(@Param("cargo") String cargo);
}
