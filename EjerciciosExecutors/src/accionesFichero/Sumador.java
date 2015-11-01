package accionesFichero;

public class Sumador implements Runnable {

	int[] valores;

	public Sumador(int[] valores) {
		super();
		this.valores = valores;
	}

	@Override
	public void run() {
		int resultado = 0;

		for (int i = 0; i < valores.length; i++) {
			resultado = resultado + valores[i];
		}

		System.out.println("Resultado de suma: " + resultado);
	}

}
