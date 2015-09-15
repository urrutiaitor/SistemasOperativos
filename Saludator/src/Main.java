import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class Main implements Observer{

	Saludator saludator;
	volatile boolean end = true;
	
	public static void main(String[] args) {
		
		Main main = new Main();
		Thread thread = new Thread(new Saludator("Hi!!"));
		thread.start();

		while(main.end);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Fin");
		end = false;
	}

}
