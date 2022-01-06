package com.osorio.model;

import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name="categoria")
public class Categoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id_categoria")
	private int idCategoria; 
	@Column(name="nombre_categoria")
	private String nombreCategoria; 
	@Column(name="complejidad")
	private int complejidad;
	
	
	public Categoria()
	{
		
	}

	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public int getComplejidad() {
		return complejidad;
	}
	public void setComplejidad(int complejidad) {
		this.complejidad = complejidad;
	} 
	
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", complejidad="
				+ complejidad + "]";
	}
	
	
	
	
}
