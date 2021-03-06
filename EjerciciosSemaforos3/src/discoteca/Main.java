package discoteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final int aforo = 300;
	final static int numChicos = 2000;
	final static int numChicas = 2000;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();

		ArrayList<Chico> chicos = new ArrayList<Chico>();
		ArrayList<Chica> chicas = new ArrayList<Chica>();
		
		Discoteca discoteca = new Discoteca(aforo);
		
		main.crearPersonas(chicos, chicas, discoteca);
		
		main.iniciarPersonas(chicos, chicas);
		
		scanner.nextLine();
		
		discoteca.cerrar();
	}

	private void crearPersonas(ArrayList<Chico> chicos, ArrayList<Chica> chicas, Discoteca discoteca) {
		for(int i = 0; i < numChicos; i++){
			chicos.add(new Chico(discoteca, i));
		}
		for(int i = 0; i < numChicas; i++){
			chicas.add(new Chica(discoteca, i));
		}
	}

	private void iniciarPersonas(ArrayList<Chico> chicos, ArrayList<Chica> chicas) {
		for(int i = 0; i < numChicos; i++){
			chicos.get(i).start();
		}
		for(int i = 0; i < numChicas; i++){
			chicas.get(i).start();
		}
	}

}
