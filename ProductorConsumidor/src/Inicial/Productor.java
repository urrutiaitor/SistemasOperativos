package Inicial;

import java.util.Random;

public class Productor extends Thread {

	Buffer buffer;
	
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		Random random = new Random();
		
		while(true){
				
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			buffer.meterNumero(random.nextInt(10));
			
		}
	}

}
