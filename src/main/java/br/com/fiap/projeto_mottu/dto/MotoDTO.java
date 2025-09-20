package br.com.fiap.projeto_mottu.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_mottu.model.Cliente;
import br.com.fiap.projeto_mottu.model.FilialDepartamento;
import br.com.fiap.projeto_mottu.model.ModeloEnum;
import br.com.fiap.projeto_mottu.model.Moto;
import br.com.fiap.projeto_mottu.model.SituacaoEnum;

public class MotoDTO extends RepresentationModel<MotoDTO> {

	private Long idMoto;
	private Cliente cliente;
	private String nmPlaca;
	private ModeloEnum nmModelo;
	private FilialDepartamento filialDepartamento;
	private SituacaoEnum stMoto;
	private Double kmRodado;

	public MotoDTO() {}

	public MotoDTO(Long idMoto, Cliente cliente, String nmPlaca, ModeloEnum nmModelo,
				   FilialDepartamento filialDepartamento, SituacaoEnum stMoto, Double kmRodado) {
		this.idMoto = idMoto;
		this.cliente = cliente;
		this.nmPlaca = nmPlaca;
		this.nmModelo = nmModelo;
		this.filialDepartamento = filialDepartamento;
		this.stMoto = stMoto;
		this.kmRodado = kmRodado;
	}

	public MotoDTO(Moto moto) {
		this.idMoto = moto.getIdMoto();
		this.cliente = moto.getCliente();
		this.nmPlaca = moto.getNmPlaca();
		this.nmModelo = moto.getNmModelo();
		this.filialDepartamento = moto.getFilialDepartamento();
		this.stMoto = moto.getStMoto();
		this.kmRodado = moto.getKmRodado();
	}

	// Getters e Setters manuais
	public Long getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(Long idMoto) {
		this.idMoto = idMoto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNmPlaca() {
		return nmPlaca;
	}

	public void setNmPlaca(String nmPlaca) {
		this.nmPlaca = nmPlaca;
	}

	public ModeloEnum getNmModelo() {
		return nmModelo;
	}

	public void setNmModelo(ModeloEnum nmModelo) {
		this.nmModelo = nmModelo;
	}

	public FilialDepartamento getFilialDepartamento() {
		return filialDepartamento;
	}

	public void setFilialDepartamento(FilialDepartamento filialDepartamento) {
		this.filialDepartamento = filialDepartamento;
	}

	public SituacaoEnum getStMoto() {
		return stMoto;
	}

	public void setStMoto(SituacaoEnum stMoto) {
		this.stMoto = stMoto;
	}

	public Double getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(Double kmRodado) {
		this.kmRodado = kmRodado;
	}
}
