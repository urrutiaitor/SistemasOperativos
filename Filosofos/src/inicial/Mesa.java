package inicial;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;

public class Mesa {

	int numFilosofos;
	
	Semaphore candadoPalillo[];
	
	public Mesa(int numFilosofos) {
		this.numFilosofos = numFilosofos;
		candadoPalillo = new Semaphore[numFilosofos];
		for (int i = 0; i < numFilosofos; i++) {
			candadoPalillo[i] = new Semaphore(1);
		}
	}

	public void cogerPalillo(int posicionPalillo) {
		try {
			candadoPalillo[posicionPalillo].acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comer(int posicion) {
		System.out.println("Filosofo " + posicion + " come");
		
	}

	public void dejarPalillo(int posicionPalillo) {
		candadoPalillo[posicionPalillo].release();
	}

	public int getNumFilosofos() {
		return numFilosofos;
	}

}
