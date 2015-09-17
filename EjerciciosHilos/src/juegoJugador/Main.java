package juegoJugador;

import java.util.concurrent.Semaphore;

public class Main {

	final static int vidas = 1000000;
	
	public static void main(String[] args) {
		Jugador jugador = new Jugador(vidas/2);
		Semaphore semaforo = new Semaphore(1);
		HiloNegativo hiloNeg = new HiloNegativo(semaforo, jugador);
		HiloPositibo hiloPos = new HiloPositibo(semaforo, jugador);
		
		hiloNeg.start();
		hiloPos.start();
	
	
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(jugador.getVidas() == vidas){
				System.out.println("El hilo positibo ha ganado");
				hiloNeg.stop();
				break;
			}
			if(jugador.getVidas() == 0){
				System.out.println("El hilo negativo ha ganado");
				hiloPos.stop();
				break;
			}
		}
	}

}
