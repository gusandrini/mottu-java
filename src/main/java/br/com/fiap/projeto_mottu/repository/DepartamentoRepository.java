package br.com.fiap.projeto_mottu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_mottu.model.Departamento;
import br.com.fiap.projeto_mottu.projection.DepartamentoProjection;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	@Query("SELECT d.nm_departamento AS nmDepartamento, d.desc_departamento AS descDepartamento "
	         + "FROM Departamento d WHERE d.nm_departamento = :nmDepartamento ORDER BY d.desc_departamento DESC")
	    List<DepartamentoProjection> buscarDepartamentoPorNome(String nmDepartamento);
}