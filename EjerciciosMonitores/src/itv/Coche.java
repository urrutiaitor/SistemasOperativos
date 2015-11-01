package itv;

public class Coche extends Thread {

	int id;
	ITV itv;
	
	
	public Coche(int id, ITV itv) {
		super();
		this.id = id;
		this.itv = itv;
	}
	
	public void run(){
		int posicionAparcamiento;
		int posicionCochera;
		
		if(itv.abierto()) {
			if ((posicionAparcamiento = itv.entrarEnAparcamiento(id)) != -1) {
				posicionCochera = itv.entrarEnCochera(id, posicionAparcamiento);
				itv.salirCochera(id, posicionCochera);
			}
		}
	}

}
