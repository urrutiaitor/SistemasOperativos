package multiplicacionMatriz;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Multiplicador extends Thread{

	Matriz matrizA;
	Matriz matrizB;
	Matriz matrizC;
	int filaInicio;
	int filaFinal;
	
	public Multiplicador(Matriz matrizA, Matriz matrizB, Matriz matrizC, int filaInicio, int filaFinal) throws HeadlessException {
		super();
		this.matrizA = matrizA;
		this.matrizB = matrizB;
		this.matrizC = matrizC;
		this.filaInicio = filaInicio;
		this.filaFinal = filaFinal;
	}
	
	public void run() {
		for(int i = filaInicio; i < filaFinal; i++){
			resolverFila(i);
		}
	}
	
	private void resolverFila(int fila){
		for(int i = 0; i < matrizA.getColumnas(); i++){
			resolverNumero(fila, i);
		}
	}
	
	private void resolverNumero(int fila, int columna){
		int suma = 0;
		int producto = 0;
		
		for(int i = 0; i < matrizA.getColumnas(); i++){
			producto = matrizA.leerNumero(i, fila)*matrizB.leerNumero(columna, i);
			suma = suma + producto;
		}
		matrizC.meterNumero(fila, columna, suma);
	}
	
}
