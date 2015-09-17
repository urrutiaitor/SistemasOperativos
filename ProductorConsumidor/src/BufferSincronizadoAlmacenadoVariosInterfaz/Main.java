package BufferSincronizadoAlmacenadoVariosInterfaz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
	

	final static int valoresMax = 30;
	final static int cantidadBufferes = 3;
	final static int cantidadProductores = 30;
	final static int cantidadConsumidores = 30;

	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		ArrayList<Buffer> bufferes = new ArrayList<>();
		ArrayList<Productor> productores = new ArrayList<Productor>();
		ArrayList<Consumidor> consumidores = new ArrayList<Consumidor>();
		Semaphore leer = new Semaphore(0);
		Semaphore escribir = new Semaphore(valoresMax);
		
		main.crearBufferes(bufferes, escribir, leer, cantidadBufferes);
		
		main.crearProductores(productores, bufferes, cantidadProductores);
		main.crearConsumidores(consumidores, bufferes, cantidadConsumidores);

		main.iniciarProductores(productores);
		main.iniciarConsumidores(consumidores);
		
		scanner.nextLine();
		
		main.pararProductores(productores);
		main.pararConsumidores(consumidores);
		
	}
	
	private void crearProductores(ArrayList<Productor> productores, ArrayList<Buffer> bufferes, int cantidad) {
		for(int i = 0; i < cantidad; i++){
			productores.add(new Productor(bufferes));
		}
	}
	
	private void crearConsumidores(ArrayList<Consumidor> consumidores, ArrayList<Buffer> bufferes, int cantidad) {
		for(int i = 0; i < cantidad; i++){
			consumidores.add(new Consumidor(bufferes));
		}
	}
	
	private void crearBufferes(ArrayList<Buffer> bufferes, Semaphore escribir, Semaphore leer, int cantidad) {
		for(int i = 0; i < cantidad; i++){
			bufferes.add(new Buffer(escribir, leer, i));
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
