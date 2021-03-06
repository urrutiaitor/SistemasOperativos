package discoteca;

import java.util.concurrent.Semaphore;

public class Discoteca {

	boolean abierta;
	int aforo;
	Semaphore semaforoDiscoteca;
	Semaphore semaforoChicos;
	
	public Discoteca(int aforo) {
		super();
		this.aforo = aforo;
		abierta = true;
		
		semaforoDiscoteca = new Semaphore(aforo);
		semaforoChicos = new Semaphore(0);
	}

	public void entrarChico(int id){
		try {
			semaforoChicos.acquire();
			if(!semaforoDiscoteca.tryAcquire()) semaforoChicos.release(); //no esta bien
		} catch (InterruptedException e) {
			System.err.println("Chico " + id + " interrumpido");
			return;
		}
		
		System.out.println("Chico " + id + " baila y se va");
		semaforoChicos.release();
		semaforoDiscoteca.release();
	}
	
	public void entrarChica(int id){
		try {
			semaforoDiscoteca.acquire();
		} catch (InterruptedException e) {
			System.err.println("Chica " + id + " interrumpido");
			return;
		}
		System.out.println("Chica " + id + " entra");
		semaforoChicos.release();
		try {
			semaforoChicos.acquire();
		} catch (InterruptedException e) {
			System.err.println("Chica " + id + " interrumpido");
			return;
		}
		System.out.println("Chica " + id + " baila y se va");
		semaforoDiscoteca.release();
	}

	public void cerrar() {
		abierta = false;
	}

	public boolean isAbierta() {
		return abierta;
	}
	
}
