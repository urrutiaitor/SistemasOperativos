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
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(almacen.añadirPieza(0)){
				System.out.println("Pieza en posicion 0 añadida!");
			}
		}
	}
	
	public void setMovimiento(){
		movimiento = !movimiento;
	}
	
}
