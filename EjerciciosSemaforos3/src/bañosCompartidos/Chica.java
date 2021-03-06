package bañosCompartidos;

public class Chica extends Thread {

	int id;
	Baño baño;
	boolean despierto;
	
	public Chica(int id, Baño baño) {
		super();
		this.id = id;
		this.baño = baño;
		despierto = true;
	}
	
	public void run(){
		while(despierto)
			try {
				baño.utilizar("Chica", id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public boolean isDespierto() {
		return despierto;
	}

	public void setDespierto(boolean despierto) {
		this.despierto = despierto;
	}
	
	
}
