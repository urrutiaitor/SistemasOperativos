package accionesFichero;

public class Multiplicador implements Runnable {
	
	int[] valores;
	
	public Multiplicador(int[] valores) {
		super();
		this.valores = valores;
	}

	@Override
	public void run() {
		int resultado = 1;
		
		for (int i = 0; i < valores.length; i++) {
			resultado = resultado * valores[i];
		}
		
		System.out.println("Resultado multiplicacion: " + resultado);
	}

}
