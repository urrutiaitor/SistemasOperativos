package escribirYLeerEnArray;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Main main = new Main();
		
		int cantidad = 10;
		int numeros[] = new int[4];
		
		main.crearNumeros(numeros);
		
		Semaphore candado = new Semaphore(1);
		ArrayList<Hilo> hilos = new ArrayList<Hilo>();
		main.crearHilos(cantidad, candado, hilos, numeros);
		main.iniciarHilos(hilos);
		
		Visualizador visualizador = new Visualizador(numeros);
		visualizador.start();
		
		scanner.nextLine();

		main.pararHilos(hilos);
		visualizador.stop();
	}
	
	private void crearNumeros(int[] numeros) {
		for(int i = 0; i < numeros.length; i++){
			numeros[i] = 0;
		}
	}

	private void crearHilos(int cantidad, Semaphore candado, ArrayList<Hilo> hilos, int numeros[]){
		for(int i = 0; i < cantidad; i++){
			hilos.add(new Hilo(numeros, i, candado));
		}
	}
	
	private void iniciarHilos(ArrayList<Hilo> hilos){
		for(int i = 0; i < hilos.size(); i++){
			hilos.get(i).start();
		}
	}

	private void pararHilos(ArrayList<Hilo> hilos){
		for(int i = 0; i < hilos.size(); i++){
			hilos.get(i).stop();
		}
	}
	
}
