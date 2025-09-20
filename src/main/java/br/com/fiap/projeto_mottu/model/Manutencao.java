package br.com.fiap.projeto_mottu.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "manutencao")
public class Manutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_manutencao")
	private Long idManutencao;

	@ManyToOne
	@JoinColumn(name = "id_moto", nullable = false)
	@NotNull(message = "A manutenção tem que estar vinculada a uma moto!")
	private Moto moto;

	@NotNull
	@PastOrPresent(message = "Data inválida")
	@Column(name = "dt_entrada")
	private LocalDate dtEntrada;

	@PastOrPresent(message = "Data inválida")
	@Column(name = "dt_saida")
	private LocalDate dtSaida;

	@NotEmpty(message = "A descrição da manutenção da moto deve ser informada!")
	@Size(max = 300, message = "A descrição da manutenção deve ter no máximo 300 caracteres")
	@Column(name = "ds_manutencao")
	private String dsManutencao;

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
