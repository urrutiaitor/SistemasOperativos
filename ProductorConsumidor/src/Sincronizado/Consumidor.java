package Sincronizado;

import java.util.concurrent.Semaphore;

public class Consumidor extends Thread {

	Buffer buffer;
	Semaphore barreraEscrito;
	Semaphore barreraLeido;
	
	public Consumidor(Buffer buffer, Semaphore barreraEscrito, Semaphore barreraLeido) {
		this.buffer = buffer;
		this.barreraEscrito = barreraEscrito;
		this.barreraLeido = barreraLeido;
	}

	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				barreraEscrito.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("> " + buffer.getNumero());
			barreraLeido.release();
			
		}
	}
	
}
