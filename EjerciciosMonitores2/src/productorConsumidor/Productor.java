package productorConsumidor;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Productor extends Thread {

	Buffer buffer;
	
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		Random random = new Random();
		
		while(true){
			
			buffer.setNumero(random.nextInt(10));
			
		}
	}

}
