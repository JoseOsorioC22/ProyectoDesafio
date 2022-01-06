package com.osorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.osorio.model.Pregunta;
import java.util.List; 

public interface PreguntaRepository {

	public List<Pregunta> GetAllPreguntas(); 
	public void SavePregunta(Pregunta p); 
	public long getCountRows(); 
	
}
