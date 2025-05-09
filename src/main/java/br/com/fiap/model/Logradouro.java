package br.com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "logradouro")
public class Logradouro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_logradouro;
	@ManyToOne
    @JoinColumn(name = "id_bairro", nullable = false)
    @NotNull(message = "O logradouro deve estar vinculado a um bairro")
	private Bairro bairro;
	@NotEmpty(message = "A rua deve ser informada")
    @Size(max = 100, message = "A rua deve ter no máximo 100 caracteres")
	private String rua;
	@NotNull(message = "Número do endereço deve ser informado")
	private Integer numero;
	@Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres")
	private String complemento;
	
	
	public Logradouro() {}


	public Logradouro(Long id_logradouro,
			@NotNull(message = "O logradouro deve estar vinculado a um bairro") Bairro bairro,
			@NotEmpty(message = "A rua deve ser informada") @Size(max = 100, message = "A rua deve ter no máximo 100 caracteres") String rua,
			@NotNull(message = "Número do endereço deve ser informado") Integer numero,
			@Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres") String complemento) {
		super();
		this.id_logradouro = id_logradouro;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}


	public Long getId_logradouro() {
		return id_logradouro;
	}


	public void setId_logradouro(Long id_logradouro) {
		this.id_logradouro = id_logradouro;
	}


	public Bairro getBairro() {
		return bairro;
	}


	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
