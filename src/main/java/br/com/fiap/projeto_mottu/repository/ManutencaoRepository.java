package br.com.fiap.projeto_mottu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_mottu.model.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{

}
