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
@Table(name = "pais")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pais;
	@NotEmpty(message = "O nome do país deve ser informado")
    @Size(max = 50, message = "O estado deve ter no máximo 50 caracteres")
	private String nm_pais;
	
	public Pais() {}

	public Pais(Long id_pais,
			@NotEmpty(message = "O nome do país deve ser informado") @Size(max = 50, message = "O estado deve ter no máximo 50 caracteres") String nm_pais) {
		super();
		this.id_pais = id_pais;
		this.nm_pais = nm_pais;
	}

	public Long getId_pais() {
		return id_pais;
	}

	public void setId_pais(Long id_pais) {
		this.id_pais = id_pais;
	}

	public String getNm_pais() {
		return nm_pais;
	}

	public void setNm_pais(String nm_pais) {
		this.nm_pais = nm_pais;
	}
	
	
}
