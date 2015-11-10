package itv;

public class Coche extends Thread {

	int id;
	BuzonAsincrono aparcamiento;
	BuzonAsincrono cochera;
	BuzonAsincrono revisado;
	
	public Coche(int id, BuzonAsincrono aparcamiento, BuzonAsincrono cochera, BuzonAsincrono revisado) {
		super();
		this.id = id;
		this.aparcamiento = aparcamiento;
		this.cochera = cochera;
		this.revisado = revisado;
	}

	public void run(){
		int posicionAparcamiento;
		int idAux;
		
		try {
			posicionAparcamiento = (int) aparcamiento.receive();
			cochera.send(id);
			aparcamiento.send(posicionAparcamiento);
			
			while (id != (idAux = (int) revisado.receive())) {
				revisado.send(idAux);
			}
		} catch (InterruptedException e) {
			System.err.println("Coche " + id + " interrumpido");
			return;
		}
		
		
		System.out.println("Coche " + id + " ha sido revisado y se va");
	}

}
