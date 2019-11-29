package com.esdras.upload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.esdras.upload.model.Usuario;
import com.esdras.upload.repository.DaoGenerico;

@Service
public class UsuarioService extends GenericService<Usuario> {

	@Autowired
	public UsuarioService(@Qualifier("usuarioDao") DaoGenerico<Usuario> daoGenerico) {
		super(daoGenerico);
	}

}
