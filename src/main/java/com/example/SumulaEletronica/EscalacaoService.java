package com.example.SumulaEletronica;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/escalacao")
public class EscalacaoService 
{
	EscalacaoController escalacaoController;

	EscalacaoService(EscalacaoController escalacaoController) 
	{
		this.escalacaoController = escalacaoController;
	}
	
	@PostMapping("/post")
	public long novaEscalacao(@RequestBody EscalacaoDTO novaEscalacao) 
	{		
		return this.escalacaoController.saveEscalacao(novaEscalacao);
	}
	

}
