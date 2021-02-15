package application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.xml.stream.events.StartDocument;

import Controlador.ControladorCartas;
import Controlador.ControladorJugadores;
import Modelo.Carta;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class SampleController {

	@FXML private ImageView cartaAdicional, carta1, carta2, carta3, carta4, carta5,
						turnoBanca, turno1, turno2, turno3, turno4, turno5, fondo;
	@FXML private Label puntosBanca, puntos1, puntos2, puntos3, puntos4, puntos5,
						nombre1, nombre2, nombre3, nombre4, nombre5, ultimoGanador, cartaBanca;
	@FXML private Button btnPedir, btnPlantarse;

	int turno = (int)(Math.random()*7);
	ControladorCartas controlador = new ControladorCartas();
	List<Jugador> jugadoresplantados = new ArrayList<Jugador>(); 
	Jugador jugador1 = new Jugador("Misil");
	Jugador jugador2 = new Jugador("Victor el machine");
	Jugador jugador4 = new Jugador("Ruben el duende");
	Jugador jugador5 = new Jugador("David el obseso");
	Jugador croupier = new Jugador("Edu la banca");
	Jugador yo = new Jugador("yo");
	ControladorJugadores c1 = new ControladorJugadores(jugador1);
	ControladorJugadores c2 = new ControladorJugadores(jugador2);
	ControladorJugadores c4 = new ControladorJugadores(jugador4);
	ControladorJugadores c5 = new ControladorJugadores(jugador5);
	ControladorJugadores cBanca = new ControladorJugadores(croupier);
	ControladorJugadores cYo = new ControladorJugadores(yo);
	

	public void initialize() {
	
		TextInputDialog dialog = new TextInputDialog("APTOOO");
		dialog.setTitle("Poker Stars");
		//dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
		dialog.setHeaderText("Introduce tu nombre");
		dialog.setContentText("Nombre");
		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		yo.setNombre(String.valueOf(result.get()));
		
		nombre1.setText(jugador1.getNombre());
		nombre2.setText(jugador2.getNombre());
		nombre3.setText(yo.getNombre());
		nombre4.setText(jugador4.getNombre());
		nombre5.setText(jugador5.getNombre());
		
		
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
		filtroentrada(jugador1);
		if(!jugador1.getSituacion().equals("pedir") ) {
			turno=3;
			turnos(turno);
		}else if(turno == 2) {
			jugador1 = c1.puntuacion(jugador1);
			Image cartaNueva = new Image(jugador1.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos1.setText("PUNTOS: "+ jugador1.getPuntuacion());
			filtro(jugador1);
			if(jugador1.getSituacion().equals("planta")) {
				jugadoresplantados.add(jugador1);
				puntos1.setText("PUNTOS: "+ jugador1.getPuntuacion()+" Se Planta");
			}else if(jugador1.getSituacion().equals("eliminado")) {
				puntos1.setText("ELIMINADO");
			}
			turno=3;
			turnos(turno);
		}
		
		
	}
	public void turnoJugador2 (MouseEvent e) {
		filtroentrada(jugador2);
		if(!jugador2.getSituacion().equals("pedir")) {
			turno=4;
			turnos(turno);
		}else if(turno == 3) {
			jugador2 = c2.puntuacion(jugador2);
			Image cartaNueva = new Image(jugador2.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos2.setText("PUNTOS: "+ jugador2.getPuntuacion());
			filtro(jugador2);
			if(jugador2.getSituacion().equals("planta")) {
				jugadoresplantados.add(jugador2);
				puntos2.setText("PUNTOS: "+ jugador2.getPuntuacion()+" Se Planta");
			}else if(jugador2.getSituacion().equals("eliminado")) {
				puntos2.setText("ELIMINADO");
			}
			turno=4;
			turnos(turno);
		}
	}
	public void turnoJugador4 (MouseEvent e) {
		filtroentrada(jugador4);
		if(!jugador4.getSituacion().equals("pedir")) {
			turno=6;
			turnos(turno);
		}else if(turno == 5) {
			jugador4 = c4.puntuacion(jugador4);
			Image cartaNueva = new Image(jugador4.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos4.setText("PUNTOS: "+ jugador4.getPuntuacion());
			filtro(jugador4);
			if(jugador4.getSituacion().equals("planta")) {
				jugadoresplantados.add(jugador4);
				puntos4.setText("PUNTOS: "+ jugador4.getPuntuacion()+" Se Planta");
			}else if(jugador4.getSituacion().equals("eliminado")) {
				puntos4.setText("ELIMINADO");
			}
			turno=6;
			turnos(turno);
		}
			
			
	}
	public void turnoJugador5 (MouseEvent e) {
		filtroentrada(jugador5);
		if(!jugador5.getSituacion().equals("pedir")) {
			turno=1;
			turnos(turno);
		}else if(turno == 6) {
			jugador5 = c5.puntuacion(jugador5);
			Image cartaNueva = new Image(jugador5.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos5.setText("PUNTOS: "+ jugador5.getPuntuacion());
			filtro(jugador5);
			if(jugador5.getSituacion().equals("planta")) {
				jugadoresplantados.add(jugador5);
				puntos5.setText("PUNTOS: "+ jugador5.getPuntuacion()+" Se Planta");
			}else if(jugador5.getSituacion().equals("eliminado")) {
				puntos5.setText("ELIMINADO");
			}
			turno=1;
			turnos(turno);
		}
			
			
	}
	public void turnoBanca (MouseEvent e) {
		
		filtroentrada(croupier);
		if(!croupier.getSituacion().equals("pedir")) {
			turno=2;
			turnos(turno);
		}else if(turno == 1) {
			croupier = cBanca.puntuacion(croupier);
			Image cartaNueva = new Image(croupier.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntosBanca.setText("PUNTOS BANCA: "+ croupier.getPuntuacion());
			Bancafiltro(croupier);
				if(croupier.getSituacion().equals("planta")) {
					jugadoresplantados.add(croupier);
					puntosBanca.setText("PUNTOS: "+ croupier.getPuntuacion()+" Se Planta");
				}else if(croupier.getSituacion().equals("eliminado")) {
					puntosBanca.setText("ELIMINADO");
					
				}
			turno=2;
			turnos(turno);
			
		}

			
	}

	public void pedirCarta (MouseEvent e) {
		filtroentrada(yo);
		if(!yo.getSituacion().equals("pedir")) {
			turno=5;
			turnos(turno);
		}else if(turno == 4) {
			yo = cYo.puntuacion(yo);
			Image cartaNueva = new Image(yo.getRutaCarta());
			cartaAdicional.setImage(cartaNueva); 
			puntos3.setText("PUNTOS: "+ yo.getPuntuacion());
			filtroPlayer(yo);
			turno=5;
			turnos(turno);
		}

	}
	
	public void plantarse (MouseEvent e) {
		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		 alert.setHeaderText(null);
		 alert.setTitle("Info");
		 alert.setContentText(yo.getNombre()+" se planta.");
		 alert.showAndWait();
		 yo.setSituacion("planta");
		 if(yo.getSituacion().equals("planta")) {
			 jugadoresplantados.add(yo);
				puntos3.setText("PUNTOS: "+ yo.getPuntuacion()+" Se Planta");
			}else if(yo.getSituacion().equals("eliminado")) {
				puntos3.setText("ELIMINADO");
			}
		 turno=5;
		 turnos(turno);
	}
	
	/**
	 * Acciones que puede realizar el jugador
	 * @param jugador
	 */
	public void filtro(Jugador jugador) {
		
		if(jugador.getPuntuacion()>= 17 && jugador.getPuntuacion()<21) {
			
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
			 alert.setHeaderText(null);
			 alert.setTitle("Info");
			 alert.setContentText(jugador.getNombre()+" se planta.");
			 alert.showAndWait();
			 jugador.setSituacion("planta");
			 
		}else if(jugador.getPuntuacion() == 21) {
   
		    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    alert.setHeaderText(null);
		    alert.setTitle("Confirmación");
		    alert.setContentText(jugador.getNombre()+" a ganado."+"\n¿Desea finalizar la partida?");
		    Optional<ButtonType> action = alert.showAndWait();
		    if (action.get() == ButtonType.OK) {
		    	System.exit(0);
		    }

		}else if(jugador.getPuntuacion() >= 22) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setHeaderText(null);
		    alert.setTitle("Info");
		    alert.setContentText(jugador.getNombre()+" a perdido.");
		    alert.showAndWait();
		    jugador.setSituacion("eliminado");
		}else {
				
		}
	}
	
	public void filtroPlayer(Jugador jugador) {
		
		if(jugador.getPuntuacion() == 21) {
			   
		    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    alert.setHeaderText(null);
		    alert.setTitle("Confirmación");
		    alert.setContentText(jugador.getNombre()+" a ganado."+"\n¿Desea finalizar la partida?");
		    Optional<ButtonType> action = alert.showAndWait();
		    if (action.get() == ButtonType.OK) {
		    	System.exit(0);
		    } 
		}
	}
	
	public void Bancafiltro(Jugador jugador) {
		if(jugador.getPuntuacion()>= 17 && jugador.getPuntuacion()<21) {
			
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
			 alert.setHeaderText(null);
			 alert.setTitle("Info");
			 alert.setContentText(jugador.getNombre()+" se planta.");
			 alert.showAndWait();
			 jugador.setSituacion("planta");
			 
		}else if(jugador.getPuntuacion() == 21) {
  
		    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    alert.setHeaderText(null);
		    alert.setTitle("Confirmación");
		    alert.setContentText(jugador.getNombre()+" a ganado."+"\n ¿Desea finalizar la partida?");
		    Optional<ButtonType> action = alert.showAndWait();
		    if (action.get() == ButtonType.OK) {
		    	System.exit(0);
		    }

		}else if(jugador.getPuntuacion() >= 22) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		    alert.setHeaderText(null);
		    alert.setTitle("Confirmación");
		    alert.setContentText(jugador.getNombre()+" a perdido.\nLos jugadores que no han se han pasado de 21 ganan."+"\n¿Desea reiniciar la partida?");
		    Optional<ButtonType> action = alert.showAndWait();
		    if (action.get() == ButtonType.OK) {
		    	System.exit(0);
		    }
		}else {
				
		}
	}
	
	
	public void filtroentrada(Jugador jugador) {
		if(jugador.getPuntuacion()>= 17 && jugador.getPuntuacion()<21) {
			 jugador.setSituacion("Planta");
		}else if(jugador.getPuntuacion() > 22) {
		    jugador.setSituacion("eliminado");
		}else {
			jugador.setSituacion("pedir");
		}
	}
	
	
	public void ganadoresPlan() {
		
		//Collections.sort(jugadoresplantados);
		
		String ganadores="";
		for (int i = 0; i < jugadoresplantados.size(); i++) {
			ganadores = ganadores +"\n"+(jugadoresplantados.get(i)).getNombre();
		}	
		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		 alert.setHeaderText(null);
		 alert.setTitle("Info");
		 alert.setContentText(ganadores);
		 alert.showAndWait();	
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
