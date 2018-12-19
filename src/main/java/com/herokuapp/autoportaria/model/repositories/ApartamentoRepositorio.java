/**
 * 
 */
package com.herokuapp.autoportaria.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.autoportaria.model.entity.Apartamento;

/**
 * @author Tiago Ferezin Data: 19/12/2018
 */
@Repository
public interface ApartamentoRepositorio extends
		CrudRepository<Apartamento, Long> {

	@Query("SELECT t FROM Apartamento t WHERE t.bloco = ?")
	public List<Apartamento> getApartamentosPorBloco(String bloco);

}
