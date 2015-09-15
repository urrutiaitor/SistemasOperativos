package EsperarVariasVeces;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Trabajador extends Thread {

	Semaphore semaforo;
	Semaphore semaforoAux;
	Trabajo trabajo;
	
	public Trabajador(Semaphore semaforo, Semaphore semaforoAux, Trabajo trabajo) {
		super();
		this.semaforo = semaforo;
		this.semaforoAux = semaforoAux;
		this.trabajo = trabajo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i = 0; i < 10; i++) {
			trabajo.trabajar(i);
			
			if(trabajo.añadirTrabajo()){
				System.out.println("---------");
				try {
					semaforoAux.acquire(semaforoAux.availablePermits());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semaforo.release(trabajo.getLimite() - 1);
			} else {
				try {
					semaforo.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(trabajo.crearTrabajo()){
				try {
					semaforo.acquire(semaforo.availablePermits());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semaforoAux.release(trabajo.getLimite() - 1);
			} else {
				try {
					semaforoAux.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("Hi!" + this.toString());
	}
}
