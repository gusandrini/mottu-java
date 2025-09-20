package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "logradouro")
public class Logradouro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_logradouro")
	private Long idLogradouro;

	@ManyToOne
	@JoinColumn(name = "id_bairro", nullable = false)
	@NotNull(message = "O logradouro deve estar vinculado a um bairro")
	private Bairro bairro;

	@NotEmpty(message = "O nome do logradouro deve ser informado")
	@Size(max = 100, message = "O logradouro deve ter no máximo 100 caracteres")
	@Column(name = "nm_logradouro")
	private String nmLogradouro;

	@NotNull(message = "O número do logradouro deve ser informado")
	@Column(name = "nr_logradouro")
	private Integer nrLogradouro;

	@Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres")
	@Column(name = "nm_complemento")
	private String complemento;

	// Getters e Setters manuais
	public Long getIdLogradouro() {
		return idLogradouro;
	}

	public void setIdLogradouro(Long idLogradouro) {
		this.idLogradouro = idLogradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getNmLogradouro() {
		return nmLogradouro;
	}

	public void setNmLogradouro(String nmLogradouro) {
		this.nmLogradouro = nmLogradouro;
	}

	public Integer getNrLogradouro() {
		return nrLogradouro;
	}

	public void setNrLogradouro(Integer nrLogradouro) {
		this.nrLogradouro = nrLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
