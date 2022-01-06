package com.osorio.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="opcion")
public class Opcion  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_opcion")
	private int idOpcion;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "tipo_opcion")
	private boolean tipoOpcion;
	
	@ManyToOne()
	@JoinColumn(name = "pregunta", referencedColumnName = "id_pregunta")
	private Pregunta pregunta;

	
	public int getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getTipoOpcion() {
		return tipoOpcion;
	}

	public void setTipoOpcion(boolean tipoOpcion) {
		this.tipoOpcion = tipoOpcion;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public String toString() {
		return "Opcion [idOpcion=" + idOpcion + ", descripcion=" + descripcion + ", tipoOpcion=" + tipoOpcion
				+ ", pregunta=" + pregunta + "]";
	}
	
	
	
}
