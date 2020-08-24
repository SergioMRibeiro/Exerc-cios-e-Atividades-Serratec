package org.serratec.projeto05.projetoFinal.service;

import org.serratec.projeto05.projetoFinal.domain.Operacao;

import org.springframework.stereotype.Service;

@Service
public class OperacaoService {
	Operacao operacao = new Operacao("debito", 300.0);
	
	/*
	public void novaOpreacao(String tipo, Double valor) {
		operacao.setTipo(tipo);
		operacao.setValor(valor);
	}
	*/
	public String mostrarOperacao() {
		return operacao.toString();
	}
	

}
