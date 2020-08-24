package org.serratec.projeto05.projetoFinal.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto05.projetoFinal.domain.Conta;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
	private List<Conta> cache;
	private Integer proximoNumeroDeConta;
	
	
	public ContaService() {
		
		cache = new ArrayList<Conta>();
		cache.add(new Conta(1, "Juliana", 9000.00));
		cache.add(new Conta(2, "Livia", 12000.00));
		cache.add(new Conta(3, "Pedro", 4000.00));
		proximoNumeroDeConta = 4;
		
	}
	
	public List<Conta> mostrarLista(){
		return cache;
	}
	
	public Conta buscaNumero(Integer num){
		for (Conta conta: cache) {
			if (conta.getNumero() == num) {
				return conta;
			}
		}
		return null;
	}
	
	public void deletarConta(Integer num) {
		/**
		 * Use para deletar uma Conta
		 * use da seguinte forma: deletarconta(numeroIneiro)
		 */
		Conta contaParaDeletar = buscaNumero(num);
		cache.remove(contaParaDeletar);
	}
	
	
	public void adcionarConta(String nomeCliente, Double saldo) {
		cache.add(new Conta(proximoNumeroDeConta++, nomeCliente, saldo));
	}
	
	
	public void atualizarNome(Integer numero, String novoTitular) {
		Conta conta = buscaNumero(numero);
		conta.setTitular(novoTitular);
	}
	
	
	
}
