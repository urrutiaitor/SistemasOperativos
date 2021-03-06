package transbordador;

import java.util.concurrent.Semaphore;

public class Transbordador extends Thread {
	int numMaxCoches;
	boolean abierto;
	Semaphore semaforoCoche;
	Semaphore semaforoTransbordador;
	
	public Transbordador(int numMaxCoches) {
		super();
		this.numMaxCoches = numMaxCoches;
		abierto = true;
		
		semaforoCoche = new Semaphore(numMaxCoches);
		semaforoTransbordador = new Semaphore(0);
	}
	
	public void meterCoche(int id) throws InterruptedException{
		semaforoCoche.acquire();
		System.out.println("Coche " + id);
		semaforoTransbordador.release();
	}
	
	public void cruzar() throws InterruptedException{
		semaforoTransbordador.acquire(numMaxCoches);
		
		System.out.println("Cruzando rio");
		Thread.sleep(100);
		System.out.println("Dando vuelta");
		Thread.sleep(100);
		
		semaforoCoche.release(numMaxCoches);
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void cerrar() {
		abierto = false;
	}
	
	
}
