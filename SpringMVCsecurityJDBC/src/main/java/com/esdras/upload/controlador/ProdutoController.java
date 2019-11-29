package com.esdras.upload.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.upload.model.Produto;
import com.esdras.upload.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(value = "pagina", required = false) Integer page_num,

			ModelAndView model) {

		int totalPorPagina = 5;

		if (page_num == null) {
			page_num = 1;
		}

		List<Produto> produtos = produtoService.todosComPaginacao(page_num, totalPorPagina);

		model.addObject("produtos", produtos);
		model.addObject("totalEncontrado", produtoService.getTotalEncontrado());
		model.addObject("numeroDePaginas", produtoService.getPaginas());
		model.addObject("pagina", page_num);

		model.setViewName("index");

		return model;
	}
}// END ProdutoController