package com.osorio.repository;

import com.osorio.model.Opcion;
import java.util.List; 

public interface OpcionRepository {

	public List<Opcion> getAllOpciones(); 
	public void saveData(Opcion opcion); 
	
}
