package com.osorio.repository;

import com.osorio.model.Ronda;
import java.util.List; 


public interface RondaRepository {

	public List<Ronda> getAllRondas(); 
	public Ronda ObtenerPorId(int id); 
	
}
