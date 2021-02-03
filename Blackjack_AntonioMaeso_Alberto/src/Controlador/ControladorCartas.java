package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Modelo.Carta;

public class ControladorCartas {
	
	
	public List<Carta> creacion(){
		
		List<Carta> cartas = new ArrayList<Carta>();
		
		//Cartas Baraja Corazones
		
		String paloCorazones ="-Corazones";
		
		for (int i = 1; i <= 13; i++) {
			Carta carta = new Carta();
			carta.setNombre(i+paloCorazones);
			carta.setValor(i);
			carta.setRuta("img/"+i+paloCorazones+".jpg");
			cartas.add(carta);
		}
		
		//Cartas Baraja Diamantes
		
		String paloDiamante = "-Diamantes";
		
		for (int i = 1; i <= 13; i++) {
			Carta carta = new Carta();
			carta.setNombre(i+paloDiamante);
			carta.setValor(i);
			carta.setRuta("img/"+i+paloDiamante+".jpg");
			cartas.add(carta);
		}
		
		//Cartas Baraja Picas
		
		String paloPicas = "-Picas";
		
		for (int i = 1; i <= 13; i++) {
			Carta carta = new Carta();
			carta.setNombre(i+paloPicas);
			carta.setValor(i);
			carta.setRuta("img/"+i+paloPicas+".jpg");
			cartas.add(carta);
		}
		
		//Cartas Baraja Treboles
		
		String paloTreboles = "-Treboles";
		
		for (int i = 1; i <= 13; i++) {
			Carta carta = new Carta();
			carta.setNombre(i+paloTreboles);
			carta.setValor(i);
			carta.setRuta("img/"+i+paloTreboles+".jpg");
			cartas.add(carta);
		}
		
		
		return cartas;
		
	}
	
	public Carta getCarta(List<Carta> cartas) {
		Carta carta= null;
		int numero =(int)(52 * Math.random());
		int size = cartas.size();
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
