package fabricaMontaje;

public class RobotMontaje extends Thread {

	Almacen almacen;
	boolean movimiento;

	public RobotMontaje(Almacen almacen) {
		super();
		this.almacen = almacen;
		movimiento = true;
	}

	public void run() {
		while (movimiento) {

			almacen.montar();

		}
	}

	public boolean isMovimiento() {
		return movimiento;
	}

	public void setMovimiento() {
		movimiento = !movimiento;
	}

}
