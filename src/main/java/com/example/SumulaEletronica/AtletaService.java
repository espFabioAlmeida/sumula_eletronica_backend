package com.example.SumulaEletronica;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/atleta")
public final class AtletaService
{
	AtletaController atletaController;
	
	AtletaService(AtletaController atletaController)
	{
		this.atletaController = atletaController;
	}
			

	@GetMapping("/list")
	public ArrayList<AtletaDTO> list()
	{
		return this.atletaController.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AtletaDTO> getAtleta(@PathVariable long id) 
	{
		final AtletaDTO atletaDTO = this.atletaController.getAtletaById(id);
		if(atletaDTO == AtletaDTO.NULL_VALUE)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(atletaDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/clube")
	public ArrayList<AtletaDTO> getAtletaByClube(@PathVariable long id)
	{
		return this.atletaController.findByClube(id);
	}
	
	@PostMapping("/post")
	public long novoAtleta(@RequestBody AtletaDTO novoAtleta) 
	{		
		return this.atletaController.saveAtleta(novoAtleta);
	}
	
	@PutMapping("/put/{id}")
    public ResponseEntity<AtletaDTO> replaceAtleta(@RequestBody AtletaDTO novoAtleta, @PathVariable long id) 
	{	
		final AtletaDTO atletaDTO = this.atletaController.replaceAtleta(novoAtleta, id);
		
		if(atletaDTO == AtletaDTO.NULL_VALUE)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(atletaDTO, HttpStatus.OK);	
	}
	
}
