package org.serratec.curso2java.crud2.controllers;

import org.serratec.curso2java.crud2.domain.Todo;
import org.serratec.curso2java.crud2.exceptions.TodoIdInvalidoException;
import org.serratec.curso2java.crud2.exceptions.TodoNotFoundException;
import org.serratec.curso2java.crud2.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/todo" })
public class TodoController {

	@Autowired
	private TodoService todoService;

	@Value("${residencia-software}")
	private String anoEletivo;
	
	@GetMapping
	public ResponseEntity<?> getTodos() {
		HttpHeaders cabecalho = new HttpHeaders();
		cabecalho.add("RESIDENCIA-SOFTWARE", anoEletivo);
		return new ResponseEntity(todoService.listarTodos(), cabecalho, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTodo(@PathVariable Integer id) throws TodoNotFoundException, TodoIdInvalidoException {

		Todo todo = todoService.recuperarPorId(id);

		return ResponseEntity.status(HttpStatus.OK).body(todo);

	}

	@PostMapping
	public ResponseEntity<?> incluir(@RequestBody Todo novoTodo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(todoService.incluir(novoTodo));
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody Todo todo) throws TodoNotFoundException, TodoIdInvalidoException {

		Todo todoAtualizado = todoService.atualizarPorId(todo);
		return ResponseEntity.status(HttpStatus.OK).body(todoAtualizado);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagar(@PathVariable Integer id) throws TodoNotFoundException, TodoIdInvalidoException {

		todoService.apagarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).build();

	}

}
