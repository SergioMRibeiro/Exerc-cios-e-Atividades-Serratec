package org.serratec.curso2java.crud2.exceptions;

public class TodoIdInvalidoException extends Exception {

	private static final long serialVersionUID = -1915956357216970614L;
	private Integer id;

	public TodoIdInvalidoException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
