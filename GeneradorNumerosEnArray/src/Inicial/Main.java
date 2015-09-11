package Inicial;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		
		ArrayList<ContenedorNumeros> contenedores = new ArrayList<ContenedorNumeros>();

		main.crearContenedores(contenedores);
		main.iniciarContenedores(contenedores);
		main.esperarContenedores(contenedores);
		main.visualizarContenedores(contenedores);
	}

	public void crearContenedores(ArrayList<ContenedorNumeros> contenedores) {
		ContenedorNumeros contenedor;

		for (int i = 0; i < 10; i++) {
			contenedor = new ContenedorNumeros(100, i);
			contenedores.add(contenedor);

		}
	}

	public void iniciarContenedores(ArrayList<ContenedorNumeros> contenedores) {
		ListIterator<ContenedorNumeros> contenedoresIt = contenedores.listIterator();

		while (contenedoresIt.hasNext())
			contenedoresIt.next().start();
	}

	public void esperarContenedores(ArrayList<ContenedorNumeros> contenedores) {
		ListIterator<ContenedorNumeros> contenedoresIt = contenedores.listIterator();

		while (contenedoresIt.hasNext()) {
			try {
				contenedoresIt.next().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void visualizarContenedores(ArrayList<ContenedorNumeros> contenedores) {
		ListIterator<ContenedorNumeros> contenedoresIt = contenedores.listIterator();

		while (contenedoresIt.hasNext()) {
			System.out.println(contenedoresIt.next().toString());
		}
	}
}
