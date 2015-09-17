package BufferSincronizadoAlmacenadoVariosInterfaz;

import java.util.ArrayList;
import java.util.Random;

public class Consumidor extends Thread {

	ArrayList<Buffer> bufferes;
	
	public Consumidor(ArrayList<Buffer> bufferes) {
		this.bufferes = bufferes;
	}

	public void run() {
		Random random = new Random();
		
		while (true) {
			
			System.out.println("> " + bufferes.get(bufferes.size() - 1).getNumero());
			
		}
	}
	
}



