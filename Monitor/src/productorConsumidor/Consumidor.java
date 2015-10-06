package productorConsumidor;

import java.util.Random;

public class Consumidor extends Thread {

	Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		Random random = new Random();
		while (true) {
			if(random.nextInt(100) == 5) System.out.println(buffer.getNumero());
			System.out.print(buffer.getNumero());
			
		}
	}
	
}



