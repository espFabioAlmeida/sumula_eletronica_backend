package com.example.SumulaEletronica;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginService 
{
	
	LoginController loginController;
	
	LoginService(LoginController loginController)
	{
		this.loginController = loginController;
	}
	
	@PostMapping("")
	public ResponseEntity<ArbitroDTO> logaArbitro(@RequestBody ArbitroDTO loginArbitro) 
	{
		final ArbitroDTO arbitroDTO = this.loginController.logaArbitro(loginArbitro);
		
		if(arbitroDTO == ArbitroDTO.NULL_VALUE)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(arbitroDTO, HttpStatus.OK);	
	}

}
