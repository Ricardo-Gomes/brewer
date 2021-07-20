package com.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brewer.model.Cliente;

@Controller
public class ClientesController {

	@RequestMapping("/clientes/novo")
	public String novo(Cliente cliente) {
		return "cliente/CadastroCliente";
	}
	
	@RequestMapping(value = "/clientes/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cliente cliente, BindingResult bindingResult, 
			Model model, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute(cliente);
			return novo(cliente);
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Salvo com Sucesso!");
		return "redirect:/clientes/novo";
	}
}
