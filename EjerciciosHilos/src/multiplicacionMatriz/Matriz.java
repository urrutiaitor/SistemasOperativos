package multiplicacionMatriz;

import java.util.ArrayList;
import java.util.Random;

public class Matriz {

	ArrayList<ArrayList<Integer>> matriz;
	int columnas, filas;
	
	public Matriz(int filas, int columnas) {
		this.columnas = columnas;
		this.filas = filas;
		Random random = new Random();
		
		matriz = new ArrayList<ArrayList<Integer>>();
		for(int y = 0; y < filas; y++){
			ArrayList<Integer> columna = new ArrayList<>();
			for(int x = 0; x < columnas; x++){
				columna.add(random.nextInt(100));
			}
			matriz.add(columna);
		}
	}
	
	public int leerNumero(int columna, int fila){
		return matriz.get(columna).get(fila);
	}
	
	public synchronized void meterNumero(int fila, int columna, int numero){
		matriz.get(columna).set(fila, numero);
	}
	
	public String toString() {
		String total = new String();
		String fila = new String();
		for(int y = 0; y < filas; y++){
			fila = "| ";
			for( int x = 0; x < columnas; x++){
				int numero = leerNumero(x, y);
				if(numero >= 10){
					fila = fila.concat(" " + numero + " |");
				}else {
					fila = fila.concat(" 0" + numero + " |");
				}
			}
			total = total.concat(fila + "\n");
		}
		return total;
		
	}

	public int getColumnas() {
		return columnas;
	}
}
