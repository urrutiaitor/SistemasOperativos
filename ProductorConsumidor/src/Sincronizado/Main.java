package Sincronizado;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Semaphore barreraLeido = new Semaphore(1);
		Semaphore barreraEscrito = new Semaphore(0);
		Buffer buffer = new Buffer();
		Productor productor = new Productor(buffer, barreraEscrito, barreraLeido);
		Consumidor consumidor = new Consumidor(buffer, barreraEscrito, barreraLeido);

		productor.start();
		consumidor.start();
		
		scanner.nextLine();
		
		productor.stop();
		consumidor.stop();
		
	}

}
