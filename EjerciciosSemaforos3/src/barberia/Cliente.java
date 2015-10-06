package barberia;

public class Cliente extends Thread {

	int id;
	Barberia barberia;
	public Cliente(int id, Barberia barberia) {
		super();
		this.id = id;
		this.barberia = barberia;
	}
	
	public void run(){
		while(barberia.isAbierta()){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			barberia.entrar(id);
		}
	}
}