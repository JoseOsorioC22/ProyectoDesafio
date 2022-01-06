package com.osorio.model.DTOs;
import java.util.ArrayList;
import java.util.List;

public class DTOJuego {

private int idPregunta;
private String descripcionPregunta; 
private List<DTOOpcion> opciones = new ArrayList<>() ; 
private String nombrePremio; 
private double valor; 
private String ronda;


public List<DTOOpcion> getOpciones() {
	return opciones;
}


public void setOpciones(List<DTOOpcion> opciones) {
	this.opciones = opciones;
}

public void agregarOpcion(DTOOpcion opcion )
{
 opciones.add(opcion); 
}

public String getRonda() {
	return ronda;
}


public void setRonda(String ronda) {
	this.ronda = ronda;
}


public String getNombrePremio() {
	return nombrePremio;
}


public void setNombrePremio(String nombrePremio) {
	this.nombrePremio = nombrePremio;
}


public double getValor() {
	return valor;
}


public void setValor(double valor) {
	this.valor = valor;
}


public int getIdPregunta() {
	return idPregunta;
}


public void setIdPregunta(int idPregunta) {
	this.idPregunta = idPregunta;
}


public String getDescripcionPregunta() {
	return descripcionPregunta;
}


public void setDescripcionPregunta(String descripcionPregunta) {
	this.descripcionPregunta = descripcionPregunta;
}



}
