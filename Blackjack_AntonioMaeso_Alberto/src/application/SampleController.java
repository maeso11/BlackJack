package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Controlador.ControladorCartas;
import Modelo.Carta;
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

	@FXML private ImageView cartaBanca, carta1, carta2, carta3, carta4, carta5,
						turnoBanca, turno1, turno2, turno3, turno4, turno5;
	@FXML private Label puntosBanca, puntos1, puntos2, puntos3, puntos4, puntos5,
						nombre1, nombre2, nombre3, nombre4, nombre5, ultimoGanador;
	int turno = (int)(Math.random()*5);
	ControladorCartas controlador = new ControladorCartas();
	List<Carta> cartas = controlador.creacion();
	

	public void initialize() {
		
		
		switch (turno){
			case 1:
				System.out.println("empieza el jugador " + turno);
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
		}
	}
	
	public void turnoJugador1 (MouseEvent e) {
		//
		Carta carta = controlador.getCarta(cartas);
		File file = new File(carta.getRuta());
		Image cartaNueva = new Image(file.toURI().toString());
		carta1.setImage(cartaNueva);
	}
	public void pedirCarta (MouseEvent e) {
		System.out.println("Adios");
	}
	
	public void plantarse (MouseEvent e) {
		System.out.println("Adios");
	}
	
	
}
