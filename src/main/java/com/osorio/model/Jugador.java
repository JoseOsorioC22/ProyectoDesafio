package com.osorio.model;

import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="jugador")
public class Jugador implements Serializable {

	@Id
	@Column(name="id_jugador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idJugador;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="genero")
	private String genero;

	
	
	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", apellido=" + apellido + ", genero="
				+ genero + "]";
	} 
	
	
	
	
}
