package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.Entity;
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
@Table(name = "logradouro")
public class Logradouro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_logradouro;
	@ManyToOne
    @JoinColumn(name = "id_bairro", nullable = false)
    @NotNull(message = "O logradouro deve estar vinculado a um bairro")
	private Bairro bairro;
	@NotEmpty(message = "O nome do logradouro deve ser informado")
    @Size(max = 100, message = "O logradouro deve ter no máximo 100 caracteres")
	private String nm_logradouro;
	@NotEmpty(message = "O número do logradouro deve ser informado")
    @Size(max = 10, message = "O número do logradouro deve ter no máximo 10 caracteres")
	private Integer nr_logradouro;
	@Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres")
	private String complemento;
	
	
	public Logradouro() {}


	public Logradouro(Long id_logradouro,
			@NotNull(message = "O logradouro deve estar vinculado a um bairro") Bairro bairro,
			@NotEmpty(message = "O nome do logradouro deve ser informado") @Size(max = 100, message = "O logradouro deve ter no máximo 100 caracteres") String nm_logradouro,
			@NotEmpty(message = "O número do logradouro deve ser informado") @Size(max = 10, message = "O número do logradouro deve ter no máximo 10 caracteres") Integer nr_logradouro,
			@Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres") String complemento) {
		super();
		this.id_logradouro = id_logradouro;
		this.bairro = bairro;
		this.nm_logradouro = nm_logradouro;
		this.nr_logradouro = nr_logradouro;
		this.complemento = complemento;
	}


	public Long getId_logradouro() {
		return id_logradouro;
	}


	public void setId_logradouro(Long id_logradouro) {
		this.id_logradouro = id_logradouro;
	}


	public Bairro getBairro() {
		return bairro;
	}


	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}


	public String getNm_logradouro() {
		return nm_logradouro;
	}


	public void setNm_logradouro(String nm_logradouro) {
		this.nm_logradouro = nm_logradouro;
	}


	public Integer getNr_logradouro() {
		return nr_logradouro;
	}


	public void setNr_logradouro(Integer nr_logradouro) {
		this.nr_logradouro = nr_logradouro;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	
	
}
