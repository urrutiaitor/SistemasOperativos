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
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(almacen.añadirPieza(1)){
				System.out.println("Pieza en posicion 1 añadida!");
			}
		}
	}
	
	public void setMovimiento(){
		movimiento = !movimiento;
	}
	
}
