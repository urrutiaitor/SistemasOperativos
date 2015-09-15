package Inicial;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Trabajador extends Thread {

	Semaphore semaforo;
	Trabajo trabajo;
	
	public Trabajador(Semaphore semaforo, Trabajo trabajo) {
		super();
		this.semaforo = semaforo;
		this.trabajo = trabajo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		trabajo.trabajar();
		System.out.println("Trabajo terminado" + this.toString());
		
		if(trabajo.añadirTrabajo()){
			semaforo.release(trabajo.getLimite());
		}
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hi!" + this.toString());
	}

	
	
	
}
