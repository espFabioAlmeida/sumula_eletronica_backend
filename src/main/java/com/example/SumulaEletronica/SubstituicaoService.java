package com.example.SumulaEletronica;

import java.util.List;

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
	public List<Long> novaSubstituicao(@RequestBody List<SubstituicaoCreateDTO> novasSubstituicoes) 
	{		
		return this.substituicaoController.saveSubstituicao(novasSubstituicoes);
	}
}
