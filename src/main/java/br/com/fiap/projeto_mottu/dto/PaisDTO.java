package br.com.fiap.projeto_mottu.dto;

import br.com.fiap.projeto_mottu.model.Pais;

public class PaisDTO {

	private Long idPais;
	private String nmPais;

	public PaisDTO() {}

	public PaisDTO(Long idPais, String nmPais) {
		this.idPais = idPais;
		this.nmPais = nmPais;
	}

	public PaisDTO(Pais pais) {
		this.idPais = pais.getIdPais();
		this.nmPais = pais.getNmPais();
	}

	// Getters e Setters manuais
	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getNmPais() {
		return nmPais;
	}

	public void setNmPais(String nmPais) {
		this.nmPais = nmPais;
	}
}
