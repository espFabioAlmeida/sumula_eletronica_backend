package com.example.SumulaEletronica;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comissao")
public class ComissaoService {
	
	ComissaoController comissaoController;

	ComissaoService(ComissaoController comissaoController) 
	{
		this.comissaoController = comissaoController;
	}
	
	@PostMapping("/post")
	public long novaComissao(@RequestBody ComissaoDTO novaComissao) 
	{		
		return this.comissaoController.saveComissao(novaComissao);
	}	
	

}
