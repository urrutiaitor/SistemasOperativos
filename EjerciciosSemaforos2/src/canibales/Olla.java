package canibales;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Olla {

	int capacidadMax;
	int misioneros;
	
	Semaphore candadoCocinero;
	Semaphore candadoCanibal;
	
	public Olla(int capacidadMax){
		this.capacidadMax = capacidadMax;
		misioneros = 0;
		candadoCocinero = new Semaphore(1);
		candadoCanibal = new Semaphore(0);
	}
	
	public boolean llenarOlla()  throws InterruptedException{
		candadoCocinero.acquire();
		
		while(misioneros < capacidadMax){
			System.out.println("Cocinando");
			misioneros++;
		}
		System.out.println("Olla llena");
		candadoCanibal.release();
		
		return true;
	}
	
	public boolean comer() throws InterruptedException{
		candadoCanibal.acquire();
			
		System.out.println("Comiendo");
		System.out.println("Misioneros: " + misioneros);
		if(misioneros > 0) candadoCanibal.release();
		else candadoCocinero.release();
		
		return true;
	}
}
