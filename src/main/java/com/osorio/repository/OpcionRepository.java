package com.osorio.repository;

import com.osorio.model.Opcion;
import com.osorio.model.DTOs.DTOJuego;

import java.util.List; 

public interface OpcionRepository {

	public List<DTOJuego> getAllOpciones(); 
	public void saveData(Opcion opcion); 
	
}
