package accionesFichero;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OperacionesExecutor {

	int numHilos;
	ExecutorService executor;
	
	public OperacionesExecutor(int numHilos) {
		super();
		this.numHilos = numHilos;
		executor = Executors.newFixedThreadPool(numHilos);
	}
	
	public void añadirOperacion (String operacion, int []numeros) {
		Runnable r = null;
		
		switch (operacion.toUpperCase()) {
		case "MULTIPLICAR":
			r = new Multiplicador(numeros);
			break;
		case "SUMAR":
			r = new Sumador(numeros);
			break;
		case "MAXIMO":
			r = new BuscadorMax(numeros);
			break;

		default:
			break;
		}
		executor.execute(r);
	}
	
	public void parar() {
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
