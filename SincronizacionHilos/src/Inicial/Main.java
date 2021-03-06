package Inicial;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int trabajos = 10;
		Semaphore semaforo = new Semaphore(0, true);
		Trabajo trabajo = new Trabajo(trabajos);
		Trabajador trabajador;
		ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
		
		for (int i = 0; i < trabajos; i++){
			trabajador = new Trabajador(semaforo, trabajo);
			trabajadores.add(trabajador);
		}
		System.out.println("Trabajadores creados");
		
		for (int i = 0; i < trabajos; i++){
			trabajadores.get(i).start();
		}
		System.out.println("Trabajadores en marcha");
		
		for (int i = 0; i< trabajos; i++){
			try {
				trabajadores.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Finished");
	}

}
