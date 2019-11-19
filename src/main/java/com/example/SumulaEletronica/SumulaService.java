package com.example.SumulaEletronica;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sumula")
public class SumulaService 
{
	
	SumulaController sumulaController;
	
	SumulaService(SumulaController sumulaController)
	{
		this.sumulaController = sumulaController;
	}
		
	@GetMapping("/list")
	public ArrayList<SumulaListDTO> list()
	{
		return this.sumulaController.list();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<SumulaDTO> getSumula(@PathVariable int id) 
	{
		final SumulaDTO sumulaDTO = this.sumulaController.getSumulaById(id);
		if(sumulaDTO == SumulaDTO.NULL_VALUE)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(sumulaDTO, HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public long novaSumula(@RequestBody SumulaCreateDTO novaSumula) 
	{		
		return this.sumulaController.saveSumula(novaSumula);
	}
}
