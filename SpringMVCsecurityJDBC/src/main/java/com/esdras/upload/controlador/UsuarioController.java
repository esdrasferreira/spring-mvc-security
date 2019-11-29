package com.esdras.upload.controlador;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.esdras.upload.model.Usuario;
import com.esdras.upload.service.UsuarioService;

@Controller
public class UsuarioController {

	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = { "/cadastrar" }, method = RequestMethod.POST)
	public ModelAndView cadastrar(@RequestParam("usuario") String user, @RequestParam("email") String email,
			@RequestParam("senha") String senha,

			HttpSession session, ModelMap modelMap, ModelAndView model) {

		Date data = new Date();

		Usuario usuario = new Usuario();
		usuario.setUsuario(user);
		usuario.setEmail(email);
		usuario.setSenha(new BCryptPasswordEncoder().encode(senha));
		usuario.setAtivo(true);
		usuario.setCriado_em(data);

		usuarioService.salvar(usuario);

		session.setAttribute("usuario", usuario);
		model.addObject("cadastrado", true);
		model.setViewName("/seguranca/index");

		return model;

	}

}
