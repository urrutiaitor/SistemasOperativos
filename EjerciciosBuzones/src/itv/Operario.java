package itv;

public class Operario extends Thread {

	volatile boolean trabajando;
	Aparcamiento aparcamiento;
	
	public Operario(Aparcamiento aparcamiento) {
		super();
		this.aparcamiento = aparcamiento;
		trabajando = true;
	}



	public void run(){
		while (trabajando){
			try {
				aparcamiento.inspeccionarCoche();
			} catch (InterruptedException e) {
				break;
			}
		}
	}



	public boolean isTrabajando() {
		return trabajando;
	}



	public void setTrabajando(boolean trabajando) {
		this.trabajando = trabajando;
	}
	
	
}
