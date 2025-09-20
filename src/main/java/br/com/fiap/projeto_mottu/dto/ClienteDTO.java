package br.com.fiap.projeto_mottu.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_mottu.model.Cliente;
import br.com.fiap.projeto_mottu.model.Logradouro;

public class ClienteDTO extends RepresentationModel<ClienteDTO> {

	private Long id_cliente;
	private Logradouro logradouro;
	private String nm_cliente;
	private String nr_cpf;
	private String nm_email;

	// Construtores
	public ClienteDTO() {}

	public ClienteDTO(Long id_cliente, Logradouro logradouro, String nm_cliente, String nr_cpf, String nm_email) {
		this.id_cliente = id_cliente;
		this.logradouro = logradouro;
		this.nm_cliente = nm_cliente;
		this.nr_cpf = nr_cpf;
		this.nm_email = nm_email;
	}

	public ClienteDTO(Cliente cliente) {
		this.id_cliente = cliente.getId_cliente();
		this.logradouro = cliente.getLogradouro();
		this.nm_cliente = cliente.getNm_cliente();
		this.nr_cpf = cliente.getNr_cpf();
		this.nm_email = cliente.getNm_email();
	}

	// Getters e Setters
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

	public String getNm_email() {
		return nm_email;
	}

	public void setNm_email(String nm_email) {
		this.nm_email = nm_email;
	}
}
