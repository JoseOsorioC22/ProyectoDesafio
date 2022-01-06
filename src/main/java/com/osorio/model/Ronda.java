package com.osorio.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.OneToMany;


@Entity
@Table(name="ronda")
public class Ronda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name ="id_ronda")
	private int idRonda; 
	
	@Column(name="nombre_ronda")
	private String nombreRonda; 
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "premio", referencedColumnName = "id_premio")
	private Premio premio;

	public int getIdRonda() {
		return idRonda;
	}

	public void setIdRonda(int idRonda) {
		this.idRonda = idRonda;
	}

	public String getNombreRonda() {
		return nombreRonda;
	}

	public void setNombreRonda(String nombreRonda) {
		this.nombreRonda = nombreRonda;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Premio getPremio() {
		return premio;
	}

	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	
	
	
	
}
