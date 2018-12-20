/**
 * 
 */
package com.herokuapp.autoportaria.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herokuapp.autoportaria.exceptions.PessoaException;
import com.herokuapp.autoportaria.model.entity.Pessoa;
import com.herokuapp.autoportaria.model.entity.factory.PessoaFactory;
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

		model.addAttribute("titulo", "Lista de cond&ocirc;minos ativos");
		model.addAttribute("listaPessoas", listaPessoas);
		model.addAttribute("listaTiposPessoa", ETipoPessoa.values());
		return "pessoa/listaPessoa";
	}

	@RequestMapping(value = "/condomino", method = RequestMethod.GET)
	public String listarCondominos(Model model) {
		List<Pessoa> listaCondominos = new ArrayList<Pessoa>();
		listaCondominos = pessoaRepositorio
				.retornaPessoaPorTipoPessoa(ETipoPessoa.CONDOMINO);
		model.addAttribute("titulo", "Condominos");
		model.addAttribute("listaCondominos", listaCondominos);
		return "pessoa/listaCondomino";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarPessoa(@Valid @ModelAttribute Pessoa pessoa,
			BindingResult bindingResult, Model model) {

		PessoaFactory pf = new PessoaFactory();
		String nomeCompleto = pf.gerarNomeCompleto(pessoa);
		pessoa.setNomeCompleto(nomeCompleto);
		pessoa.setDataCriacao(Calendar.getInstance());

		if (bindingResult.hasErrors()) {
			throw new PessoaException();
		} else {
			pessoaRepositorio.save(pessoa);
		}
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		listaPessoas = pessoaRepositorio.retornaTodasPessoasAtivas();
		model.addAttribute("titulo", "Lista de cond&ocirc;minos ativos");
		model.addAttribute("listaPessoas", listaPessoas);
		model.addAttribute("listaTiposPessoa", ETipoPessoa.values());
		return "pessoa/listaPessoa";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{idPessoa}")
	@ResponseBody
	public Pessoa buscarPessoa(@PathVariable Long idPessoa) {
		Pessoa pessoa = new Pessoa();
		pessoa = pessoaRepositorio.findOne(idPessoa);
		return pessoa;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{idPessoa}")
	public ResponseEntity<String> deletarPessoa(@PathVariable Long idPessoa) {
		try {
			pessoaRepositorio.delete(idPessoa);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}
