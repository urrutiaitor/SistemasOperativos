package escribirYLeerEnArray;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Hilo extends Thread {

	int numeros[];
	int id;
	Semaphore candado;
	
	
	public Hilo(int[] numeros, int id, Semaphore candado) {
		super();
		this.numeros = numeros;
		this.id = id;
		this.candado = candado;
	}


	@Override
	public void run() {
		Random random = new Random();
		while(true){
			
			try {
				candado.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int numero = random.nextInt(numeros.length);
			numeros[numero] = id;
			candado.release();
		}
	}
	
}
