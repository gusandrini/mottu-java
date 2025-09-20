package br.com.fiap.projeto_mottu.dto;

import br.com.fiap.projeto_mottu.model.Cliente;
import br.com.fiap.projeto_mottu.model.Telefone;

public class TelefoneDTO {

	private Long idTelefone;
	private Cliente cliente;
	private String nrTelefone;
	private String nrDdi;
	private String nrDdd;

	public TelefoneDTO() {}

	public TelefoneDTO(Long idTelefone, Cliente cliente, String nrTelefone, String nrDdi, String nrDdd) {
		this.idTelefone = idTelefone;
		this.cliente = cliente;
		this.nrTelefone = nrTelefone;
		this.nrDdi = nrDdi;
		this.nrDdd = nrDdd;
	}

	public TelefoneDTO(Telefone telefone) {
		this.idTelefone = telefone.getIdTelefone();
		this.cliente = telefone.getCliente();
		this.nrTelefone = telefone.getNrTelefone();
		this.nrDdi = telefone.getNrDdi();
		this.nrDdd = telefone.getNrDdd();
	}

	// Getters e Setters manuais
	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getNrDdi() {
		return nrDdi;
	}

	public void setNrDdi(String nrDdi) {
		this.nrDdi = nrDdi;
	}

	public String getNrDdd() {
		return nrDdd;
	}

	public void setNrDdd(String nrDdd) {
		this.nrDdd = nrDdd;
	}
}
