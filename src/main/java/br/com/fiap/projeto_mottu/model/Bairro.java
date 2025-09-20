package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "bairro")
public class Bairro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_bairro;

	@NotEmpty
	@Size(max = 100, message = "O nome do bairro deve ter no máximo 100 caracteres")
	@Column(name = "nm_bairro")
	private String nm_bairro;

	@ManyToOne
	@JoinColumn(name = "id_cidade", nullable = false)
	private Cidade cidade;

	// Construtores
	public Bairro() {}

	public Bairro(Long id_bairro, String nm_bairro, Cidade cidade) {
		this.id_bairro = id_bairro;
		this.nm_bairro = nm_bairro;
		this.cidade = cidade;
	}

	// Getters e Setters
	public Long getId_bairro() {
		return id_bairro;
	}

	public void setId_bairro(Long id_bairro) {
		this.id_bairro = id_bairro;
	}

	public String getNm_bairro() {
		return nm_bairro;
	}

	public void setNm_bairro(String nm_bairro) {
		this.nm_bairro = nm_bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
