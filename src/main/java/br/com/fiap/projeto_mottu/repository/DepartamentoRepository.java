package br.com.fiap.projeto_mottu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_mottu.model.Departamento;
import br.com.fiap.projeto_mottu.projection.DepartamentoProjection;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	@Query("SELECT d.nmDepartamento AS nmDepartamento, d.descDepartamento AS descDepartamento "
	         + "FROM Departamento d WHERE d.nmDepartamento = :nmDepartamento ORDER BY d.nmDepartamento DESC")
	    List<DepartamentoProjection> buscarDepartamentoPorNome(String nmDepartamento);
}