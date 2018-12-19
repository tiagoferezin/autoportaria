/**
 * 
 */
package com.herokuapp.autoportaria.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.autoportaria.model.entity.Pessoa;
import com.herokuapp.autoportaria.model.enumarator.ETipoPessoa;

/**
 * @author Tiago Ferezin
 * Data: 17/12/2018
 */
@Repository
public interface PessoaRepositorio extends CrudRepository<Pessoa, Long> {
	
	@Query("SELECT t FROM Pessoa t WHERE t.cpf = ? AND t.dataDesativacao IS NULL")
	public Pessoa retornaPessoaPeloCPF(String  cpf);
	
	@Query("SELECT t FROM Pessoa t WHERE t.nomeCompleto LIKE '%?%' AND t.dataDesativacao IS NULL")
	public List<Pessoa> retornaPessoaPeloNome(String nome);
	
	@Query("SELECT t FROM Pessoa t WHERE t.tipoPessoa = ? AND t.dataDesativacao IS NULL")
	public List<Pessoa> retornaPessoaPorTipoPessoa(ETipoPessoa tipoPessoa);
	
	@Query("SELECT t FROM Pessoa t WHERE t.dataDesativacao IS NULL")
	public List<Pessoa> retornaTodasPessoasAtivas();

}
