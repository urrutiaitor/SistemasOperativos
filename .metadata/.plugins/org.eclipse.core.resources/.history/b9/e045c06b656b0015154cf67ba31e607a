package barberia;

public class Barbero extends Thread {

	Barberia barberia;

	public Barbero(Barberia barberia) {
		super();
		this.barberia = barberia;
	}
	
	public void run(){
		while(barberia.isAbierta()) barberia.trabajar();
	}
	
}
