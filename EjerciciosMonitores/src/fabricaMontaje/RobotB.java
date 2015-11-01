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
			almacen.añadirPieza(1);
		}
	}
	
	public void setMovimiento(){
		movimiento = !movimiento;
	}
	
}
