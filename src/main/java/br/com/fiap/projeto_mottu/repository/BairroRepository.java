package br.com.fiap.projeto_mottu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_mottu.model.Bairro;
import br.com.fiap.projeto_mottu.projection.BairroProjection;

import java.util.List;

public interface BairroRepository extends JpaRepository<Bairro, Long>{

}

