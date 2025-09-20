package br.com.fiap.projeto_mottu.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_mottu.model.Filial;
import br.com.fiap.projeto_mottu.model.Logradouro;

public class FilialDTO extends RepresentationModel<FilialDTO> {

	private Long idFilial;
	private Logradouro logradouro;
	private String nomeFilial;

	public FilialDTO() {}

	public FilialDTO(Long idFilial, Logradouro logradouro, String nomeFilial) {
		this.idFilial = idFilial;
		this.logradouro = logradouro;
		this.nomeFilial = nomeFilial;
	}

	public FilialDTO(Filial filial) {
		this.idFilial = filial.getIdFilial();
		this.logradouro = filial.getLogradouro();
		this.nomeFilial = filial.getNomeFilial();
	}

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
