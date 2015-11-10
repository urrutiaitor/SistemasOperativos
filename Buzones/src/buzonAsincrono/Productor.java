package buzonAsincrono;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Productor extends Thread {

	BuzonAsincrono buzon;
	
	public Productor(BuzonAsincrono buzon) {
		this.buzon = buzon;
	}
	
	public void run() {
		Random random = new Random();
		
		while(true){
			int numero = random.nextInt(10);
			System.out.println(numero + " <");
			buzon.send(numero);
			
		}
	}

}
