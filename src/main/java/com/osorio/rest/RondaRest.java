package com.osorio.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List; 
import com.osorio.service.RondaService;
import com.osorio.model.Ronda; 

@RestController

public class RondaRest {

	@Autowired
	private RondaService rondaService; 
	
	@RequestMapping("/ronda/")
	private List<Ronda> getAllRondas()
	{
		return rondaService.getAllRondas(); 
	}
	
	
	
}
