package br.com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "filial")
public class Filial{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_filial;
	@NotEmpty(message = "Não é possível inserir uma filial sem nome")
	@Size(min = 0, max = 100, message = "Valor de nome inválido")
	private String nome_filial;
	@OneToOne
    @JoinColumn(name = "id_logradouro", nullable = false)
    @NotNull(message = "A filial deve estar vinculada a um logradouro")
	private Logradouro logradouro;
	
	public Filial() {}

	public Filial(Long id_filial,
			@NotEmpty(message = "Não é possível inserir uma filial sem nome") @Size(min = 0, max = 100, message = "Valor de nome inválido") String nome_filial,
			@NotNull(message = "Não é possível inserir uma filial sem a quantidade de motos dela") 
			@NotNull(message = "A filial deve estar vinculada a um logradouro") Logradouro logradouro) {
		super();
		this.id_filial = id_filial;
		this.nome_filial = nome_filial;
		this.logradouro = logradouro;
	}

	public Long getId_filial() {
		return id_filial;
	}

	public void setId_filial(Long id_filial) {
		this.id_filial = id_filial;
	}

	public String getNome_filial() {
		return nome_filial;
	}

	public void setNome_filial(String nome_filial) {
		this.nome_filial = nome_filial;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	

	
	
	
	
	
}
