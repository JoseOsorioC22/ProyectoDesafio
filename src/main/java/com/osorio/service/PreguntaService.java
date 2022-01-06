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

import com.osorio.model.Pregunta;
import com.osorio.repository.PreguntaRepository;
import com.osorio.repository.RondaRepository;

@Repository

@Transactional


public class PreguntaService implements PreguntaRepository {

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Pregunta> GetAllPreguntas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SavePregunta(Pregunta p) {
	
		entityManager.persist(p);
	}
	
	

}
