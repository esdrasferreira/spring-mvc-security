package com.esdras.upload.model;

import java.util.Date;

public class Usuario {

	private String usuario;
	private String email;
	private String senha;
	private Boolean ativo;
	private Date criado_em;
	private Date atualizado_em;

	public Usuario() {
	}

	public Usuario(String usuario, String email, String senha, Boolean ativo, Date criado_em, Date atualizado_em) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
		this.criado_em = criado_em;
		this.atualizado_em = atualizado_em;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(Date criado_em) {
		this.criado_em = criado_em;
	}

	public Date getAtualizado_em() {
		return atualizado_em;
	}

	public void setAtualizado_em(Date atualizado_em) {
		this.atualizado_em = atualizado_em;
	}

}
