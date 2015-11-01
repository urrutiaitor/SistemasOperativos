package buzonSincrono;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Productor extends Thread {

	BuzonSincrono buzon;
	
	public Productor(BuzonSincrono buzon) {
		this.buzon = buzon;
	}
	
	public void run() {
		Random random = new Random();
		
		while(true){
			
			try {
				Thread.sleep(00);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int numero = random.nextInt(10);
			System.out.println(numero + " <");
			buzon.send(numero);
			
		}
	}

}
