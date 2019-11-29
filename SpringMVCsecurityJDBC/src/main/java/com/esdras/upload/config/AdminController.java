package com.esdras.upload.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.upload.model.Autorizacao;
import com.esdras.upload.model.Produto;
import com.esdras.upload.model.Usuario;
import com.esdras.upload.service.AutorizacaoService;
import com.esdras.upload.service.ProdutoService;
import com.esdras.upload.service.UsuarioService;

@Controller
@RequestMapping("/seguranca**")
public class AdminController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AutorizacaoService autorizacaoService;

	@GetMapping("/login")
	public ModelAndView login(@RequestParam(required = false) String error,
			@RequestParam(value = "pagina", required = false) Integer page_num, ModelAndView model) {
		if (error != null) {
			model.addObject("erro", true);
			model.setViewName("/seguranca/index");
		} else {

			int totalPorPagina = 5;

			if (page_num == null) {
				page_num = 1;
			}

			List<Produto> produtos = produtoService.todosComPaginacao(page_num, totalPorPagina);

			List<Usuario> usuarios = usuarioService.todos();

			List<Autorizacao> autorizacoes = autorizacaoService.todos();

			model.addObject("autorizacoes", autorizacoes);
			model.addObject("usuarios", usuarios);
			model.addObject("produtos", produtos);
			model.addObject("totalEncontrado", produtoService.getTotalEncontrado());
			model.addObject("numeroDePaginas", produtoService.getPaginas());
			model.addObject("pagina", page_num);

			model.setViewName("/seguranca/editar");
		}

		return model;
	}

	@GetMapping("/index")
	public ModelAndView index(ModelAndView model) {
		model.setViewName("seguranca/index");
		return model;
	}

	@GetMapping("/negado")
	public ModelAndView negado(ModelAndView model) {
		model.setViewName("negado");
		return model;
	}

	@GetMapping("/logado")
	@Secured({ "ROLE_ADMIN", "ROLE_MANAGER" })
	public ModelAndView logado(ModelAndView model) {
		model.setViewName("seguranca/logado");
		return model;
	}

	@GetMapping("/editar")
	@Secured({ "ROLE_ADMIN", "ROLE_MANAGER" })
	public ModelAndView editar(@RequestParam(required = false) String error,
			@RequestParam(value = "pagina", required = false) Integer page_num, ModelAndView model) {
		if (error != null) {
			model.addObject("erro", true);
			model.setViewName("/seguranca/index");
		} else {

			int totalPorPagina = 5;

			if (page_num == null) {
				page_num = 1;
			}

			List<Produto> produtos = produtoService.todosComPaginacao(page_num, totalPorPagina);

			model.addObject("produtos", produtos);
			model.addObject("totalEncontrado", produtoService.getTotalEncontrado());
			model.addObject("numeroDePaginas", produtoService.getPaginas());
			model.addObject("pagina", page_num);

			model.setViewName("/seguranca/editar");
		}

		return model;
	}

	@GetMapping("/dados/editar")
	@Secured({ "ROLE_ADMIN" })
	public ModelAndView editar(ModelAndView model) {
		model.setViewName("seguranca/editar");
		return model;
	}

}
