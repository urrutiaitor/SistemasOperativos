import java.util.Observable;


public class Saludator extends Observable implements Runnable{

	String text = null;
	
	public Saludator (String text) {
		this.text = text;
	}
	
	public void run () {
		for(int i = 0; i < 10; i++){
			System.out.println(i + ".- " + text);
		}
		this.notifyObservers();
	}
	
	
}
