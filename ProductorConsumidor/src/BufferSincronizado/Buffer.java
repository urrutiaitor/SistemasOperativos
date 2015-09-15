package BufferSincronizado;

import java.util.concurrent.Semaphore;

public class Buffer {

	int numero;
	Semaphore barreraEscrito;
	Semaphore barreraLeido;

	public Buffer(Semaphore barreraEscrito, Semaphore barreraLeido) {
		this.barreraEscrito = barreraEscrito;
		this.barreraLeido = barreraLeido;
	}

	public int getNumero() {
		
		try {
			barreraEscrito.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		barreraLeido.release();
		
		System.out.println("Numero leido: " + numero);
		
		return numero;
		
	}

	public void setNumero(int numero) {
		try {
			barreraLeido.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.numero = numero;
		System.out.println("Numero escrito: " + numero);
		barreraEscrito.release();
		
	}
	
}
