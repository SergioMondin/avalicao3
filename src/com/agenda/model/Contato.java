package com.agenda.model;

/**
 * @author SLM
 */
import java.io.Serializable;

public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String endereco;
	private String email;
	private Telefone telefone;

	public Contato() { // construtor NoArgs

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}
