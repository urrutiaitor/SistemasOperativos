package buzonAsincrono;

public class Consumidor extends Thread {

	BuzonAsincrono buzon;
	
	public Consumidor(BuzonAsincrono buzon) {
		this.buzon = buzon;
	}

	public void run() {
		
		while (true) {
			System.out.println("\t> " + buzon.receive());
		}
	}
	
}



