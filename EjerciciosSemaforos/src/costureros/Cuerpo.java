package costureros;

public class Cuerpo extends Thread {

	Cesta cesta;
	
	public Cuerpo(Cesta cesta) {
		super();
		this.cesta = cesta;
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				cesta.getSemaforoCuerpos().acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cesta.addNumCuerpos(1);
			System.out.println("Cuerpo cosido [" + cesta.getNumCuerpos() + "/" + cesta.getNumMaxCuerpos() + "]");
		}
	}
	
}
