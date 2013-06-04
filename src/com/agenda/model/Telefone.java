package com.agenda.model;

/**
 * @author SLM
 */
import java.io.Serializable;

public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String residencial;
	private String celular;
	private int id_contato;

	public Telefone() { // construtor NoArgs

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResidencial() {
		return residencial;
	}

	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getId_contato() {
		return id_contato;
	}

	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}

}
