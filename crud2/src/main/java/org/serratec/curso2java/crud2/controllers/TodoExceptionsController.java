package org.serratec.curso2java.crud2.controllers;

import org.serratec.curso2java.crud2.exceptions.TodoIdInvalidoException;
import org.serratec.curso2java.crud2.exceptions.TodoNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TodoExceptionsController {

	@ExceptionHandler(TodoNotFoundException.class)
	public ResponseEntity<String> trataTodoNotFound(TodoNotFoundException exception){
		String msg = String.format("O todo com o ID %d não foi encontrado", exception.getId());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("s-erro-code", "TODO_NOT_FOUND")
				.header("x-erro-value", exception.getId().toString())
				.build();
	}
	
//	@ExceptionHandler(TodoIdInvalidoException.class)
//	public ResponseEntity<String> trataTodoIdInvalido(TodoIdInvalidoException exception){
//		String msg = String.format("O todo com o ID %d não é válido. Favor informar um ID maior que 0(zero)", exception.getId());
//		return ResponseEntity.badRequest()
//				.header("x-erro-msg", msg)
//				.header("s-erro-code", "TODO_ID_INVALIDO")
//				.header("x-erro-value", exception.getId().toString())
//				.build();
//	}
	
}
