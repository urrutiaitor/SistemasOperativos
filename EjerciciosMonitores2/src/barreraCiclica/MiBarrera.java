package barreraCiclica;
import java.util.concurrent.Semaphore;


public class MiBarrera {
	
	Object barreraEntrada, barreraSalida;
	int contador;
	int numHilos;
	Runnable runnable;
	
	public  MiBarrera(int numHilos, Runnable runnable){
		barreraEntrada = new Semaphore(0);
		barreraSalida = new Semaphore(0);
		contador = 0;
		this.numHilos = numHilos;
		this.runnable = runnable;
	}
	
	public void esperar() throws InterruptedException{
		
		/*
		 * try {
			synchronized (this) {
				contador++;
				
				if (contador == numHilos){
					if (runnable !=null) runnable.run();
					barreraSalida.notifyAll();	
				} else {
					barreraSalida.wait();	
				}
			}
			
			synchronized (this) {
				contador --;
				
				if (contador == 0){
					barreraEntrada.notifyAll();
				} else {
					barreraEntrada.wait();
				}
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		synchronized (this) {
			contador++;
			
			if (contador == numHilos){
				if (runnable !=null) runnable.run();
				barreraSalida.notifyAll();	
			} else {
				System.out.println("Wait");
				barreraSalida.wait();	
			}
		}
		
		synchronized (this) {
			contador --;
			
			if (contador == 0){
				barreraEntrada.notifyAll();
			} else {
				barreraEntrada.wait();
			}
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
