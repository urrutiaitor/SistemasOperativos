package BufferSincronizadoAlmacenadoVariosLoMismo;

public class Consumidor extends Thread {

	Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		
		while (true) {
			
			
			try {
				System.out.println("> " + buffer.getNumero());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}



