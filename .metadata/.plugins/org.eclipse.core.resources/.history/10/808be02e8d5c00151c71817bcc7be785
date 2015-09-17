package encuentraNumerosPrimos;

public class Main {

	final static int hilos = 100000;
	final static int numerosPorHilo = 1000;
	
	public static void main(String[] args) {
		
		
		for(int i = 0; i < hilos; i++){
			Hilo hilo = new Hilo(i*numerosPorHilo, (i+1)*numerosPorHilo);
			hilo.start();
		}

	}

}
