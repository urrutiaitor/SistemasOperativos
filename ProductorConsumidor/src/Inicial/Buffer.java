package Inicial;

import java.util.ArrayList;

public class Buffer {

	public ArrayList<Integer> listaNumeros;
	
	public Buffer () {
		listaNumeros = new ArrayList<Integer>();
	}
	
	public void meterNumero(int numero) {
		System.out.println("Numero metido: " + numero);
		listaNumeros.add(numero);
	}
	
	public int recogerNumero() {
		int numero = 0;
		
		if(listaNumeros.size() > 0){
			numero = listaNumeros.get(0);
			listaNumeros.remove(0);
		}
		
		System.out.println("Numero recogido: " + numero);
		return numero;
	}
	
	public boolean comprobarNumero(){
		return !listaNumeros.isEmpty();
	}
	
}
