package Modelo;

import java.util.List;

public class Jugador {
	String nombre;
	List<Carta> cartas;
	int puntuacion;
	String rutaCarta;
	boolean turno;
	String situacion;
	
	
	
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		this.situacion = "pedir";
	}
		
	public Jugador() {}
	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	
	public String getRutaCarta() {
		return rutaCarta;
	}
	public void setRutaCarta(String rutaCarta) {
		this.rutaCarta = rutaCarta;
	}
	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getSituacion() {
		return situacion;
	}
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
	
	

}
