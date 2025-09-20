package br.com.fiap.projeto_mottu.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_mottu.model.Departamento;
import br.com.fiap.projeto_mottu.model.Filial;
import br.com.fiap.projeto_mottu.model.FilialDepartamento;

public class FilialDepartamentoDTO extends RepresentationModel<FilialDepartamentoDTO> {

	private Long idFilialDepartamento;
	private Filial filial;
	private Departamento departamento;
	private LocalDate dtEntrada;
	private LocalDate dtSaida;

	public FilialDepartamentoDTO() {}

	public FilialDepartamentoDTO(Long idFilialDepartamento, Filial filial, Departamento departamento,
								 LocalDate dtEntrada, LocalDate dtSaida) {
		this.idFilialDepartamento = idFilialDepartamento;
		this.filial = filial;
		this.departamento = departamento;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
	}

	public FilialDepartamentoDTO(FilialDepartamento filialDepartamento) {
		this.idFilialDepartamento = filialDepartamento.getIdFilialDepartamento();
		this.filial = filialDepartamento.getFilial();
		this.departamento = filialDepartamento.getDepartamento();
		this.dtEntrada = filialDepartamento.getDtEntrada();
		this.dtSaida = filialDepartamento.getDtSaida();
	}

	// Getters e Setters manuais
	public Long getIdFilialDepartamento() {
		return idFilialDepartamento;
	}

	public void setIdFilialDepartamento(Long idFilialDepartamento) {
		this.idFilialDepartamento = idFilialDepartamento;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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
}
