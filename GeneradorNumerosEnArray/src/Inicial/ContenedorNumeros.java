package Inicial;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class ContenedorNumeros extends Thread{
	
	int cantNumeros;
	int id;
	Random random;
	static Vector<Integer> valores;
	
	
	public ContenedorNumeros(int cantNumeros, int id){
		this.cantNumeros = cantNumeros;
		this.id = id;
	}
	
	public void run() {
		valores = new Vector<Integer>();
		crearNumeros(0, 100, cantNumeros);
	}
	
	public void crearNumeros(int minimo, int maximo, int numValores) {
		Random random = new Random();
		
		for (int i = 0; i < numValores; i++) {
			valores.add(minimo + random.nextInt(maximo - minimo));
		}
	}

	@Override
	public String toString() {
		return "ContenedorNumeros [id=" + id + "]\n\t" + valores.toString();
	}
	
	

}
