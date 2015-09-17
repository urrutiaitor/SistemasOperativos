package juegoJugador;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class HiloPositibo extends Thread{

	final int numeroSecreto = 3;
	Semaphore candado;
	Jugador jugador;
	
	public HiloPositibo(Semaphore candado, Jugador jugador) {
		super();
		this.candado = candado;
		this.jugador = jugador;
	}

	public void run(){
		Random random = new Random();
		
		while(true){
			if(random.nextInt(10) == numeroSecreto) {
				try {
					candado.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(jugador.darVida()){
					break;
				}
				candado.release();
			}
		}
	}
}
