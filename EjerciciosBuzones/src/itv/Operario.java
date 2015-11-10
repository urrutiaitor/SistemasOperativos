package itv;

public class Operario extends Thread {

	int id;
	boolean trabajando = true;
	BuzonAsincrono aparcamiento;
	BuzonAsincrono cochera;
	BuzonAsincrono revisado;
	
	public Operario(int id, BuzonAsincrono aparcamiento, BuzonAsincrono cochera, BuzonAsincrono revisado) {
		super();
		this.id = id;
		this.aparcamiento = aparcamiento;
		this.cochera = cochera;
		this.revisado = revisado;
	}
	
	public void run() {
		
		while (trabajando) {
			try {
				revisado.send(cochera.receive());
			} catch (InterruptedException e) {
				System.err.println("Operario " + id + " interrumpido");
				return;
			}
		}
	}

	
	public void setTrabajando(){
		trabajando = !trabajando;
	}
}
