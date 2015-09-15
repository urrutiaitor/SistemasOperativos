package Inicial;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Buffer buffer = new Buffer();
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);

		productor.start();
		consumidor.start();
		
		scanner.nextLine();
		
		productor.stop();
		/*
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productor.stop();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		consumidor.stop();
		*/
		
	}

}
