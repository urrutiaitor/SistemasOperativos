package fabricaMontaje;

public class RobotC extends Thread{

	Almacen almacen;
	boolean movimiento;

	public RobotC(Almacen almacen) {
		super();
		this.almacen = almacen;
	}
	
	public void run(){
		movimiento = true;
		
		while(movimiento){
			almacen.añadirPieza(2);
		}
	}
	
	public void setMovimiento(){
		movimiento = !movimiento;
	}
	
}
