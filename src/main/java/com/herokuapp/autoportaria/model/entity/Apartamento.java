/**
 * 
 */
package com.herokuapp.autoportaria.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin Data: 19/12/2018
 */
@Entity
public class Apartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idApartamento;

	@Column(nullable = false)
	private String apartamento;

	private String bloco;

	public Apartamento() {

	}

	/**
	 * @return the idApartamento
	 */
	public Long getIdApartamento() {
		return idApartamento;
	}

	/**
	 * @param idApartamento
	 *            the idApartamento to set
	 */
	public void setIdApartamento(Long idApartamento) {
		this.idApartamento = idApartamento;
	}

	/**
	 * @return the apartamento
	 */
	public String getApartamento() {
		return apartamento;
	}

	/**
	 * @param apartamento
	 *            the apartamento to set
	 */
	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	/**
	 * @return the bloco
	 */
	public String getBloco() {
		return bloco;
	}

	/**
	 * @param bloco
	 *            the bloco to set
	 */
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

}
