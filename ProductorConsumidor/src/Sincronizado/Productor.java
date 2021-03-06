package Sincronizado;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Productor extends Thread {

	Buffer buffer;
	Semaphore barreraEscrito;
	Semaphore barreraLeido;
	
	public Productor(Buffer buffer, Semaphore barreraEscrito, Semaphore barreraLeido) {
		this.buffer = buffer;
		this.barreraEscrito = barreraEscrito;
		this.barreraLeido = barreraLeido;
	}
	
	public void run() {
		Random random = new Random();
		
		while(true){
				
			try {
				barreraLeido.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffer.setNumero(random.nextInt(10));
			barreraEscrito.release();
			
		}
	}

}
