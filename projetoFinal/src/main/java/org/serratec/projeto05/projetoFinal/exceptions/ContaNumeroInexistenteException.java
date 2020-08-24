package org.serratec.projeto05.projetoFinal.exceptions;

public class ContaNumeroInexistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8295860501485957L;
	private Integer numero;
	
	public ContaNumeroInexistenteException(Integer numero) {
		super();
		this.numero = numero;
	}	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
