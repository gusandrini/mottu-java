package br.com.fiap.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "moto")
public class Moto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_moto;
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
    @NotNull(message = "A moto deve estar relacionada a um cliente!")
	private Cliente cliente;
    @Size(max = 10, message = "Valor da placa inválido")
	private String nm_placa;
    @NotEmpty(message = "Não é possível inserir uma moto sem seu modelo (Sport, E ou Pop)")
    @Enumerated(EnumType.STRING)
	private ModeloEnum nm_modelo;
    @Size(max = 20, message = "O status deve ter no máximo 20 caracteres")
	private String ds_status;
    @ManyToOne
    @JoinColumn(name = "id_filial", nullable = false)
    @NotNull(message = "A moto deve estar vinculada a uma filial")
	private Filial filial;
    @NotEmpty(message = "Não é possível inserir uma moto sem sua situação/condição (Manutenção, Funcionamento ou Pátio)")
    @Enumerated(EnumType.STRING)
	private SituacaoEnum st_moto;
	
	public Moto() {}

	public Moto(Long id_moto, @NotNull(message = "A moto deve estar relacionada a um cliente!") Cliente cliente,
			@Size(max = 10, message = "Valor da placa inválido") String nm_placa,
			@NotEmpty(message = "Não é possível inserir uma moto sem seu modelo (Sport, E ou Pop)") ModeloEnum nm_modelo,
			@Size(max = 20, message = "O status deve ter no máximo 20 caracteres") String ds_status,
			@NotNull(message = "A moto deve estar vinculada a uma filial") Filial filial,
			@NotEmpty(message = "Não é possível inserir uma moto sem sua situação/condição (Manutenção, Funcionamento ou Pátio)") SituacaoEnum st_moto) {
		super();
		this.id_moto = id_moto;
		this.cliente = cliente;
		this.nm_placa = nm_placa;
		this.nm_modelo = nm_modelo;
		this.ds_status = ds_status;
		this.filial = filial;
		this.st_moto = st_moto;
	}

	public Long getId_moto() {
		return id_moto;
	}

	public void setId_moto(Long id_moto) {
		this.id_moto = id_moto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNm_placa() {
		return nm_placa;
	}

	public void setNm_placa(String nm_placa) {
		this.nm_placa = nm_placa;
	}

	public ModeloEnum getNm_modelo() {
		return nm_modelo;
	}

	public void setNm_modelo(ModeloEnum nm_modelo) {
		this.nm_modelo = nm_modelo;
	}

	public String getDs_status() {
		return ds_status;
	}

	public void setDs_status(String ds_status) {
		this.ds_status = ds_status;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public SituacaoEnum getSt_moto() {
		return st_moto;
	}

	public void setSt_moto(SituacaoEnum st_moto) {
		this.st_moto = st_moto;
	}

	

	
	
	
	
	
}
