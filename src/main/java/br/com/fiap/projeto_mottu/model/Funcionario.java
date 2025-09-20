package br.com.fiap.projeto_mottu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;

    @NotEmpty
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(name = "nm_funcionario", nullable = false)
    private String nome;

    @NotEmpty
    @Email(message = "O e-mail deve ser válido")
    @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres")
    @Column(name = "nm_email_corporativo", nullable = false, unique = true)
    private String emailCorporativo;

    @NotEmpty
    @Size(max = 225, message = "A senha deve ter no máximo 225 caracteres")
    @Column(name = "nm_senha", nullable = false)
    private String senhaHash; // BCrypt

    @NotEmpty
    @Size(max = 50, message = "O nome do cargo deve ter no máximo 50 caracteres")
    @Column(name = "nm_cargo", nullable = false)
    private String cargo;

    // Getters e Setters corretos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
