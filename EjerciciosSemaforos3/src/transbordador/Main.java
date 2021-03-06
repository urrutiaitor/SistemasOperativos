package transbordador;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	final static int numMaxCoches = 3;
	final static int numCoches = 10;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();
		
		Transbordador transbordador = new Transbordador(numMaxCoches);
		Capitan capitan = new Capitan(transbordador);
		ArrayList<Coche> coches = new ArrayList<Coche>();
		
		main.crearCoches(coches, transbordador);
		
		capitan.start();
		main.iniciarCoches(coches);
		
		scanner.nextLine();
		
		transbordador.cerrar();
		capitan.interrupt();
		main.pararCoches(coches);
	}

	private void crearCoches(ArrayList<Coche> coches, Transbordador transbordador) {
		for(int i = 0; i < numCoches; i++){
			coches.add(new Coche(transbordador, i));
		}
	}

	private void iniciarCoches(ArrayList<Coche> coches) {
		for(int i = 0; i < numCoches; i++){
			coches.get(i).start();
		}
	}

	private void pararCoches(ArrayList<Coche> coches) {
		for(int i = 0; i < numCoches; i++){
			coches.get(i).interrupt();
		}
	}

}
