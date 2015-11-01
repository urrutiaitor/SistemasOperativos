package buzonSincrono;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BuzonSincrono buzon = new BuzonSincrono();
		Productor productor = new Productor(buzon);
		Consumidor consumidor = new Consumidor(buzon);

		productor.start();
		consumidor.start();
		
		//scanner.nextLine();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productor.stop();
		consumidor.stop();
		
	}

}
