package com.esdras.upload.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("log")
	public ModelAndView log(ModelAndView model) {
		model.setViewName("seguranca/index");
		return model;
	}

	@GetMapping("/cadastro")
	public ModelAndView cadastro(ModelAndView model) {
		model.setViewName("cadastro");
		return model;
	}

}
