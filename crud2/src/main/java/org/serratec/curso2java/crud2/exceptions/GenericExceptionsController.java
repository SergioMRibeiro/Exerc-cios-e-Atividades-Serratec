package org.serratec.curso2java.crud2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionsController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> trataGenericException(Exception exception){
		String msg = "Desculpe! Ocorreu uma excessão não esperada.";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.header("x-erro-msg", msg)
				.header("s-erro-code", "GENERIC_EXCEPTION")
				.build();
	}
}
