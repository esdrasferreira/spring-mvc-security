package com.esdras.upload.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.esdras.upload.model.Usuario;

@Repository
public class UsuarioDao implements DaoGenerico<Usuario> {

	private JdbcTemplate jdbcTemplate;

	public UsuarioDao(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void salvar(Usuario entidade) {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String dataCriacao = data.format(entidade.getCriado_em());

		String status;

		if (entidade.getAtivo()) {
			status = "1";
		} else {
			status = "0";
		}

		jdbcTemplate.update(
				"INSERT INTO `spring-security`.`usuarios` (`usuario`, `email`, `senha`, `ativo`, `criado_em`) VALUES (?, ?, ?, ?, str_to_date('"
						+ dataCriacao + "', '%d/%m/%Y %H:%i:%s'))\n" + "",
				entidade.getUsuario(), entidade.getEmail(), entidade.getSenha(), status);

	}

	@Override
	public void excluir(Usuario entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Usuario entidade) {

		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String dataCriacao = data.format(entidade.getCriado_em());

		String status;

		if (entidade.getAtivo()) {
			status = "1";
		} else {
			status = "0";
		}

		jdbcTemplate.update(
				"INSERT INTO `spring-security`.`usuarios` (`usuario`, `email`, `senha`, `ativo`, `criado_em`) VALUES (?, ?, ?, ?, ?);\n"
						+ "",
				entidade.getUsuario(), entidade.getEmail(), entidade.getSenha(), status, dataCriacao);

	}

	@Override
	public List<Usuario> todos() {
		String sql = "SELECT * FROM `spring-security`.usuarios";

		List<Usuario> usuarios = jdbcTemplate.query(sql, new RowMapper<Usuario>() {

			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

				Usuario usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
						rs.getDate(5), rs.getDate(6));

				return usuario;

			}
		});

		return usuarios;
	}

	@Override
	public List<Usuario> listar(Usuario entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listarPorCategoria(int categoriaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario pesquisarPorId(int id) {
		String sql = "SELECT * FROM andregon_ecommerce.clientes where clienteId = '" + id + "'";
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Usuario.class));
	}

	@Override
	public Usuario pesquisar(Usuario entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Usuario> todosComPaginacao(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
