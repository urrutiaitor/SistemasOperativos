package fabricaEmpaquetado;

public class RobotC extends Thread{

	Almacen almacen;

	public RobotC(Almacen almacen) {
		super();
		this.almacen = almacen;
	}
	
	public void run(){
		boolean seguir = true;
		
		while(seguir){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			almacen.montarPaquete();
			System.out.println("Paquetes [" + almacen.getNumPaquetes());
		}
	}
	
}
