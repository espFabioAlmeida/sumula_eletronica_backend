package com.example.SumulaEletronica;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relacao")
public class RelacaoService 
{
	RelacaoController relacaoController;

	RelacaoService(RelacaoController relacaoController)
	{
		this.relacaoController = relacaoController;
	}
	
	@PostMapping("/post")
	public List<Long> novaRelacao(@RequestBody List<RelacaoDTO> novasRelacoes) 
	{		
		return this.relacaoController.saveRelacoes(novasRelacoes);
	}	
	
	
}
