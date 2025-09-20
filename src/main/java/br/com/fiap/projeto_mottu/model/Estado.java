package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Long idEstado;

	@ManyToOne
	@JoinColumn(name = "id_pais", nullable = false)
	@NotNull(message = "O estado deve estar vinculado a um país")
	private Pais pais;

	@NotEmpty(message = "O nome do estado deve ser informado")
	@Size(min = 2, max = 2, message = "O estado deve conter exatamente 2 letras (UF)")
	@Column(name = "nm_estado")
	private String nmEstado;

	// Getters e Setters
	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNmEstado() {
		return nmEstado;
	}

	public void setNmEstado(String nmEstado) {
		this.nmEstado = nmEstado;
	}
}
