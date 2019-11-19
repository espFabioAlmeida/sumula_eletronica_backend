package com.example.SumulaEletronica;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arbitro")
public final class ArbitroService 
{
	ArbitroController arbitroController;
	
	ArbitroService(ArbitroController arbitroController)
	{
		this.arbitroController = arbitroController;
	}
	
	
	@GetMapping("/list")
	public ArrayList<ArbitroDTO> list()
	{
		return this.arbitroController.list();
	}
	
	@GetMapping("/list/assistentes")
	public ArrayList<ArbitroDTO> listAssistentes()
	{
		return this.arbitroController.listAssistentes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArbitroDTO> getArbitros(@PathVariable long id) 	
	{
		final ArbitroDTO arbitroDTO = this.arbitroController.getArbitroById(id);
		if(arbitroDTO == ArbitroDTO.NULL_VALUE)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(arbitroDTO, HttpStatus.OK);
	}
				
	
	@PostMapping("/post")
	public long postArbitro(@RequestBody ArbitroDTO novoArbitro) 
	{		
		return this.arbitroController.saveArbitro(novoArbitro);
	}
	
	@PutMapping("/put/{id}")
    public ResponseEntity<ArbitroDTO> replaceArbitro(@RequestBody ArbitroDTO novoArbitro, @PathVariable long id) 
	{	
		final ArbitroDTO arbitroDTO = this.arbitroController.replaceArbitro(novoArbitro, id);
		
		if(arbitroDTO == ArbitroDTO.NULL_VALUE)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(arbitroDTO, HttpStatus.OK);		
	}
	
}
