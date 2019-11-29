package com.esdras.upload.controlador;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

//	@Autowired
//	private UsuarioService usuarioService;
//
//	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
//	public ModelAndView login(@RequestParam("email") String email, @RequestParam("senha") String senha,
//			HttpSession session, ModelMap modelMap, ModelAndView model) {
//
//		if (email != null && email != "" && senha != null && senha != "") {
//
//			Usuario usuario = new Usuario();
//			usuario.setEmail(email);
//			usuario.setSenha(senha);
//
//			usuario = (Usuario) usuarioService.pesquisar(usuario);
//			if (usuario == null) {
//				model.setViewName("index");
//			} else {
//				session.setAttribute("usuario", usuario);
//				model.setViewName("redirect:/index");
//			}
//
//		}
//
//		return model;
//
//	}
}
