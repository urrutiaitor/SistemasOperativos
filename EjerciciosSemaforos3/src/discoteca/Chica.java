package discoteca;

public class Chica extends Thread {

	Discoteca discoteca;
	int id;
	
	
	public Chica(Discoteca discoteca, int id) {
		super();
		this.discoteca = discoteca;
		this.id = id;
	}


	public void run() {
		while(discoteca.isAbierta()){
			discoteca.entrarChica(id);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
