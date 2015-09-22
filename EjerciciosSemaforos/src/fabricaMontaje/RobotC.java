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
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(almacen.añadirPieza(2)){
				System.out.println("Pieza en posicion 2 añadida!");
			}
		}
	}
	
	public void setMovimiento(){
		movimiento = !movimiento;
	}
	
}
