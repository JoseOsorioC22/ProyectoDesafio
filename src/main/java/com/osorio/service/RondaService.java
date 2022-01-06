package com.osorio.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.osorio.model.Ronda;
import com.osorio.repository.RondaRepository;

@Repository

@Transactional

public class RondaService implements RondaRepository {

	@PersistenceContext
    private EntityManager entityManager;
	


	@Override
	public List<Ronda> getAllRondas() {
		String query = "select * from ronda where ronda.id_ronda NOT IN (select pregunta.ronda from pregunta )" ; 
		List<Ronda> rondas = entityManager.createNativeQuery(query, Ronda.class ).getResultList() ; 
		
		return rondas; 
	}

	@Override 
	public Ronda ObtenerPorId(int id)
	{
		Ronda ronda = entityManager.find(Ronda.class,id); 
		 
		return ronda; 
	}

}
