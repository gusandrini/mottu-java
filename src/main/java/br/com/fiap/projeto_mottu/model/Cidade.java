package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade")
	private Long idCidade;

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	@NotNull(message = "A cidade deve estar vinculada a um estado")
	private Estado estado;

	@NotEmpty(message = "O nome da cidade deve ser informado")
	@Size(max = 50, message = "O nome da cidade deve ter no máximo 50 caracteres")
	@Column(name = "nm_cidade")
	private String nmCidade;

	// Getters e Setters manuais
	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNmCidade() {
		return nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}
}
