/**
 * 
 */
package com.herokuapp.autoportaria.model.entity.factory;

import com.herokuapp.autoportaria.model.entity.Pessoa;
import com.herokuapp.autoportaria.utils.Normalizacao;

/**
 * @author Tiago Ferezin Data: 17/12/2018
 */
public class PessoaFactory {

	public String gerarNomeCompleto(Pessoa pessoa) {
		String retorno = "";
		String primeiroNome = pessoa.getPrimeiroNome();
		primeiroNome = primeiroNome.trim();
		primeiroNome = Normalizacao.capitalizarPalavra(primeiroNome);
		String nomeMeio = pessoa.getNomeMeio();
		String sobrenome = pessoa.getSobrenome();
		sobrenome = Normalizacao.capitalizarPalavra(sobrenome);
		if ((nomeMeio.length() > 0) && (!nomeMeio.isEmpty())) {
			nomeMeio = Normalizacao.capitalizarTexto(nomeMeio);
			retorno = primeiroNome + " " + nomeMeio + " " + sobrenome;
		} else {
			retorno = primeiroNome + " " + sobrenome;
		}

		return retorno;
	}

}
