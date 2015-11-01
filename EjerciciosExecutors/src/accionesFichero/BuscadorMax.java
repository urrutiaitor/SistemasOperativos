package accionesFichero;

public class BuscadorMax implements Runnable {

	int[] valores;

	public BuscadorMax(int[] valores) {
		super();
		this.valores = valores;
	}

	@Override
	public void run() {
		int resultado = valores[0];
		for (int i = 1; i < valores.length; i++) {
			if (valores[i] > resultado)
				resultado = valores[i];
		}

		System.out.println("Resultado del valor maximo: " + resultado);
	}

}
