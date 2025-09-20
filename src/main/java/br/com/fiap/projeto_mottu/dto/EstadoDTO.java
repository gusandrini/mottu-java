package br.com.fiap.projeto_mottu.dto;

import br.com.fiap.projeto_mottu.model.Estado;
import br.com.fiap.projeto_mottu.model.Pais;

public class EstadoDTO {

	private Long idEstado;
	private Pais pais;
	private String nmEstado;

	public EstadoDTO() {}

	public EstadoDTO(Long idEstado, Pais pais, String nmEstado) {
		this.idEstado = idEstado;
		this.pais = pais;
		this.nmEstado = nmEstado;
	}

	public EstadoDTO(Estado estado) {
		this.idEstado = estado.getIdEstado();
		this.pais = estado.getPais();
		this.nmEstado = estado.getNmEstado();
	}

	// Getters e Setters
	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNmEstado() {
		return nmEstado;
	}

	public void setNmEstado(String nmEstado) {
		this.nmEstado = nmEstado;
	}
}
