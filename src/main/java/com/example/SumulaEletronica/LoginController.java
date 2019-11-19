package com.example.SumulaEletronica;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
	
	ArbitroRepository arbitroRepository;
	
	LoginController(ArbitroRepository arbitroRepository)
	{
		this.arbitroRepository = arbitroRepository;
	}
	
	public ArbitroDTO logaArbitro(ArbitroDTO arbitroLogin)
	{
		ArrayList<ArbitroDTO> listaArbitros = new ArrayList<ArbitroDTO>();		
		this.arbitroRepository.findAll().forEach(arbitroEntity -> listaArbitros.add(toDTO(arbitroEntity)));		
		
		for(ArbitroDTO arbitroEncontrado : listaArbitros)
		{
			if(arbitroEncontrado.getCpf().equals(arbitroLogin.getCpf()))
			{
				if(arbitroEncontrado.getSenha().equals(arbitroLogin.getSenha()))
				{
					if(arbitroEncontrado.getFuncao().equals("Arbitro"))
					{
						return arbitroEncontrado;
					}
				}
			}
		}
		
		return ArbitroDTO.NULL_VALUE;
	}
	
	private ArbitroDTO toDTO(ArbitroEntity arbitroEntity)
	{	
		return new ArbitroDTO(arbitroEntity.getNome(), arbitroEntity.getSenha(), arbitroEntity.getCpf(), arbitroEntity.getDataNascimento(),
				arbitroEntity.getSexo(), arbitroEntity.getCategoria(), arbitroEntity.getFuncao(), arbitroEntity.getAltura(), arbitroEntity.getPeso(),
				arbitroEntity.getId());
	}
	

}
