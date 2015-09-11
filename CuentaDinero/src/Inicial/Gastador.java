package Inicial;

public class Gastador extends Thread {
	float cantidad;
	Cuenta cuenta;

	public Gastador(int cantidad, Cuenta cuenta) {
		this.cantidad = cantidad;
		this.cuenta = cuenta;
	}

	public void run() {
		for (int i = 0; i < cantidad; i++) {
			cuenta.changeSaldo(-1);
		}
		System.out.println("Gastador: " + cuenta.toString());
	}
}
