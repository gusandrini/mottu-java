package br.com.fiap.projeto_mottu.dto;

import org.springframework.hateoas.RepresentationModel;
import br.com.fiap.projeto_mottu.model.Cidade;
import br.com.fiap.projeto_mottu.model.Estado;

public class CidadeDTO extends RepresentationModel<CidadeDTO> {

	private Long idCidade;
	private String nmCidade;
	private Estado estado;

	// Construtores
	public CidadeDTO() {}

	public CidadeDTO(Long idCidade, String nmCidade, Estado estado) {
		this.idCidade = idCidade;
		this.nmCidade = nmCidade;
		this.estado = estado;
	}

	public CidadeDTO(Cidade cidade) {
		this.idCidade = cidade.getIdCidade();
		this.nmCidade = cidade.getNmCidade();
		this.estado = cidade.getEstado();
	}

	// Getters e Setters manuais
	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getNmCidade() {
		return nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
