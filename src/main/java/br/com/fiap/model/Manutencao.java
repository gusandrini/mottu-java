package br.com.fiap.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "manutencao")
public class Manutencao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_manutencao;
	@ManyToOne
	@JoinColumn(name = "id_moto", nullable = false)
    @NotNull(message = "A manutenção tem que estar vinculada a uma moto!")
	private Moto moto;
	@PastOrPresent(message = "Data inválida")
	private LocalDate dt_entrada;
	@PastOrPresent(message = "Data inválida")
	private LocalDate dt_saida;
	@NotEmpty(message = "A descrição da manutenção da moto deve ser informada!")
    @Size(max = 300, message = "A descrição da manutenção deve ter no máximo 300 caracteres")
	private String ds_manutencao;
	
}
