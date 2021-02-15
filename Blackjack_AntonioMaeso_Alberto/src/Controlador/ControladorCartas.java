package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Modelo.Carta;

public class ControladorCartas {
	
	List<Carta> cartas = new ArrayList<Carta>();
	public List<Carta> creacion(){
		

		
		//Cartas Baraja Corazones
		
		String paloCorazones ="-Corazones";
		
		for (int i = 1; i <= 13; i++) {
			Carta carta = new Carta();
			carta.setNombre(i+paloCorazones);
			carta.setValor(i);
			carta.setRuta("img/Baraja/Corazones/"+i+paloCorazones+".jpg");
			cartas.add(carta);
		}
		
		//Cartas Baraja Diamantes
		
		String paloDiamante = "-Diamantes";
		
		for (int i = 1; i <= 13; i++) {
			Carta carta = new Carta();
			carta.setNombre(i+paloDiamante);
			carta.setValor(i);
			carta.setRuta("img/Baraja/Diamantes/"+i+paloDiamante+".jpg");
			cartas.add(carta);
		}
		
		//Cartas Baraja Picas
		
		String paloPicas = "-Picas";
		
		for (int i = 1; i <= 13; i++) {
			Carta carta = new Carta();
			carta.setNombre(i+paloPicas);
			carta.setValor(i);
			carta.setRuta("img/Baraja/Picas/"+i+paloPicas+".jpg");
			cartas.add(carta);
		}
		
		//Cartas Baraja Treboles
		
		String paloTreboles = "-Treboles";
		
		for (int i = 1; i <= 13; i++) {
			Carta carta = new Carta();
			carta.setNombre(i+paloTreboles);
			carta.setValor(i);
			carta.setRuta("img/Baraja/Treboles/"+i+paloTreboles+".jpg");
			cartas.add(carta);
		}
		
		
		return cartas;
		
	}
	
	/**
	 * devuelve una carta al azar de la baraja
	 * @param cartas
	 * @return
	 */
	public Carta getCarta(List<Carta> cartas) {
		Carta carta= new Carta();
		int size = cartas.size();
		int numero =(int)(size * Math.random());

		for (int i = size -1; i >= 0; i --) {
				if(i == numero) {
					carta = cartas.get(i);
					cartas.remove(i);
				}
		}
		return carta;
	}
	
	
	public static void main(String[]args) {
		ControladorCartas cc = new ControladorCartas();
		List<Carta> cartas = cc.creacion();
		Carta carta = cc.getCarta(cartas);
		System.out.println(carta);	
	}

}
