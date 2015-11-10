package fabricaMontaje;

public class RobotB extends Thread{

	Almacen almacen;
	boolean movimiento;

	public RobotB(Almacen almacen) {
		super();
		this.almacen = almacen;
	}
	
	public void run(){
		movimiento = true;
		
		while(movimiento){
			try {
				almacen.añadirPieza(1);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
	public void setMovimiento(){
		movimiento = !movimiento;
	}
	
}
