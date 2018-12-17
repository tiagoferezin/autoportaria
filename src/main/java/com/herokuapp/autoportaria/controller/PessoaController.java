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

	@RequestMapping(value = "/listaPessoas/", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String listaPessoas() {
		String retorno = "";
		List<Pessoa> listaRetorno = new ArrayList<Pessoa>();
		listaRetorno = pessoaRepositorio.retornaTodasPessoasAtivas();
		
		Gson gson = new Gson();
		
		retorno = gson.toJson(listaRetorno);

		return retorno;
	}
	
	@RequestMapping(value = "/cadastroPessoa/", method = RequestMethod.GET)
	public String cadastroPessoa(Model model){
		
		model.addAttribute("listaTipoPessoa", ETipoPessoa.values());
		return "";
	}

}
