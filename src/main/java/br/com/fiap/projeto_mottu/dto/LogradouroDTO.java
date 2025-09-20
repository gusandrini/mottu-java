package br.com.fiap.projeto_mottu.dto;

import br.com.fiap.projeto_mottu.model.Bairro;
import br.com.fiap.projeto_mottu.model.Logradouro;

public class LogradouroDTO {

	private Long idLogradouro;
	private Bairro bairro;
	private String nmLogradouro;
	private Integer nrLogradouro;
	private String complemento;

	public LogradouroDTO() {}

	public LogradouroDTO(Long idLogradouro, Bairro bairro, String nmLogradouro, Integer nrLogradouro, String complemento) {
		this.idLogradouro = idLogradouro;
		this.bairro = bairro;
		this.nmLogradouro = nmLogradouro;
		this.nrLogradouro = nrLogradouro;
		this.complemento = complemento;
	}

	public LogradouroDTO(Logradouro logradouro) {
		this.idLogradouro = logradouro.getIdLogradouro();
		this.bairro = logradouro.getBairro();
		this.nmLogradouro = logradouro.getNmLogradouro();
		this.nrLogradouro = logradouro.getNrLogradouro();
		this.complemento = logradouro.getComplemento();
	}

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
