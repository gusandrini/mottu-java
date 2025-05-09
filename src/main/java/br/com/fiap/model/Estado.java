package br.com.fiap.model;

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
@Table(name = "cidade")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estado;
	@ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    @NotNull(message = "O estado deve estar vinculado a um país")
	private Pais pais;
	@NotEmpty(message = "O nome do estado deve ser informado")
    @Size(min = 2, max = 2, message = "O estado deve conter exatamente 2 letras (UF)")
	private String nm_estado;
	
	public Estado () {}

	public Estado(Long id_estado, @NotNull(message = "O estado deve estar vinculado a um país") Pais pais,
			@NotEmpty(message = "O nome do estado deve ser informado") @Size(min = 2, max = 2, message = "O estado deve conter exatamente 2 letras (UF)") String nm_estado) {
		super();
		this.id_estado = id_estado;
		this.pais = pais;
		this.nm_estado = nm_estado;
	}

	public Long getId_estado() {
		return id_estado;
	}

	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNm_estado() {
		return nm_estado;
	}

	public void setNm_estado(String nm_estado) {
		this.nm_estado = nm_estado;
	}
	
	
}
