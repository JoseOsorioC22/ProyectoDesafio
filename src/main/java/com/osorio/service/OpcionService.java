package com.osorio.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.osorio.model.Opcion;
import com.osorio.repository.OpcionRepository;

@Repository

@Transactional

public class OpcionService implements  OpcionRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Opcion> getAllOpciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveData(Opcion opcion) {
		entityManager.persist(opcion);
	}

}
