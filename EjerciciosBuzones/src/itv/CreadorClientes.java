package itv;

public class CreadorClientes extends Thread{

	Aparcamiento aparcamiento;
	volatile boolean abierto;

	public CreadorClientes(Aparcamiento aparcamiento) {
		super();
		this.aparcamiento = aparcamiento;
		abierto = true;
	}

	@Override
	public void run() {
		while(abierto){
			try {
				aparcamiento.aparcarCoche();
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}
	
	
	
}
