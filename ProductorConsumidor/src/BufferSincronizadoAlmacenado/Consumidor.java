package BufferSincronizadoAlmacenado;

public class Consumidor extends Thread {

	Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		
		while (true) {
			
			System.out.println("> " + buffer.getNumero());
			
		}
	}
	
}



