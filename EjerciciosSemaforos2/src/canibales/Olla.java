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
		System.out.print("Cocinando");
		while(misioneros < capacidadMax){
			System.out.print(".");
			misioneros++;
		}
		System.out.println(" Olla llena");
		candadoCanibal.release();
		
		return true;
	}
	
	public boolean comer(int id) throws InterruptedException{
		candadoCanibal.acquire();
		misioneros--;
		
		if(misioneros > 0) candadoCanibal.release();
		else candadoCocinero.release();
		
		System.out.println(id + " comiendo");
		System.out.println("Misioneros: " + misioneros);
		
		return true;
	}
}
