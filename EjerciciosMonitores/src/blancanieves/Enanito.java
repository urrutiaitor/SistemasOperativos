package blancanieves;

public class Enanito extends Thread {

	Mesa mesa;
	int id;
	
	public Enanito(Mesa mesa, int id) {
		this.mesa = mesa;
		this.id = id;
	}
	
	public void run () {
		int posicion;
		
		while((posicion = mesa.encontrarAsiento(id)) == -1) {
			mesa.esperarFuera();
		}
		mesa.comer(posicion);
	}

}
