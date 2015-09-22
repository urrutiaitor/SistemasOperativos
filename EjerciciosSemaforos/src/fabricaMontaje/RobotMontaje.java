package fabricaMontaje;

public class RobotMontaje extends Thread{

	Almacen almacen;
	boolean movimiento;

	public RobotMontaje(Almacen almacen) {
		super();
		this.almacen = almacen;
		movimiento = true;
	}
	
	public void run(){
		while(movimiento){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(almacen.montar()){
				System.out.println("----------Montaje hecho----------");
			}
		}
	}
	
}
