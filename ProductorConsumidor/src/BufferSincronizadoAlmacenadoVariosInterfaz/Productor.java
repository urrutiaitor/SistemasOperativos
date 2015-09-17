package BufferSincronizadoAlmacenadoVariosInterfaz;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Productor extends Thread {

	ArrayList<Buffer> bufferes;
	
	public Productor(ArrayList<Buffer> bufferes) {
		this.bufferes = bufferes;
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
			
			bufferes.get(random.nextInt(bufferes.size() - 1)).setNumero(random.nextInt(10));
			
		}
	}

}
