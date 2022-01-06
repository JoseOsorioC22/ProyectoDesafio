package com.osorio.model;

import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="premio")
public class Premio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id_premio")
	private int idPremio; 
	
	@Column(name="nombre_premio")
	private String nombrePremio; 
	
	@Column(name="valor")
	private int valor;

	public int getIdPremio() {
		return idPremio;
	}

	public void setIdPremio(int idPremio) {
		this.idPremio = idPremio;
	}

	public String getNombrePremio() {
		return nombrePremio;
	}

	public void setNombrePremio(String nombrePremio) {
		this.nombrePremio = nombrePremio;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	} 
	
	
	
	
}
