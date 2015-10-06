package transbordador;

public class Capitan extends Thread {

	Transbordador transbordador;

	public Capitan(Transbordador transbordador) {
		super();
		this.transbordador = transbordador;
	}
	
	public void run(){
		while(transbordador.isAbierto())
			try {
				transbordador.cruzar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
