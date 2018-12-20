/**
 * 
 */
package com.herokuapp.autoportaria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tiago Ferezin
 * Data: 19/12/2018
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class PessoaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 236900907623280824L;

	

}
