package com.example.SumulaEletronica;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cronologia")
public class CronologiaService {
	
	CronologiaController cronologiaController;

	CronologiaService(CronologiaController cronologiaController) 
	{
		this.cronologiaController = cronologiaController;
	}
	
	@PostMapping("/post")
	public long novoClube(@RequestBody CronologiaDTO novaCronologia) 
	{		
		return this.cronologiaController.saveCronologia(novaCronologia);
	}	
	
}
