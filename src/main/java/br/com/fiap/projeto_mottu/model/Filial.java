package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "filial")
public class Filial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_filial")
	private Long idFilial;

	@OneToOne
	@JoinColumn(name = "id_logradouro", nullable = false)
	@NotNull(message = "A filial deve estar vinculada a um logradouro")
	private Logradouro logradouro;

	@NotEmpty(message = "Não é possível inserir uma filial sem nome")
	@Size(min = 0, max = 100, message = "Valor de nome inválido")
	@Column(name = "nm_filial")
	private String nomeFilial;

	// Getters e Setters manuais
	public Long getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(Long idFilial) {
		this.idFilial = idFilial;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}
}
