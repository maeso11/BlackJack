package Controlador;

import java.util.ArrayList;
import java.util.List;

import Modelo.Carta;
import Modelo.Jugador;

public class ControladorJugadores {
	ControladorCartas cCartas;
	Jugador jugador;
	ControladorCartas controlador = new ControladorCartas();
	List<Carta> cartas = controlador.creacion();
	Carta carta;
	int puntos=0;

	public ControladorJugadores(Jugador jugador) {
		super();
		this.jugador = jugador;
	}

	public void recogerCarta(Jugador jugador) {
		
		List<Carta> Jugadorcarta = new ArrayList<Carta>();
		carta = controlador.getCarta(cartas);
		Jugadorcarta.add(carta);
		jugador.setCartas(Jugadorcarta);
		
	}
	
	
	public Jugador puntuacion(Jugador jugador) {

		carta = controlador.getCarta(cartas);
		
		List<Carta> cartas = jugador.getCartas();
		cartas.add(carta);
		
		System.out.println(cartas.size());
		
		System.out.println(carta);
		puntos += carta.getValor();
		jugador.setPuntuacion(puntos);
		
		
		return jugador;
	}
	
	
}
