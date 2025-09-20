package br.com.fiap.projeto_mottu.dto;

import org.springframework.hateoas.RepresentationModel;

import br.com.fiap.projeto_mottu.model.Filial;
import br.com.fiap.projeto_mottu.model.Funcionario;

public class FuncionarioDTO extends RepresentationModel<FuncionarioDTO> {

	private Long id;
	private Filial filial;
	private String nome;
	private String emailCorporativo;
	private String senhaHash;
	private String cargo;

	public FuncionarioDTO() {}

	public FuncionarioDTO(Long id, Filial filial, String nome, String emailCorporativo,
						  String senhaHash, String cargo) {
		super();
		this.id = id;
		this.filial = filial;
		this.nome = nome;
		this.emailCorporativo = emailCorporativo;
		this.senhaHash = senhaHash;
		this.cargo = cargo;
	}

	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.emailCorporativo = funcionario.getEmailCorporativo();
		this.senhaHash = funcionario.getSenhaHash();
		this.cargo = funcionario.getCargo();
	}

	// Getters e Setters
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
