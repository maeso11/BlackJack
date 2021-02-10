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
	Jugador jugador1;
	Jugador jugador2;
	Jugador jugador4;
	Jugador jugador5;
	Jugador croupier;
	Jugador yo;
	
	

	public void initialize() {
		ControladorJugadores c1 = new ControladorJugadores(jugador1);
		ControladorJugadores c2 = new ControladorJugadores(jugador2);
		ControladorJugadores c4 = new ControladorJugadores(jugador4);
		ControladorJugadores c5 = new ControladorJugadores(jugador5);
		ControladorJugadores cBanca = new ControladorJugadores(croupier);
		ControladorJugadores cYo = new ControladorJugadores(yo);
		
		c1.recogerCarta(controlador.getCarta(cartas));
		c2.recogerCarta(controlador.getCarta(cartas));
		c4.recogerCarta(controlador.getCarta(cartas));
		c5.recogerCarta(controlador.getCarta(cartas));
		cBanca.recogerCarta(controlador.getCarta(cartas));
		cYo.recogerCarta(controlador.getCarta(cartas));
		
		turnos(turno);

		
	}
	
	public void turnoJugador (MouseEvent e) {
		
		Carta carta = controlador.getCarta(cartas);
		File file = new File(carta.getRuta());
		Image cartaNueva = new Image(carta.getRuta());
		cartaAdicional.setImage(cartaNueva);
	}
	public void pedirCarta (MouseEvent e) {
		System.out.println("Adios");
	}
	
	public void plantarse (MouseEvent e) {
		System.out.println("Adios");
	}
	
	public void turnos (int turno) {
		switch (turno){
			case 1:
				turno2.setVisible(false);
				turno3.setVisible(false);
				turno4.setVisible(false);
				turno5.setVisible(false);
				turnoBanca.setVisible(false);
				break;
			case 2:
				System.out.println("empieza el jugador " + turno);
				turno1.setVisible(false);
				turno3.setVisible(false);
				turno4.setVisible(false);
				turno5.setVisible(false);
				turnoBanca.setVisible(false);
				break;
			case 3:
				System.out.println("empieza el jugador " + turno);
				System.out.println("Es tu turno");
				turno1.setVisible(false);
				turno2.setVisible(false);
				turno4.setVisible(false);
				turno5.setVisible(false);
				turnoBanca.setVisible(false);
				break;
			case 4:
				System.out.println("empieza el jugador " + turno);
				turno1.setVisible(false);
				turno2.setVisible(false);
				turno3.setVisible(false);
				turno5.setVisible(false);
				turnoBanca.setVisible(false);
				break;
			case 5:
				System.out.println("empieza el jugador " + turno);
				turno1.setVisible(false);
				turno2.setVisible(false);
				turno3.setVisible(false);
				turno4.setVisible(false);
				turnoBanca.setVisible(false);
				break;
			case 6:
				turno1.setVisible(false);
				turno2.setVisible(false);
				turno3.setVisible(false);
				turno4.setVisible(false);
				turno5.setVisible(false);
				break;
		}
	}
}
