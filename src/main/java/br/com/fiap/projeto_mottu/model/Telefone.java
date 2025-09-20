package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone")
	private Long idTelefone;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	@NotNull(message = "O telefone deve estar vinculado a um cliente")
	private Cliente cliente;

	@NotEmpty(message = "O número de telefone não pode estar em branco")
	@Size(max = 15, message = "O número de telefone deve ter no máximo 15 caracteres")
	@Column(name = "nr_telefone")
	private String nrTelefone;

	@NotEmpty(message = "O DDI não pode estar em branco")
	@Size(max = 4, message = "O DDI deve ter no máximo 4 caracteres")
	@Column(name = "nr_ddi")
	private String nrDdi;

	@NotEmpty(message = "O DDD não pode estar em branco")
	@Size(max = 5, message = "O DDD deve ter no máximo 5 caracteres")
	@Column(name = "nr_ddd")
	private String nrDdd;

	// Getters e Setters manuais
	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getNrDdi() {
		return nrDdi;
	}

	public void setNrDdi(String nrDdi) {
		this.nrDdi = nrDdi;
	}

	public String getNrDdd() {
		return nrDdd;
	}

	public void setNrDdd(String nrDdd) {
		this.nrDdd = nrDdd;
	}
}
