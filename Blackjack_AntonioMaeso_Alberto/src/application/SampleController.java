package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Controlador.ControladorCartas;
import Controlador.ControladorJugadores;
import Modelo.Carta;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SampleController {

	@FXML private ImageView cartaAdicional, carta1, carta2, carta3, carta4, carta5,
						turnoBanca, turno1, turno2, turno3, turno4, turno5, fondo;
	@FXML private Label puntosBanca, puntos1, puntos2, puntos3, puntos4, puntos5,
						nombre1, nombre2, nombre3, nombre4, nombre5, ultimoGanador, cartaBanca;
	@FXML private Button btnPedir, btnPlantarse;
	
	int turno = (int)(Math.random()*7);
	ControladorCartas controlador = new ControladorCartas();
	List<Carta> cartas = controlador.creacion();
	Jugador jugador1 = new Jugador();
	Jugador jugador2 = new Jugador();
	Jugador jugador4 = new Jugador();
	Jugador jugador5 = new Jugador();
	Jugador croupier = new Jugador();
	Jugador yo = new Jugador();
	ControladorJugadores c1 = new ControladorJugadores(jugador1);
	ControladorJugadores c2 = new ControladorJugadores(jugador2);
	ControladorJugadores c4 = new ControladorJugadores(jugador4);
	ControladorJugadores c5 = new ControladorJugadores(jugador5);
	ControladorJugadores cBanca = new ControladorJugadores(croupier);
	ControladorJugadores cYo = new ControladorJugadores(yo);
	

	public void initialize() {
	
		
		Jugador j1 = c1.recogerCarta(jugador1);
		puntos1.setText("PUNTOS: "+ j1.getPuntuacion());
		Jugador j2 = c2.recogerCarta(jugador2);
		puntos2.setText("PUNTOS: "+ j2.getPuntuacion());
		Jugador j4 = c4.recogerCarta(jugador4);
		puntos4.setText("PUNTOS: "+ j4.getPuntuacion());
		Jugador j5 = c5.recogerCarta(jugador5);
		puntos5.setText("PUNTOS: "+ j5.getPuntuacion());
		Jugador jBanca = cBanca.recogerCarta(croupier);
		puntosBanca.setText("PUNTOS: "+ jBanca.getPuntuacion());
		Jugador jPlayer = cYo.recogerCarta(yo);
		puntos3.setText("PUNTOS: "+ jPlayer.getPuntuacion());
		
		turnos(turno);

	}
	
	public void turnoJugador1 (MouseEvent e) {
		if(turno == 2) {
			jugador1 = c1.puntuacion(jugador1);
			Image cartaNueva = new Image(jugador1.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos1.setText("PUNTOS: "+ jugador1.getPuntuacion());
			turno=3;
			turnos(turno);
		}
		
		
	}
	public void turnoJugador2 (MouseEvent e) {
		if(turno == 3) {
			jugador2 = c2.puntuacion(jugador1);
			Image cartaNueva = new Image(jugador2.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos2.setText("PUNTOS: "+ jugador2.getPuntuacion());
			turno=4;
			turnos(turno);
		}
	}
	public void turnoJugador4 (MouseEvent e) {
		if(turno == 5) {
			jugador4 = c4.puntuacion(jugador4);
			Image cartaNueva = new Image(jugador4.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos4.setText("PUNTOS: "+ jugador4.getPuntuacion());
			turno=6;
			turnos(turno);
		}
			
			
	}
	public void turnoJugador5 (MouseEvent e) {
		if(turno == 6) {
			jugador5 = c5.puntuacion(jugador1);
			Image cartaNueva = new Image(jugador5.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos5.setText("PUNTOS: "+ jugador5.getPuntuacion());
			turno=1;
			turnos(turno);
		}
			
			
	}
	public void turnoBanca (MouseEvent e) {
		if(turno == 1) {
			croupier = cBanca.puntuacion(croupier);
			Image cartaNueva = new Image(croupier.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntosBanca.setText("PUNTOS: "+ croupier.getPuntuacion());
			turno=2;
			turnos(turno);
		}

			
	}

	public void pedirCarta (MouseEvent e) {
		if(turno == 4) {
			Jugador jPlayer = cYo.puntuacion(yo);
			Image cartaNueva = new Image(jPlayer.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos3.setText("PUNTOS: "+ jPlayer.getPuntuacion());
			turno=5;
			turnos(turno);
		}

	}
	
	public void plantarse (MouseEvent e) {
		System.out.println("Adios");
	}
	
	/**
	 * Acciones que puede realizar el jugador
	 * @param jugador
	 */
	public void filtro(Jugador jugador) {
		
		if(jugador.getPuntuacion()>= 17 && jugador.getPuntuacion()<21) {
				//plantarse
		}else if(jugador.getPuntuacion() == 21) {
				//ganar
		}else if(jugador.getPuntuacion() > 22) {
				//perder
		}else {
				//pedir
			
		}
	}
	
	public void turnos (int turno) {
		switch (turno){
			case 1:
				turnoBanca.setVisible(true);
				turno1.setVisible(false);
				turno2.setVisible(false);
				turno3.setVisible(false);
				turno4.setVisible(false);
				turno5.setVisible(false);
				
				break;
			
			case 2:
				turno1.setVisible(true);
				turno2.setVisible(false);
				turno3.setVisible(false);
				turno4.setVisible(false);
				turno5.setVisible(false);
				turnoBanca.setVisible(false);
				
				break;
			case 3:
				System.out.println("empieza el jugador " + turno);
				turno1.setVisible(false);
				turno2.setVisible(true);
				turno3.setVisible(false);
				turno4.setVisible(false);
				turno5.setVisible(false);
				turnoBanca.setVisible(false);
				
				break;
			case 4:
				System.out.println("empieza el jugador " + turno);
				System.out.println("Es tu turno");
				turno1.setVisible(false);
				turno2.setVisible(false);
				turno3.setVisible(true);
				turno4.setVisible(false);
				turno5.setVisible(false);
				turnoBanca.setVisible(false);
				
				break;
			case 5:
				System.out.println("empieza el jugador " + turno);
				turno1.setVisible(false);
				turno2.setVisible(false);
				turno3.setVisible(false);
				turno4.setVisible(true);
				turno5.setVisible(false);
				turnoBanca.setVisible(false);
				
				break;
			case 6:
				System.out.println("empieza el jugador " + turno);
				turno1.setVisible(false);
				turno2.setVisible(false);
				turno3.setVisible(false);
				turno4.setVisible(false);
				turno5.setVisible(true);
				turnoBanca.setVisible(false);
				
				break;
			
		}
	}
}
