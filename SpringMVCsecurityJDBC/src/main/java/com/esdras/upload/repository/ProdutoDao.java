package com.esdras.upload.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.esdras.upload.model.Produto;

@Repository
public class ProdutoDao implements DaoGenerico<Produto> {

	private JdbcTemplate jdbcTemplate;

	public ProdutoDao(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void salvar(Produto entidade) {
		jdbcTemplate.update("");

	}

	@Override
	public void excluir(Produto entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Produto entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Produto> todos() {
		String sql = "SELECT * FROM `spring-security`.produtos";

		List<Produto> produtos = jdbcTemplate.query(sql, new RowMapper<Produto>() {

			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {

				Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getDouble(3));

				return produto;

			}
		});

		return produtos;
	}

	@Override
	public List<Produto> listar(Produto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listarPorCategoria(int categoriaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto pesquisarPorId(int id) {
		String sql = "SELECT * FROM andregon_ecommerce.clientes where clienteId = '" + id + "'";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Produto.class));
	}

	@Override
	public Produto pesquisar(Produto entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Produto> todosComPaginacao(Pageable pageable) {
		String rowCountSql = "select count(1)as total from produtos";
		int total = jdbcTemplate.queryForObject(rowCountSql, (rs, numRows) -> rs.getInt(1));

		String sql = "SELECT * FROM `spring-security`.produtos\n" + "order by produtos.idprodutos desc limit "
				+ pageable.getPageSize() + " " + "offset " + pageable.getOffset();

//		String sql = "SELECT * from produtos " + "LIMIT " + pageable.getPageSize() + " " + "OFFSET "
//				+ pageable.getOffset();

		List<Produto> produtos = jdbcTemplate.query(sql, new RowMapper<Produto>() {

			public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {

				Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getDouble(3));

				return produto;

			}
		});

		return new PageImpl<>(produtos, pageable, total);
	}

}
