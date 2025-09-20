package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pais")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pais")
	private Long idPais;

	@NotEmpty(message = "O nome do país deve ser informado")
	@Size(max = 50, message = "O nome do país deve ter no máximo 50 caracteres")
	@Column(name = "nm_pais")
	private String nmPais;

	// Getters e Setters manuais
	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getNmPais() {
		return nmPais;
	}

	public void setNmPais(String nmPais) {
		this.nmPais = nmPais;
	}
}
