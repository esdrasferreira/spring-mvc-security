package com.esdras.upload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.esdras.upload.model.Autorizacao;
import com.esdras.upload.repository.DaoGenerico;

@Service
public class AutorizacaoService extends GenericService<Autorizacao> {

	@Autowired
	public AutorizacaoService(@Qualifier("autorizacaoDao") DaoGenerico<Autorizacao> daoGenerico) {
		super(daoGenerico);
	}

}
