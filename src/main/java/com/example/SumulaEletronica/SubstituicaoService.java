package com.example.SumulaEletronica;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/substituicao")
public class SubstituicaoService 
{
	SubstituicaoController substituicaoController;

	SubstituicaoService(SubstituicaoController substituicaoController) 
	{
		this.substituicaoController = substituicaoController;
	}
	
	@PostMapping("/post")
	public long novaSubstituicao(@RequestBody SubstituicaoCreateDTO novaSubstituicao) 
	{		
		return this.substituicaoController.saveSubstituicao(novaSubstituicao);
	}
}
