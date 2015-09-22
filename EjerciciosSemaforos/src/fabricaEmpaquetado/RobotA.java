package fabricaEmpaquetado;

public class RobotA extends Thread{

	Almacen almacen;

	public RobotA(Almacen almacen) {
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
			almacen.addNumCiclindros();
			System.out.println("Cilindro [" + almacen.getNumCilindros() + "/" + almacen.getNumMaxCiclindro() + "]");
		}
	}
	
}