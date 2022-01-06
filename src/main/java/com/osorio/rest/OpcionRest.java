package com.osorio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osorio.model.Opcion;
import com.osorio.model.DTOs.DTOJuego;
import com.osorio.service.OpcionService;

@RestController
public class OpcionRest {

	@Autowired
	OpcionService opcionService; 
	
	
	@RequestMapping(value="/opcion/" , method = RequestMethod.GET)
	public List<DTOJuego> getAllOpciones()
	{
		return opcionService.getAllOpciones(); 
	}
}
