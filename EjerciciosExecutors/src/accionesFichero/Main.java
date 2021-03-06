package accionesFichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	final String direccion = "datos.txt";
	OperacionesExecutor executor;
	int numHilos = 10;

	public static void main(String[] args) {
		Main main = new Main();
		main.executor = new OperacionesExecutor(main.numHilos);
		main.leerFichero();
	}

	private void leerFichero() {
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(direccion));

			while ((sCurrentLine = br.readLine()) != null) {
				analizarOrden(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		executor.parar();
	}

	private void analizarOrden(String sCurrentLine) {
		String partes[] = sCurrentLine.split(" ");
		int num = partes.length - 1;
		int numeros[] = new int[num];

		for (int i = 1; i < partes.length; i++) {
			numeros[i - 1] = Integer.valueOf(partes[i]);
		}
		String operacion = partes[0];

		executor.añadirOperacion(operacion, numeros);
	}

}
