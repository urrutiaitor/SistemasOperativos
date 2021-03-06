package barberia;

import java.util.concurrent.Semaphore;

public class Barberia {

	int aforo;
	boolean abierta;
	
	Semaphore semaforoBarberia;
	Semaphore semaforoBarbero;

	public Barberia(int aforo) {
		super();
		this.aforo = aforo;
		abierta = true;
		
		semaforoBarberia = new Semaphore(aforo);
		semaforoBarbero = new Semaphore(0);
	}
	
	public void entrar(int id){
		try {
			semaforoBarberia.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cliente " + id);
		semaforoBarbero.release();
	}
	
	public void trabajar(){
		try {
			semaforoBarbero.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaforoBarberia.release();
		System.out.println("Cortando");
	}

	public void cerrar() {
		abierta = false;
	}
	
	public boolean isAbierta(){
		return abierta;
	}
	
}
