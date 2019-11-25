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
	
	public LoginDTO logaArbitro(LoginDTO arbitroLogin)
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
						arbitroLogin.setArbitro(removeSenha(arbitroEncontrado));
						arbitroLogin.setToken(" *** INSERIR TOKEN AQUI ****");
						arbitroLogin.setSenha("");
						return arbitroLogin;
					}
				}
			}
		}
		
		return LoginDTO.NULL_VALUE;
	}
		
	private ArbitroDTO toDTO(ArbitroEntity arbitroEntity)
	{	
		return new ArbitroDTO(arbitroEntity.getNome(), arbitroEntity.getSenha(), arbitroEntity.getCpf(), arbitroEntity.getDataNascimento(),
				arbitroEntity.getSexo(), arbitroEntity.getCategoria(), arbitroEntity.getFuncao(), arbitroEntity.getAltura(), arbitroEntity.getPeso(),
				arbitroEntity.getId());
	}
	
	private ArbitroDTO removeSenha(ArbitroDTO arbitroDTO)
	{
		ArbitroDTO arbitroSemSenha;
		
		arbitroSemSenha = new ArbitroDTO(arbitroDTO.getNome(), "", arbitroDTO.getCpf(), arbitroDTO.getDataNascimento(), 
				arbitroDTO.getSexo(), arbitroDTO.getCategoria(),
				arbitroDTO.getFuncao(), arbitroDTO.getAltura(), arbitroDTO.getPeso(), arbitroDTO.getId());
		
		return arbitroSemSenha;
	}

}
