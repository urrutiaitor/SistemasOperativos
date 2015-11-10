package buzonAsincrono;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BuzonAsincrono buzon = new BuzonAsincrono(10);
		Productor productor = new Productor(buzon);
		Consumidor consumidor = new Consumidor(buzon);

		productor.start();
		consumidor.start();
		
		//scanner.nextLine();
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productor.stop();
		consumidor.stop();
		
	}

}
