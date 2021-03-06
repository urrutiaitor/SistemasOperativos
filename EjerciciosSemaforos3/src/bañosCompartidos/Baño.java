package bañosCompartidos;

import java.util.concurrent.Semaphore;

public class Baño {

	int numMaxPersonas;
	Semaphore semaforoBañoChicos;
	Semaphore semaforoBañoChicas;
	int numChicos;
	int numChicas;

	public Baño(int numMaxPersonas) {
		super();
		this.numMaxPersonas = numMaxPersonas;
		semaforoBañoChicos = new Semaphore(numMaxPersonas);
		semaforoBañoChicas = new Semaphore(0);
		numChicos = 0;
		numChicas = 0;
	}

	public void utilizar(String genero, int id) throws InterruptedException {
		if (genero.toUpperCase().equals("CHICO")) {
			semaforoBañoChicos.acquire();
			synchronized (this) {
				
				numChicos++;
				System.out.println("Chico " + id);
				
				if((semaforoBañoChicas.hasQueuedThreads())&&(numChicos == numMaxPersonas)){
					numChicos = 0;
					semaforoBañoChicas.release(numMaxPersonas);
					System.out.println("--------------------");
				}
				else if((!semaforoBañoChicas.hasQueuedThreads())&&(numChicos == numMaxPersonas)){
					numChicos = 0;
					semaforoBañoChicos.release(numMaxPersonas);
					System.out.println("--------------------");
				}
			}
		}
		if (genero.toUpperCase().equals("CHICA")) {
			semaforoBañoChicas.acquire();
			synchronized (this) {
				numChicas++;
				if((semaforoBañoChicos.hasQueuedThreads())&&(numChicas == numMaxPersonas)){
					numChicas = 0;
					semaforoBañoChicos.release(numMaxPersonas);
					System.out.println("--------------------");
				}
				if((!semaforoBañoChicos.hasQueuedThreads())&&(numChicas == numMaxPersonas)){
					numChicas = 0;
					semaforoBañoChicas.release(numMaxPersonas);
					System.out.println("--------------------");
				}
			}
			System.out.println("Chica " + id);
		}
		
	}
}
