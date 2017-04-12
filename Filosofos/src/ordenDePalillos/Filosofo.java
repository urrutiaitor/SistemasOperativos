package ordenDePalillos;

public class Filosofo extends Thread {
	
	int posicionPalilloIzq;
	int posicionPalilloDer;
	int posicion;
	
	Mesa mesa;

	boolean vivo;
	
	public Filosofo(int posicion, Mesa mesa) {
		super();
		this.posicion = posicion;
		this.mesa = mesa;
		posicionPalilloIzq = posicion;
		if (posicion == 0) {
			posicionPalilloDer = mesa.getNumFilosofos() - 1;
		} else {
			posicionPalilloDer = posicion - 1;
		}
		
		vivo = true;
	}
	
	public void run() {
		while (vivo) {
			comer();
			pensar();
		}
	}

	private void pensar() {
		System.out.println("Filosofo " + posicion + " pensando");
	}

	private void comer() {
		if (posicion % 2 == 1) {
			mesa.cogerPalillo(posicionPalilloIzq);
			mesa.cogerPalillo(posicionPalilloDer);
			mesa.comer(posicion);
			mesa.dejarPalillo(posicionPalilloDer);
			mesa.dejarPalillo(posicionPalilloIzq);
		} else {
			mesa.cogerPalillo(posicionPalilloDer);
			mesa.cogerPalillo(posicionPalilloIzq);
			mesa.comer(posicion);
			mesa.dejarPalillo(posicionPalilloIzq);
			mesa.dejarPalillo(posicionPalilloDer);
		}
		
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	

}
