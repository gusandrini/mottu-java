package br.com.fiap.projeto_mottu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_mottu.model.Filial;

public interface FilialRepository extends JpaRepository<Filial, Long>{

	// Busca por nome da filial
    List<Filial> findByNomeFilialContainingIgnoreCase(String nomeFilial);

    
}
