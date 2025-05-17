package br.com.fiap.projeto_mottu.model;

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
import lombok.Data;

@Entity
@Table(name = "moto")
@Data
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
	
}
