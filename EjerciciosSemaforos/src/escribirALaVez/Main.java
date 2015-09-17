package escribirALaVez;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	final static int numEscritores = 10;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Semaphore semaforoA = new Semaphore(1, true);
		Semaphore semaforoB = new Semaphore(0, true);
		Semaphore semaforoC = new Semaphore(0, true);

		Escritor escritorA = new Escritor(semaforoA, semaforoB, "A");
		Escritor escritorB = new Escritor(semaforoB, semaforoC, "B");
		Escritor escritorC = new Escritor(semaforoC, semaforoA, "C");
		
		escritorA.start();
		escritorB.start();
		escritorC.start();
	
		scanner.nextLine();
		
		escritorA.stop();
		escritorB.stop();
		escritorC.stop();
	}

}
