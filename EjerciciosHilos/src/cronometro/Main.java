package cronometro;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Cronometro cronometro = new Cronometro();
		cronometro.start();
		scanner.nextLine();
		cronometro.stop();
	}

}