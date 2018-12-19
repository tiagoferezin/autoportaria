/**
 * 
 */
package com.herokuapp.autoportaria.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.herokuapp.autoportaria.model.entity.Pessoa;
import com.herokuapp.autoportaria.model.enumarator.ETipoPessoa;
import com.herokuapp.autoportaria.model.repositories.PessoaRepositorio;

/**
 * @author Tiago Ferezin Data: 17/12/2018
 */
@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	PessoaRepositorio pessoaRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listaPessoa(Model model) {
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		listaPessoas = pessoaRepositorio.retornaTodasPessoasAtivas();

		model.addAttribute("titulo", "Lista de condôminos ativos");
		model.addAttribute("listaPessoas", listaPessoas);
		return "pessoa/listaPessoa";
	}
	
	@RequestMapping(value = "/condomino", method = RequestMethod.GET)
	public String listarCondominos(Model model){
		List<Pessoa> listaCondominos = new ArrayList<Pessoa>();
		listaCondominos = pessoaRepositorio.retornaPessoaPorTipoPessoa(ETipoPessoa.CONDOMINO);
		model.addAttribute("titulo", "Condominos");
		model.addAttribute("listaCondominos", listaCondominos);
		return "pessoa/listaCondomino";
	}

}
