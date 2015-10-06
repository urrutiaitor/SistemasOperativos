package bañosCompartidos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	final static int numMaxPersonas = 3;
	final static int numChicos = 10;
	final static int numChicas = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();

		ArrayList<Chico> chicos = new ArrayList<Chico>();
		ArrayList<Chica> chicas = new ArrayList<Chica>();
		
		Baño baño = new Baño(numMaxPersonas);
		
		crearPersonas(chicos, chicas, baño);
		
		iniciarPersonas(chicos, chicas);
		
		scanner.nextLine();
		
		pararPersonas(chicos, chicas);
	}

	private static void crearPersonas(ArrayList<Chico> chicos, ArrayList<Chica> chicas, Baño baño) {
		for(int i = 0; i < numChicos; i++){
			chicos.add(new Chico(i, baño));
		}
		for(int i = 0; i < numChicas; i++){
			chicas.add(new Chica(i, baño));
		}
	}

	private static void iniciarPersonas(ArrayList<Chico> chicos, ArrayList<Chica> chicas) {
		for(int i = 0; i < numChicos; i++){
			chicos.get(i).start();
		}
		for(int i = 0; i < numChicas; i++){
			chicas.get(i).start();
		}
	}

	private static void pararPersonas(ArrayList<Chico> chicos, ArrayList<Chica> chicas) {
		for(int i = 0; i < numChicos; i++){
			chicos.get(i).setDespierto(false);
			chicos.get(i).interrupt();
		}
		for(int i = 0; i < numChicas; i++){
			chicas.get(i).setDespierto(false);
			chicas.get(i).interrupt();
		}
	}

}
