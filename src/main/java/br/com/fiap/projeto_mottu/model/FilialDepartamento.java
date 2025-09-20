package br.com.fiap.projeto_mottu.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "filial_departamento")
public class FilialDepartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_filial_departamento")
	private Long idFilialDepartamento;

	@ManyToOne
	@JoinColumn(name = "id_filial", nullable = false)
	@NotNull(message = "A filial departamento deve estar vinculada a uma filial")
	private Filial filial;

	@ManyToOne
	@JoinColumn(name = "id_departamento", nullable = false)
	@NotNull(message = "A filial departamento deve estar vinculada a um departamento")
	private Departamento departamento;

	@PastOrPresent
	@Column(name = "dt_entrada")
	@NotNull
	private LocalDate dtEntrada;

	@PastOrPresent
	@Column(name = "dt_saida")
	private LocalDate dtSaida;

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
