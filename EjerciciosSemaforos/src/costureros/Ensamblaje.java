package costureros;

import java.util.concurrent.Semaphore;

public class Ensamblaje extends Thread {

	Cesta cesta;
	
	public Ensamblaje(Cesta cesta) {
		super();
		this.cesta = cesta;
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(30);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Ensamblador-> Cuerpos: " + cesta.getNumCuerpos() + " Mangas: " + cesta.getNumMangas());
			if((cesta.getNumCuerpos() > 0)&&(cesta.getNumMangas() > 0)){
				cesta.delNumCuerpos(1);
				cesta.delNumMangas(1);
				System.out.println("Jersey ensamblado");
				cesta.getSemaforoCuerpos().release();
				cesta.getSemaforoMangas().release();
			}
		}
	}
	
}
