package cronometroSwing;

import java.util.Observable;

public class Cronometro extends Observable implements Runnable{

	int time;
	
	public Cronometro(Interfaz interfaz){
		addObserver(interfaz);
		System.out.println("Observer added");
	}
	
	public void run() {
		long initialTime = System.currentTimeMillis();
		
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long currentTime = System.currentTimeMillis();
			time = (int )(currentTime - initialTime)/1000;
			setChanged();
			notifyObservers();
			System.out.println("Notify");
			System.out.println("> " + time);
		}
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}
