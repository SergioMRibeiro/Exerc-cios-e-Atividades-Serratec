package org.serratec.curso2java.crud2.exceptions;

public class TodoNotFoundException extends Exception {

	private static final long serialVersionUID = 663671402494549740L;
	
	private Integer id;

	public TodoNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
