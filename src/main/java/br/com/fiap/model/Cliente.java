package br.com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	@OneToOne
    @JoinColumn(name = "id_logradouro", nullable = false)
    @NotNull(message = "O cliente deve estar relacionado a um logradouro")
	private Logradouro logradouro;
	@NotEmpty(message = "O nome do cliente deve ser informado!")
    @Size(max = 100, message = "O nome do cliente deve ter no máximo 100 caracteres")
	private String nm_cliente;
	@Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
	private String nr_cpf;
	@Pattern(regexp = "\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX) XXXXX-XXXX")
	private String nr_telefone;
	@Email(message = "Email deve ser válido")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
	private String nm_email;
	
	public Cliente () {}

	public Cliente(Long id_cliente,
			@NotNull(message = "O cliente deve estar relacionado a um logradouro") Logradouro logradouro,
			@NotEmpty(message = "O nome do cliente deve ser informado!") @Size(max = 100, message = "O nome do cliente deve ter no máximo 100 caracteres") String nm_cliente,
			@Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos") String nr_cpf,
			@Pattern(regexp = "\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX) XXXXX-XXXX") String nr_telefone,
			@Email(message = "Email deve ser válido") @Size(max = 100, message = "Email deve ter no máximo 100 caracteres") String nm_email) {
		super();
		this.id_cliente = id_cliente;
		this.logradouro = logradouro;
		this.nm_cliente = nm_cliente;
		this.nr_cpf = nr_cpf;
		this.nr_telefone = nr_telefone;
		this.nm_email = nm_email;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public String getNm_cliente() {
		return nm_cliente;
	}

	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}

	public String getNr_cpf() {
		return nr_cpf;
	}

	public void setNr_cpf(String nr_cpf) {
		this.nr_cpf = nr_cpf;
	}

	public String getNr_telefone() {
		return nr_telefone;
	}

	public void setNr_telefone(String nr_telefone) {
		this.nr_telefone = nr_telefone;
	}

	public String getNm_email() {
		return nm_email;
	}

	public void setNm_email(String nm_email) {
		this.nm_email = nm_email;
	}
	
	
}
