package Inicial;

public class Consumidor extends Thread {

	Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		
		while (true) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(buffer.comprobarNumero()) {
				System.out.println("> " + buffer.recogerNumero());
			} else {
				break;
			}
		}
	}
	
}
