package fabricaEmpaquetado;

public class RobotB extends Thread{

	Almacen almacen;

	public RobotB(Almacen almacen) {
		super();
		this.almacen = almacen;
	}
	
	public void run(){
		boolean seguir = true;
		
		while(seguir){
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			almacen.addNumCubos();
			System.out.println("Cubo [" + almacen.getNumCubos() + "/" + almacen.getNumMaxCubo() + "]");
		}
	}
	
}
