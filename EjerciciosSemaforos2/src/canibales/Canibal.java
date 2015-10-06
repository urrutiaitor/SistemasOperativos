package canibales;

public class Canibal extends Thread{

	Olla olla;
	volatile boolean hambriento;
	int id;
	
	public Canibal(Olla olla, int id){
		this.olla = olla;
		hambriento = true;
		this.id = id;
	}
	
	public void run(){
		while(hambriento){
			try {
				hambriento = olla.comer(id);
			} catch (InterruptedException e) {
				System.out.println("Canibal interrumpido");
				break;
			}
		}
	}

	public boolean isHambriento() {
		return hambriento;
	}

	public void setHambriento(boolean hambriento) {
		this.hambriento = hambriento;
	}

}
