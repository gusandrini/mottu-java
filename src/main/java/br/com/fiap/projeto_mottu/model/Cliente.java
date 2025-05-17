package br.com.fiap.projeto_mottu.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente extends RepresentationModel<Cliente>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	
	@OneToOne
    @JoinColumn(name = "id_logradouro", nullable = false)
    @NotNull(message = "O cliente deve estar relacionado a um logradouro")
	private Logradouro logradouro;
	
	@NotEmpty(message = "O nome do cliente deve ser informado!")
    @Size(max = 100, message = "O nome do cliente deve ter no máximo 100 caracteres")
	private String nm_cliente;
	@Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
	private String nr_cpf;
	@Email(message = "Email deve ser válido")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
	private String nm_email;
	
}
