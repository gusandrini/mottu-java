package br.com.fiap.projeto_mottu.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_mottu.model.Manutencao;
import br.com.fiap.projeto_mottu.model.Moto;

public class ManutencaoDTO extends RepresentationModel<ManutencaoDTO> {

	private Long idManutencao;
	private Moto moto;
	private LocalDate dtEntrada;
	private LocalDate dtSaida;
	private String dsManutencao;

	public ManutencaoDTO() {}

	public ManutencaoDTO(Long idManutencao, Moto moto, LocalDate dtEntrada, LocalDate dtSaida, String dsManutencao) {
		this.idManutencao = idManutencao;
		this.moto = moto;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.dsManutencao = dsManutencao;
	}

	public ManutencaoDTO(Manutencao manutencao) {
		this.idManutencao = manutencao.getIdManutencao();
		this.moto = manutencao.getMoto();
		this.dtEntrada = manutencao.getDtEntrada();
		this.dtSaida = manutencao.getDtSaida();
		this.dsManutencao = manutencao.getDsManutencao();
	}

	// Getters e Setters manuais
	public Long getIdManutencao() {
		return idManutencao;
	}

	public void setIdManutencao(Long idManutencao) {
		this.idManutencao = idManutencao;
	}

	public Moto getMoto() {
		return moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	}

	public LocalDate getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(LocalDate dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public LocalDate getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(LocalDate dtSaida) {
		this.dtSaida = dtSaida;
	}

	public String getDsManutencao() {
		return dsManutencao;
	}

	public void setDsManutencao(String dsManutencao) {
		this.dsManutencao = dsManutencao;
	}
}
