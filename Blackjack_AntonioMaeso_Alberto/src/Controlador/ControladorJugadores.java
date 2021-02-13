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


	public ControladorJugadores(Jugador jugador) {
		super();
		this.jugador = jugador;
	}

	public Jugador recogerCarta(Jugador jugador) {
		
		List<Carta> Jugadorcarta = new ArrayList<Carta>();
		carta = controlador.getCarta(cartas);
		Jugadorcarta.add(carta);
		jugador.setCartas(Jugadorcarta);
		
		jugador.setPuntuacion(carta.getValor());
		return jugador;
	}
	
	
	public Jugador puntuacion(Jugador jugador) {
		int puntos=0;
		//puntos += carta.getValor();
		carta = controlador.getCarta(cartas);
		
		List<Carta> cartas = jugador.getCartas();
		cartas.add(carta);
		
		for (int i = 0; i<cartas.size(); i++) {
			puntos = puntos + cartas.get(i).getValor();
		}
		
		System.out.println(cartas.size());
		
		
		
		System.out.println(carta);
		
		jugador.setPuntuacion(puntos);
		jugador.setRutaCarta(carta.getRuta());
		
		return jugador;
	}
	
	
}






