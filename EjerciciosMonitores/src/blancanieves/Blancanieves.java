package blancanieves;

public class Blancanieves extends Thread {

	Mesa mesa;

	public Blancanieves(Mesa mesa) {
		super();
		this.mesa = mesa;
	}
	
	public void run () {
		int posicion;
		
		while (!mesa.terminado()) {
			while ((posicion = mesa.encontrarComensal()) == -1) {
				try {
					mesa.pasear();
				} catch (InterruptedException e) {
					System.err.println("Se ha interrumpido el paseo de Blancanieves");
					return;
				}
			}
			
			mesa.servir(posicion);
		}
	}
}
