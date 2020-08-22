package org.serratec.curso2java.crud2.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.curso2java.crud2.domain.Todo;
import org.serratec.curso2java.crud2.exceptions.TodoIdInvalidoException;
import org.serratec.curso2java.crud2.exceptions.TodoNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private List<Todo> cache;
	private int nextId = 0;
	public TodoService() {
		cache = new ArrayList<Todo>();
		cache.add(new Todo(1, "baixar apostila", "Baixar a apostila mais recente", true));
		cache.add(new Todo(2, "baixar eclipse", "Baixar a versão mais atual do eclipse", false));
		cache.add(new Todo(3, "baixar jdk", "Baixar a versão 8 do java developer kit", false));
		cache.add(new Todo(4, "instalar jdk", "Descompactar o arquivo e configurar o path e java_path no windows", false));
		cache.add(new Todo(5, "testar eclipse", "Descompactar o eclipse e verificar se ele encontra o java", false));
		nextId=6;
		
	}
	
	public List<Todo> listarTodos() {
		return cache;
	}
	
	public Todo recuperarPorId(Integer id) throws TodoNotFoundException, TodoIdInvalidoException {
		
		validarId(id);
		
		boolean encontrado = false;
		Todo todoEncontrado = null;
		for (Todo todo : cache) {
			if(todo.getId() == id) {
				encontrado = true;
				todoEncontrado = todo;
				break;
			}
		}
		
		
		if (!encontrado) throw new TodoNotFoundException(id); 
		
		return todoEncontrado;
		
	}
	
	public Todo incluir(Todo novoTodo) {
		novoTodo.setId(nextId);
		cache.add(novoTodo);
		nextId++;
		return novoTodo;
	}
	
	public Todo atualizarPorId(Todo todo) throws TodoNotFoundException, TodoIdInvalidoException {
		Todo todoEncontrato = recuperarPorId(todo.getId());
		if (null == todoEncontrato) {
			return null;
		}

		if(!"".equals(todo.getTitulo())) todoEncontrato.setTitulo(todo.getTitulo());
		if(!"".equals(todo.getDescricao())) todoEncontrato.setDescricao(todo.getDescricao());
		if(!"".equals(todo.getCompletada()))todoEncontrato.setCompletada(todo.getCompletada());

		return todoEncontrato;
	}
	
	public void apagarPorId(Integer id) throws TodoNotFoundException, TodoIdInvalidoException {
		Todo todo = recuperarPorId(id);
		cache.remove(todo);
	}
	
	private void validarId(Integer id) throws TodoIdInvalidoException {
		if(null == id || null == id || id <= 0) throw new TodoIdInvalidoException(id);
		
	}
}
