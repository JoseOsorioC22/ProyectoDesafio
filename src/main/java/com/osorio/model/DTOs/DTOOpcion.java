package com.osorio.model.DTOs;

public class DTOOpcion {

	private int idOpcion;
	private String descripcionOpcion;
	private boolean TipoOpcion; 
	
	
	
	
	public boolean isTipoOpcion() {
		return TipoOpcion;
	}
	public void setTipoOpcion(boolean tipoOpcion) {
		TipoOpcion = tipoOpcion;
	}
	public int getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}
	public String getDescripcionOpcion() {
		return descripcionOpcion;
	}
	public void setDescripcionOpcion(String descripcionOpcion) {
		this.descripcionOpcion = descripcionOpcion;
	} 
	
	
}
