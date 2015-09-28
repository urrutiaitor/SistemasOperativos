package canibales;

public class Cocinero extends Thread{

	Olla olla;
	volatile boolean despierto;

	public Cocinero(Olla olla) {
		super();
		this.olla = olla;
		despierto = true;
	}
	
	public void run(){
		while(despierto){
			try {
				despierto = olla.llenarOlla();
			} catch (InterruptedException e) {
				System.out.println("Cocinero interrumpido");
				break;
			}
		}
	}

	public boolean isDespierto() {
		return despierto;
	}

	public void setDespierto(boolean despierto) {
		this.despierto = despierto;
	}
	
	
}
