package transbordador;

public class Coche extends Thread{

	Transbordador transbordador;
	int id;
	
	
	public Coche(Transbordador transbordador, int id) {
		super();
		this.transbordador = transbordador;
		this.id = id;
	}
	
	public void run(){
		while(transbordador.isAbierto())
			try {
				transbordador.meterCoche(id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
