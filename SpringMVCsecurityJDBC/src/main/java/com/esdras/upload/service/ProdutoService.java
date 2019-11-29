package com.esdras.upload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.esdras.upload.model.Produto;
import com.esdras.upload.repository.DaoGenerico;

@Service
public class ProdutoService extends GenericService<Produto> {

	@Autowired
	public ProdutoService(@Qualifier("produtoDao") DaoGenerico<Produto> daoGenerico) {
		super(daoGenerico);
	}

}
