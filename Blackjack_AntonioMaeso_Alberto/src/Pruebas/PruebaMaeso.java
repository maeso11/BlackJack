package Pruebas;

public class PruebaMaeso {
	
	
	public void turnoAleatorio() {
		int random = (int)(Math.random()*5);

		
		switch (random){
			case 1:
				System.out.println("empieza el jugador " + random);
				break;
			case 2:
				System.out.println("empieza el jugador " + random);
				break;
			case 3:
				System.out.println("empieza el jugador " + random);
				break;
			case 4:
				System.out.println("empieza el jugador " + random);
				break;
			case 5:
				System.out.println("empieza el jugador " + random);
				break;
		}
	}
	
	public void main (String [] args) {
		PruebaMaeso pruebas = new PruebaMaeso();
		pruebas.turnoAleatorio();
	}
}
