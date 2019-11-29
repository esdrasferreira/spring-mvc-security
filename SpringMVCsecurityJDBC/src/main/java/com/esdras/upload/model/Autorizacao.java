package com.esdras.upload.model;

import java.util.Date;

public class Autorizacao {

	private String usuario;
	private String autorizacao;
	private Date autorizado_em;
	private Date modificado_em;

	public Autorizacao() {
	}

	public Autorizacao(String usuario, String autorizacao, Date autorizado_em, Date modificado_em) {
		super();
		this.usuario = usuario;
		this.autorizacao = autorizacao;
		this.autorizado_em = autorizado_em;
		this.modificado_em = modificado_em;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public Date getAutorizado_em() {
		return autorizado_em;
	}

	public void setAutorizado_em(Date autorizado_em) {
		this.autorizado_em = autorizado_em;
	}

	public Date getModificado_em() {
		return modificado_em;
	}

	public void setModificado_em(Date modificado_em) {
		this.modificado_em = modificado_em;
	}

}
