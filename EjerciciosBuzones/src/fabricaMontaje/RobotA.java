package fabricaMontaje;

public class RobotA extends Thread{

	Almacen almacen;
	boolean movimiento;

	public RobotA(Almacen almacen) {
		super();
		this.almacen = almacen;
	}
	
	public void run(){
		movimiento = true;
		
		while(movimiento){
			try {
				almacen.añadirPieza(0);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
	public void setMovimiento(){
		movimiento = !movimiento;
	}
	
}
