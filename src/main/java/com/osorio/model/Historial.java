package com.osorio.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="historial")
public class Historial implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_historial")
    private Integer idHistorial;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "ganador")
    private Short ganador;
    
    @JoinColumn(name = "jugador", referencedColumnName = "id_jugador")
    @ManyToOne()
    private Jugador jugador;
    
    @JoinColumn(name = "ronda", referencedColumnName = "id_ronda")
    @ManyToOne()
    private Ronda ronda;

    
    
	public Integer getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(Integer idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Short getGanador() {
		return ganador;
	}

	public void setGanador(Short ganador) {
		this.ganador = ganador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Ronda getRonda() {
		return ronda;
	}

	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Historial [idHistorial=" + idHistorial + ", fecha=" + fecha + ", ganador=" + ganador + ", jugador="
				+ jugador + ", ronda=" + ronda + "]";
	}
    
    

	
	
}
