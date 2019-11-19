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
@RequestMapping("/clube")
public final class ClubeService 
{
	ClubeController clubeController;
	
	ClubeService(ClubeController clubeController)
	{
		this.clubeController = clubeController;
	}
		
	@GetMapping("/list")
	public ArrayList<ClubeDTO> list()
	{
		return this.clubeController.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClubeDTO> getProduct(@PathVariable long id) 
	{
		final ClubeDTO clubeDTO = this.clubeController.getClubeById(id);
		if(clubeDTO == ClubeDTO.NULL_VALUE)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(clubeDTO, HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public long novoClube(@RequestBody ClubeDTO novoClube) 
	{		
		return this.clubeController.saveClube(novoClube);
	}
	
	@PutMapping("/put/{id}")
    public ResponseEntity<ClubeDTO> replaceClube(@RequestBody ClubeDTO novoClube, @PathVariable long id) 
	{	
		final ClubeDTO clubeDTO = this.clubeController.replaceClube(novoClube, id);
		
		if(clubeDTO == ClubeDTO.NULL_VALUE)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(clubeDTO, HttpStatus.OK);	
	}
}
