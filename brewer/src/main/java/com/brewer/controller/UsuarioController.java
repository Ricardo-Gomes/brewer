package com.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brewer.model.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("/usuarios/novo")
	public String novo(Usuario usuario) {
		return "usuario/CadastroUsuario";
	}
	
	@RequestMapping(value = "/usuarios/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute(usuario);
			return novo(usuario);
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Salvo com Sucesso!");
		return "redirect:/usuarios/novo";
	}
}
