package com.esdras.upload.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.esdras.upload.repository.DaoGenerico;

public abstract class GenericService<T> {

	private DaoGenerico<T> dao;
	private int paginas = 0;
	private int totalEncontrado = 0;

	public GenericService() {

	}

	public GenericService(DaoGenerico<T> dao) {
		this.dao = dao;
	}

	public void salvar(T entidade) {
		try {
			dao.salvar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void excluir(T entidade) {
		try {
			dao.excluir(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void atualizar(T entidade) {

		try {
			dao.atualizar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public T pesquisar(T entidade) {
		T ent = null;

		try {
			ent = (T) dao.pesquisar(entidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ent;
	}

	public List<T> todos() {
		List<T> entidades = null;

		try {
			entidades = dao.todos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entidades;
	}

	public T pesquisarPorId(int id) {

		T entidade = null;
		try {
			entidade = (T) dao.pesquisarPorId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return entidade;

	}

	public List<T> listPorId(int produtoId) {

		List<T> entidades = null;
		try {
			entidades = dao.listPorId(produtoId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entidades;

	}

	public List<T> listarPorCategoria(int categoriaId) {

		List<T> entidades = null;
		try {

			entidades = dao.listarPorCategoria(categoriaId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return entidades;

	}

	public List<T> todosComPaginacao(Integer pagina, int totalPorPagina) {
		List<T> entidades = null;

		if (pagina != null && pagina > 0) {
			pagina -= 1;
		}

		try {

			Pageable pageable = PageRequest.of(pagina, totalPorPagina);

			Page<T> dataPage = dao.todosComPaginacao(pageable);

			this.paginas = dataPage.getTotalPages();

			entidades = dataPage.getContent();

			this.totalEncontrado = (int) dataPage.getTotalElements();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return entidades;

	}

	public int getTotalEncontrado() {
		return this.totalEncontrado;
	}

	public int getPaginas() {
		return this.paginas;
	}

}
