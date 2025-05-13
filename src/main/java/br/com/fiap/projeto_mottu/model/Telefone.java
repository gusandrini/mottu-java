package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_telefone;
	@ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @NotNull(message = "O telefone deve estar vinculado a um cliente")
	private Cliente cliente;
	@NotBlank(message = "O número de telefone não pode estar em branco")
    @Size(max = 15, message = "O número de telefone deve ter no máximo 15 caracteres")
	private String nr_telefone;
	@NotBlank(message = "O DDI não pode estar em branco")
    @Size(max = 4, message = "O DDI deve ter no máximo 4 caracteres")
	private String nr_ddi;
	@NotBlank(message = "O DDD não pode estar em branco")
    @Size(max = 5, message = "O DDD deve ter no máximo 5 caracteres")
	private String nr_ddd;
	
	public Telefone() {}

	public Telefone(Long id_telefone,
			@NotNull(message = "O telefone deve estar vinculado a um cliente") Cliente cliente,
			@NotBlank(message = "O número de telefone não pode estar em branco") @Size(max = 15, message = "O número de telefone deve ter no máximo 15 caracteres") String nr_telefone,
			@NotBlank(message = "O DDI não pode estar em branco") @Size(max = 4, message = "O DDI deve ter no máximo 4 caracteres") String nr_ddi,
			@NotBlank(message = "O DDD não pode estar em branco") @Size(max = 5, message = "O DDD deve ter no máximo 5 caracteres") String nr_ddd) {
		super();
		this.id_telefone = id_telefone;
		this.cliente = cliente;
		this.nr_telefone = nr_telefone;
		this.nr_ddi = nr_ddi;
		this.nr_ddd = nr_ddd;
	}

	public Long getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(Long id_telefone) {
		this.id_telefone = id_telefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNr_telefone() {
		return nr_telefone;
	}

	public void setNr_telefone(String nr_telefone) {
		this.nr_telefone = nr_telefone;
	}

	public String getNr_ddi() {
		return nr_ddi;
	}

	public void setNr_ddi(String nr_ddi) {
		this.nr_ddi = nr_ddi;
	}

	public String getNr_ddd() {
		return nr_ddd;
	}

	public void setNr_ddd(String nr_ddd) {
		this.nr_ddd = nr_ddd;
	}
	
	
	
}
