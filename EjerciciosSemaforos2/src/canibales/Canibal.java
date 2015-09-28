package canibales;

public class Canibal extends Thread{

	Olla olla;
	volatile boolean hambriento;
	
	public Canibal(Olla olla){
		this.olla = olla;
		hambriento = true;
	}
	
	public void run(){
		while(hambriento){
			try {
				hambriento = olla.comer();
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
