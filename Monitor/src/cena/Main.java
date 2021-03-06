package cena;

import java.util.ArrayList;

public class Main {

	Cena cena;
	ArrayList<Persona> personas;
	final static int numPersonas = 1;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.cena = new Cena();
		main.personas = new ArrayList<Persona>();
		main.crearPersonas();
		main.iniciarPersonas();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		main.cena.notifyAll();
	}
	
	private void crearPersonas(){
		for(int i = 0; i < numPersonas; i++){
			personas.add(new Persona(cena, i));
		}
	}
	
	private void iniciarPersonas(){
		for(int i = 0; i < numPersonas; i++){
			personas.get(i).start();
		}
	}

	
}
