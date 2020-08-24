package org.serratec.projeto05.projetoFinal.controller;

import java.util.List;

import org.serratec.projeto05.projetoFinal.domain.Conta;
import org.serratec.projeto05.projetoFinal.service.ContaService;
import org.serratec.projeto05.projetoFinal.service.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class ContaController {
	
	@Autowired
	ContaService contaService;
	OperacaoService operacaoService;
	
	@RequestMapping("/teste")
	public String olá() {
		return "Olá Pessoal";
	}
	
	@GetMapping
	public List<Conta> mosrarContas() {
		return contaService.mostrarLista();
	}
	
	@GetMapping("/{numero}")
	public Conta contaSelecionada(@PathVariable Integer numero){
		return contaService.buscaNumero(numero);
	}
	
	@DeleteMapping("/{numero}")
	public ResponseEntity<?> deletarConta(@PathVariable Integer numero) {
		contaService.deletarConta(numero);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PostMapping
	public ResponseEntity<?> adicinarConta(@RequestParam String nome, Double saldo){
		contaService.adcionarConta(nome, saldo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	public ResponseEntity<?> alterarConta(@RequestParam Integer numero, String novoTitular) {
		contaService.atualizarNome(numero, novoTitular);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	//@PostMapping("/{numero}/operacao")
	
	
	@GetMapping("/operacao")
	public String mostrarOperacao() {
		return operacaoService.mostrarOperacao();
	}
	/*
	@PostMapping("/operacao")
	public ResponseEntity<?> adicinarOperacao(@RequestParam Tipo tipo, Double valor){
		operacaoService.novaOpreacao(tipo, valor);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}*/
	
	
}
