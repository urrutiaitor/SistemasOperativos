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
				mesa.pasear();
			}
			
			mesa.servir(posicion);
		}
	}
}
