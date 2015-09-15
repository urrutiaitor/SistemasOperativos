
public class Main {

	public static void main(String[] args) {
		Hilo hilo = new Hilo(new Object());
		hilo.start();
		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
