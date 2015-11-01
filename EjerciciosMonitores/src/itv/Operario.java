package itv;

public class Operario extends Thread {

	int id;
	ITV itv;
	
	
	public Operario(int id, ITV itv) {
		super();
		this.id = id;
		this.itv = itv;
	}
	
	public void run() {
		int posicion;
		int idCoche;
		while(itv.abierto()) {
			itv.revisarCoche(id);
		}
	}

}
