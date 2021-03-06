package bañosCompartidos;

public class Chico extends Thread {

	int id;
	Baño baño;
	boolean despierto;
	
	public Chico(int id, Baño baño) {
		super();
		this.id = id;
		this.baño = baño;
		despierto = true;
	}
	
	public void run(){
		while(despierto)
			try {
				baño.utilizar("Chico", id);
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
