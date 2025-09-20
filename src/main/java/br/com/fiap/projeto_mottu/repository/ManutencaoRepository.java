package br.com.fiap.projeto_mottu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.projeto_mottu.model.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    // Todas as manutenções ordenadas por data de entrada (mais recente primeiro)
    @Query("SELECT m FROM Manutencao m ORDER BY m.dtEntrada DESC")
    List<Manutencao> buscarTodasOrdenadasPorDataEntrada();

    // Em aberto = sem data de saída
    @Query("SELECT m FROM Manutencao m WHERE m.dtSaida IS NULL")
    List<Manutencao> buscarManutencoesEmAberto();

    // Busca por palavra-chave na descrição (case-insensitive)
    @Query("SELECT m FROM Manutencao m " +
            "WHERE LOWER(m.dsManutencao) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Manutencao> buscarPorDescricao(@Param("keyword") String keyword);
}
