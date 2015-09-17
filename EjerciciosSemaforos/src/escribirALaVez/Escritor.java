package escribirALaVez;

import java.util.concurrent.Semaphore;



public class Escritor extends Thread{

	Semaphore semaforoMio;
	Semaphore semaforoOtro;
	String mensaje;
	
	public Escritor(Semaphore semaforoMio, Semaphore semaforoOtro, String mensaje) {
		this.semaforoMio = semaforoMio;
		this.semaforoOtro = semaforoOtro;
		this.mensaje = mensaje;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true){
			try {
				semaforoMio.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accion();
			semaforoOtro.release();
		}
		
	}

	private void accion() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(mensaje);
	}
}
