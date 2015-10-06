package barberia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final int aforo = 3;
	final static int numClientes = 20;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Barberia barberia = new Barberia(aforo);
		
		Barbero barbero = new Barbero(barberia);
		main.crearClientes(clientes, barberia);
		
		barbero.start();
		main.iniciarClientes(clientes);
		
		scanner.nextLine();
		
		barberia.cerrar();
		barbero.interrupt();
		main.pararClientes(clientes);
	}

	private void crearClientes(ArrayList<Cliente> clientes, Barberia barberia) {
		for(int i = 0; i < numClientes; i++){
			clientes.add(new Cliente(i, barberia));
		}
	}

	private void iniciarClientes(ArrayList<Cliente> clientes) {
		for(int i = 0; i < numClientes; i++){
			clientes.get(i).start();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void pararClientes(ArrayList<Cliente> clientes) {
		for(int i = 0; i < numClientes; i++){
			clientes.get(i).interrupt();
		}
	}

}
