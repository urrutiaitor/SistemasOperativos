package tenderoCliente;

public class Cliente extends Thread {
	
	Tienda tienda;
	boolean despierto;
	int id;

	public Cliente(Tienda tienda, int id) {
		super();
		this.tienda = tienda;
		this.id = id;
	}
	
	public void run() {
		while(despierto) {
			if(tienda.entrar()) {
				tienda.pedir();
				tienda.pagar();
			}
		}
	}
}
