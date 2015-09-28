package gestinTraficoPuente;

import java.util.concurrent.Semaphore;

public class Puente {

	Semaphore semaforoPuenteNorte;
	Semaphore semaforoPuenteSur;
	Semaphore semaforoTotalPuenteNorte;
	Semaphore semaforoTotalPuenteSur;
	
	Semaphore candadoPuente;
	
	final int cocheMaxPasar = 10;
	final int cochesMaxPasando = 5;
	
	public Puente(){
		semaforoPuenteNorte = new Semaphore(0);
		semaforoPuenteSur = new Semaphore(0);
		semaforoTotalPuenteNorte = new Semaphore(0, true);
		semaforoTotalPuenteSur = new Semaphore(0, true);
		
		candadoPuente = new Semaphore(1, true);
	}

	public void cruzar(String direccion) throws InterruptedException {
		if (direccion.toLowerCase().equals("norte"))
			cruzarNorte();
		if (direccion.toLowerCase().equals("sur"))
			cruzarSur();

	}

	private void cruzarNorte() throws InterruptedException {
		semaforoPuenteNorte.acquire();
		semaforoTotalPuenteNorte.acquire();
		System.out.println("Coche cruzando NORTE");
		semaforoPuenteNorte.release();
		candadoPuente.acquire();
		if((semaforoTotalPuenteNorte.getQueueLength() == 0) || (semaforoTotalPuenteNorte.availablePermits() == 0)){
			System.out.println("-----------CAMBIO-----------");
			semaforoTotalPuenteNorte.drainPermits();
		}
		if(semaforoPuenteNorte.availablePermits() == )
		
		candadoPuente.release();
	}

	private void cruzarSur() {
		// TODO Auto-generated method stub

	}

}
