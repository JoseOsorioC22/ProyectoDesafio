package com.osorio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.osorio.model.Opcion;
import com.osorio.model.Pregunta;
import com.osorio.model.DTOs.DTOJuego;
import com.osorio.model.DTOs.DTOOpcion;
import com.osorio.repository.OpcionRepository;

@Repository

@Transactional

public class OpcionService implements OpcionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DTOJuego> getAllOpciones() {
		
			List<DTOJuego> listaDTOJuego = new ArrayList<>(); 
		String sql = "select * from opcion"; 
		  List<Opcion> opciones = entityManager.createNativeQuery(sql,Opcion.class).getResultList();
		 
		  for(int i=0; i<opciones.size();i+=4)
		  {
			  DTOJuego dto = new DTOJuego();
			  dto.setDescripcionPregunta(opciones.get(i).getPregunta().getDescripcion());
			  dto.setIdPregunta(opciones.get(i).getPregunta().getIdPregunta() );
			  dto.setRonda(opciones.get(i).getPregunta().getRonda().getNombreRonda() );
			  dto.setValor( opciones.get(i).getPregunta().getRonda().getPremio().getValor());
			  dto.setNombrePremio(opciones.get(i).getPregunta().getRonda().getPremio().getNombrePremio()  );
			int x =i;  
			
			while(x < (i+4) )
			{
				DTOOpcion opcion = new DTOOpcion();
				opcion.setDescripcionOpcion(opciones.get(x).getDescripcion());
				opcion.setIdOpcion(opciones.get(x).getIdOpcion());
				opcion.setTipoOpcion(opciones.get(x).getTipoOpcion());
				dto.agregarOpcion(opcion);
			  
			  listaDTOJuego.add(dto);
			  	x++; 	
			}

			System.out.println("*******se finaliza ****** ");
		  }
		  
	return listaDTOJuego; 

	}

	@Override
	public void saveData(Opcion opcion) {
		entityManager.persist(opcion);
	}

}
