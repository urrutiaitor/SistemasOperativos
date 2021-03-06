package BufferSincronizadoAlmacenado;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
	

	final static int valoresMax = 30;

	public static void main(String[] args) {
		System.out.println("Start");
		Scanner scanner = new Scanner(System.in);
		Semaphore leer = new Semaphore(0);
		Semaphore escribir = new Semaphore(valoresMax);
		Buffer buffer = new Buffer(escribir, leer);
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);

		productor.start();
		consumidor.start();
		
		scanner.nextLine();
		
		productor.stop();
		consumidor.stop();
		
	}

}
