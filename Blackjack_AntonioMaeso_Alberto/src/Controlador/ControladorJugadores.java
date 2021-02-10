package Controlador;

import java.util.List;

import Modelo.Carta;
import Modelo.Jugador;

public class ControladorJugadores {
	ControladorCartas cCartas;
	Jugador jugador;
	
	public ControladorJugadores(Jugador jugador) {
		super();
		this.jugador = jugador;
	}

	public void recogerCarta(Carta carta) {
		List<Carta> cartas = jugador.getCartas();
		cartas.add(carta);
		
		int puntos = 0;
		for(int i = 0; i<cartas.size(); i++) {
			puntos = puntos + cartas.get(i).getValor();
			jugador.setPuntuacion(puntos);
		}
		System.out.println(jugador.getPuntuacion());
	}
	
	
}
