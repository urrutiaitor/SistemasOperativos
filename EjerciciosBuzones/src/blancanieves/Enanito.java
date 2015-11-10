package blancanieves;

public class Enanito extends Thread {

	BuzonAsincrono buzonEntrar;
	BuzonSincrono buzonComer;
	int id;
	
	
	
	public Enanito(BuzonAsincrono buzonEntrar, BuzonSincrono buzonComer, int id) {
		super();
		this.buzonEntrar = buzonEntrar;
		this.buzonComer = buzonComer;
		this.id = id;
	}



	public void run () {
		int posicion;
		
		System.out.println("Enanito " + id + " viene de trabajar y esta hambriento");

		posicion = (int) buzonEntrar.receive();
		
		buzonComer.send(posicion);
		
		System.out.println("El enanito " + id + " se va a trabajar");
		
		buzonEntrar.send(posicion);
	}

}
