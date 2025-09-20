package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.Column;
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
public class CidadeController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cidade;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    @NotNull(message = "A cidade deve estar vinculada a um estado")
    private Estado estado;

    @NotEmpty(message = "O nome da cidade deve ser informado")
    @Size(max = 50, message = "O nome da cidade deve ter no máximo 50 caracteres")
    @Column(name = "nm_cidade")
    private String nm_cidade;

    // Construtores
    public CidadeController() {}

    public CidadeController(Long id_cidade, Estado estado, String nm_cidade) {
        this.id_cidade = id_cidade;
        this.estado = estado;
        this.nm_cidade = nm_cidade;
    }

    // Getters e Setters
    public Long getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(Long id_cidade) {
        this.id_cidade = id_cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNm_cidade() {
        return nm_cidade;
    }

    public void setNm_cidade(String nm_cidade) {
        this.nm_cidade = nm_cidade;
    }
}
