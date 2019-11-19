package com.example.SumulaEletronica;

import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class RelacaoController {
	
	RelacaoRepository relacaoRepository;
	AtletaController atletaController;
	EscalacaoController escalacaoController;

	
	RelacaoController(RelacaoRepository relacaoRepository, AtletaController atletaController,
			EscalacaoController escalacaoController) 
	{
		this.relacaoRepository = relacaoRepository;
		this.atletaController = atletaController;
		this.escalacaoController = escalacaoController;
	}

	public RelacaoEntity getRelacaoEntityById(long id)
	{
		final Optional<RelacaoEntity> relacaoEntity = this.relacaoRepository.findById(id);
						
		if(relacaoEntity.isPresent())
		{			
			return relacaoEntity.get();
		}
						
		return toEntity(RelacaoDTO.NULL_VALUE);
	}
	
	public long saveRelacao(RelacaoDTO relacaoDTO)
	{
		RelacaoEntity novaRelacao = toEntity(relacaoDTO);
		
		if(novaRelacao.getId() != null)
		{
			return this.relacaoRepository.save(novaRelacao).getId();
		}
		
		return 0;		
	}
		
	private RelacaoEntity toEntity(RelacaoDTO relacaoDTO)
	{	
		if(this.escalacaoController.getEscalacaoEntityById(relacaoDTO.getEscalacao()).getId() == 0 ||
				this.atletaController.getAtletaEntityById(relacaoDTO.getAtleta()).getId() == 0)
			return new RelacaoEntity();
		
		return new RelacaoEntity(relacaoDTO.getId(), relacaoDTO.getNumero(), relacaoDTO.getGol(), relacaoDTO.getTitular(),
				relacaoDTO.getCartoes(), this.atletaController.getAtletaEntityById(relacaoDTO.getAtleta()),
				this.escalacaoController.getEscalacaoEntityById(relacaoDTO.getEscalacao()));
	}
}
