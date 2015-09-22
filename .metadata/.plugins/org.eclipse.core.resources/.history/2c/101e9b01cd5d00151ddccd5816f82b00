package BufferSincronizadoAlmacenadoVariosLoMismo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
	

	final static int valoresMax = 30;
	final static int cantidadProductores = 1;
	final static int cantidadConsumidores = 2;

	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		ArrayList<Productor> productores = new ArrayList<Productor>();
		ArrayList<Consumidor> consumidores = new ArrayList<Consumidor>();
		Semaphore leer = new Semaphore(0);
		Semaphore escribir = new Semaphore(valoresMax);
		Buffer buffer = new Buffer(escribir, leer, valoresMax, cantidadConsumidores);
		
		main.crearProductores(productores, buffer, cantidadProductores);
		main.crearConsumidores(consumidores, buffer, cantidadConsumidores);

		main.iniciarProductores(productores);
		main.iniciarConsumidores(consumidores);
		
		scanner.nextLine();
		
		main.pararProductores(productores);
		main.pararConsumidores(consumidores);
		
	}
	
	private void crearProductores(ArrayList<Productor> productores, Buffer buffer, int cantidad) {
		for(int i = 0; i < cantidad; i++){
			productores.add(new Productor(buffer));
		}
	}
	
	private void crearConsumidores(ArrayList<Consumidor> consumidores, Buffer buffer, int cantidad) {
		for(int i = 0; i < cantidad; i++){
			consumidores.add(new Consumidor(buffer));
		}
	}
	
	private void iniciarProductores(ArrayList<Productor> productores) {
		for(int i = 0; i < productores.size(); i++){
			productores.get(i).start();
		}
	}
	
	private void iniciarConsumidores(ArrayList<Consumidor> consumidores) {
		for(int i = 0; i < consumidores.size(); i++){
			consumidores.get(i).start();
		}
	}
	
	private void pararProductores(ArrayList<Productor> productores) {
		for(int i = 0; i < productores.size(); i++){
			productores.get(i).stop();
		}
	}
	
	private void pararConsumidores(ArrayList<Consumidor> consumidores) {
		for(int i = 0; i < consumidores.size(); i++){
			consumidores.get(i).stop();
		}
	}

}
