package productorConsumidor;

import java.util.Random;

public class Productor extends Thread{

	Buffer buffer;
	int valor;
	Random aleatorio;
	
	public Productor(Buffer buffer){
		this.buffer=buffer;
		aleatorio=new Random();
	}
	
	public void run(){
		for(int i=0;i<20;i++){
			valor=aleatorio.nextInt(100);
			try {
				buffer.meter(valor);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
