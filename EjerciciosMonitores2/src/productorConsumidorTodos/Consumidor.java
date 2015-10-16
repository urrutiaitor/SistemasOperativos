package productorConsumidorTodos;

import java.util.Random;

public class Consumidor extends Thread {

	Buffer buffer;
	int id;
	
	public Consumidor(Buffer buffer, int id) {
		this.buffer = buffer;
		this.id = id;
	}

	public void run() {
		Random random = new Random();
		while (true) {
			if(random.nextInt(100) == 5) System.out.println("Consumidor " + id + ": " + buffer.getNumero());
		}
	}
	
}



