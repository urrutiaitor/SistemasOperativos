package discoteca;

public class Chico extends Thread {

	Discoteca discoteca;
	int id;
	
	
	public Chico(Discoteca discoteca, int id) {
		super();
		this.discoteca = discoteca;
		this.id = id;
	}


	public void run() {
		while(discoteca.isAbierta()){
			discoteca.entrarChico(id);
		}
	}
	
}