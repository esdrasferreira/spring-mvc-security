package com.esdras.upload.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DaoGenerico<T> {

	void salvar(T entidade);

	void excluir(T entidade);

	void atualizar(T entidade);

	List<T> todos();

	List<T> listar(T entidade);

	List<T> listarPorCategoria(int categoriaId);

	T pesquisarPorId(int id);

	T pesquisar(T entidade);

	List<T> listPorId(int id) throws Exception;

	Page<T> todosComPaginacao(Pageable pageable);

}
