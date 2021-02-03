package Pruebas;

public class PruebaMaeso {
	
	
	public void turnoAleatorio() {
		int [] turno = {1, 2, 3, 4, 5};
		int random = (int)(Math.random()*5);
		System.out.println(turno[random]);
	}
	
	public void main (String [] args) {
		PruebaMaeso pruebas = new PruebaMaeso();
		pruebas.turnoAleatorio();
	}
}
