package canibales;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	final static int capacidadMax = 200000;
	final static int numCanibales = 5000000;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();
		Olla olla = new Olla(capacidadMax);
		Cocinero cocinero = new Cocinero(olla);
		ArrayList<Canibal> canibales = new ArrayList<Canibal>();
		main.crearCanibales(canibales, olla);
		cocinero.start();
		main.iniciarCanibales(canibales);
		scanner.nextLine();
		System.out.println("ENTER PUSHED");
		main.pararCanibales(canibales);
		cocinero.setDespierto(false);
		System.out.println("Dormir");
		cocinero.interrupt();
		System.out.println("Cocinero interrumpido");
		System.out.println("_________________________________Finished_____________________________");
	}
	
	public void crearCanibales(ArrayList<Canibal> canibales, Olla olla){
		for(int i = 0; i < numCanibales; i++){
			canibales.add(new Canibal(olla, i + 1));
		}
	}
	
	public void iniciarCanibales(ArrayList<Canibal> canibales){
		for(int i = 0; i < canibales.size(); i++){
			canibales.get(i).start();
		}
	}
	
	public void pararCanibales(ArrayList<Canibal> canibales){
		for(int i = 0; i < canibales.size(); i++){
			canibales.get(i).setHambriento(false);
			canibales.get(i).interrupt();
		}
	}

}
