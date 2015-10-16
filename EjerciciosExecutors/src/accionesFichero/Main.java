package accionesFichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	ArrayList<String> tareas;
	final String direccion = "datos.txt";

	public static void main(String[] args) {
		Main main = new Main();
		main.tareas = new ArrayList<String>();
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
	}

	private void analizarOrden(String sCurrentLine) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		String partes[] = sCurrentLine.split(" ");
		int num = partes.length - 1;

		switch (partes[0]) {
		case "Multiplicar":
			int multiplicacion = 1;
			for(int i = 0; i < num; i++) multiplicacion = String.valueOf(partes[i + 1]);
			break;
		case "Sumar":

			break;
		case "Maximo":

			break;

		default:
			break;
		}
	}

}
