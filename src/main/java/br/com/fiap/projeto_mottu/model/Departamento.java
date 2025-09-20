package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_departamento;

	@NotEmpty
	@Column(name = "nm_departamento")
	@Size(max = 50, message = "O nome do departamento deve ter no máximo 50 caracteres")
	private String nm_departamento;

	@NotEmpty
	@Size(max = 250, message = "A descrição do departamento deve ter no máximo 250 caracteres")
	@Column(name = "ds_departamento")
	private String desc_departamento;

	// Construtores
	public Departamento() {}

	public Departamento(Long id_departamento, String nm_departamento, String desc_departamento) {
		this.id_departamento = id_departamento;
		this.nm_departamento = nm_departamento;
		this.desc_departamento = desc_departamento;
	}

	// Getters e Setters
	public Long getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Long id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNm_departamento() {
		return nm_departamento;
	}

	public void setNm_departamento(String nm_departamento) {
		this.nm_departamento = nm_departamento;
	}

	public String getDesc_departamento() {
		return desc_departamento;
	}

	public void setDesc_departamento(String desc_departamento) {
		this.desc_departamento = desc_departamento;
	}
}
