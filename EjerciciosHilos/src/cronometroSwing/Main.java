package cronometroSwing;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Cronometro cronometro = new Cronometro(new Interfaz());
		Thread hilo = new Thread(cronometro);
		hilo.start();
		scanner.nextLine();
		hilo.stop();
	}

}
