package tenderoCliente;

public class Tendero extends Thread {

	Tienda tienda;
	boolean despierto;
	int id;

	public Tendero(Tienda tienda, int id) {
		super();
		this.tienda = tienda;
		this.id = id;
	}
	
	
	public void run() {
		while (despierto){
			tienda.atender();
		}
	}
	
}
