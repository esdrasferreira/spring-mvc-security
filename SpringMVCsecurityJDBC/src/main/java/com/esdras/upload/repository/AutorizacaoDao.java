package com.esdras.upload.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.esdras.upload.model.Autorizacao;

@Repository
public class AutorizacaoDao implements DaoGenerico<Autorizacao> {

	private JdbcTemplate jdbcTemplate;

	public AutorizacaoDao(@Autowired DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void salvar(Autorizacao entidade) {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String dataAutorizacao = data.format(entidade.getAutorizado_em());
		String dataModificacao = data.format(entidade.getModificado_em());

		String role = entidade.getAutorizacao();

		if (role == "" || role == null) {
			role = "ROLE_USER";
		}

		jdbcTemplate.update("INSERT INTO autorizacoes (usuario, autorizacao, autorizado_em,modificado_em) \n"
				+ "values (?, ?, str_to_date(" + dataAutorizacao + "', '%d/%m/%Y %H:%i:%s'),str_to_date('"
				+ dataModificacao + "', '%d/%m/%Y %H:%i:%s'))\n" + "", entidade.getUsuario(), role);

	}

	@Override
	public void excluir(Autorizacao entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Autorizacao entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Autorizacao> todos() {
		String sql = "SELECT * FROM `spring-security`.autorizacoes";

		List<Autorizacao> autorizacoes = jdbcTemplate.query(sql, new RowMapper<Autorizacao>() {

			public Autorizacao mapRow(ResultSet rs, int rowNum) throws SQLException {

				Autorizacao autorizacao = new Autorizacao(rs.getString(1), rs.getString(2), rs.getDate(3),
						rs.getDate(4));
				System.out.println("|||||||||||Autorizado em: " + autorizacao.getAutorizado_em());
				return autorizacao;

			}
		});

		return autorizacoes;
	}

	@Override
	public List<Autorizacao> listar(Autorizacao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autorizacao> listarPorCategoria(int categoriaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autorizacao pesquisarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autorizacao pesquisar(Autorizacao entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autorizacao> listPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Autorizacao> todosComPaginacao(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
