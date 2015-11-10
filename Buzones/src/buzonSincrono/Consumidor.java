package buzonSincrono;

public class Consumidor extends Thread {

	BuzonSincrono buzon;
	
	public Consumidor(BuzonSincrono buzon) {
		this.buzon = buzon;
	}

	public void run() {
		
		while (true) {
			
			System.out.println("\t> " + buzon.receive());
			
		}
	}
	
}



