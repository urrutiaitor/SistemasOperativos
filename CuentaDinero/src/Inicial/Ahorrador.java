package Inicial;

public class Ahorrador extends Thread {

	float cantidad;
	Cuenta cuenta;

	public Ahorrador(int cantidad, Cuenta cuenta) {
		this.cantidad = cantidad;
		this.cuenta = cuenta;
	}

	public void run() {
		for (int i = 0; i < cantidad; i++) {
			cuenta.changeSaldo(1);
		}
		System.out.println("Ahorrador " + cuenta.toString());
	}
}
