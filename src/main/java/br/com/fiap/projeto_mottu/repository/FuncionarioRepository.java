package br.com.fiap.projeto_mottu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_mottu.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
