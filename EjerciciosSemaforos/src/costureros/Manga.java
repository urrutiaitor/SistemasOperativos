package costureros;

public class Manga extends Thread {

	Cesta cesta;

	public Manga(Cesta cesta) {
		super();
		this.cesta = cesta;
	}

	
	public void run() {
		while(true){
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				cesta.getSemaforoMangas().acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cesta.addNumMangas(1);
			System.out.println("Manga cosida [" + cesta.getNumMangas() + "/" + cesta.getNumMaxMangas() + "]");
		}
	}
}
