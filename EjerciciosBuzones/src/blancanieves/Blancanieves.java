package blancanieves;

public class Blancanieves extends Thread {

	BuzonAsincrono buzonEntrar;
	BuzonSincrono buzonComer;
	int numEnanitos;

	
	
	public Blancanieves(BuzonAsincrono buzonEntrar, BuzonSincrono buzonComer, int numEnanitos) {
		super();
		this.buzonEntrar = buzonEntrar;
		this.buzonComer = buzonComer;
		this.numEnanitos = numEnanitos;
	}



	public void run () {
		int posicion;
		
		for (int i = 0; i < numEnanitos; i++) {
			posicion = (int) buzonComer.receive();
			System.out.println("Blancanieves da de comer a enanito en posicion " + posicion);
		}
		System.out.println("Blanca nieves se va a dormir");
	}
}
