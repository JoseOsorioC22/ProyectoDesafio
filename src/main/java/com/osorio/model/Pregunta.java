package com.osorio.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="pregunta")
public class Pregunta  implements Serializable {

	@Id
	@Column(name="id_pregunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int idPregunta; 
	
	@Column(name="descripcion")
	private String descripcion; 
	
	@ManyToOne
	@JoinColumn(name = "ronda", referencedColumnName = "id_ronda")
	private Ronda ronda;

	
	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Ronda getRonda() {
		return ronda;
	}

	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}

	@Override
	public String toString() {
		return "Pregunta [idPregunta=" + idPregunta + ", descripcion=" + descripcion + ", ronda=" + ronda + "]";
	} 
	
	
	
	
	
}
