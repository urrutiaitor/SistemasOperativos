package productorConsumidor;

import java.util.Random;

public class Consumidor extends Thread{

	Buffer buffer;
	int valor;
	
	public Consumidor(Buffer buffer){
		this.buffer=buffer;
		valor=0;
	}
	
	public void run(){
		for(int i=0;i<20;i++){
			
			try {
				valor=buffer.sacar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
