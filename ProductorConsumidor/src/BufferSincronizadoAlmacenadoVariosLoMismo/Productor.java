package BufferSincronizadoAlmacenadoVariosLoMismo;

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
			/*
			try {
				Thread.sleep(00);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			buffer.setNumero(random.nextInt(10));
			
		}
	}

}
