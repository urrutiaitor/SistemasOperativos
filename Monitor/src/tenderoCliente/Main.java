package tenderoCliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	final static int capacidadTienda = 100;
	final static int numTenderos = 10;
	final static int numClientes = 1000;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();
		
		Tienda tienda = new Tienda(capacidadTienda);
		
		ArrayList<Tendero> tenderos = new ArrayList<Tendero>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		main.crearTenderos(tienda, tenderos);
		main.crearClientes(tienda, clientes);
		
		main.iniciarTenderos(tenderos);
		main.iniciarClientes(clientes);
		
		scanner.nextLine();
		
		main.pararClientes(clientes);
		main.pararTenderos(tenderos);
		
	}

	private void crearTenderos(Tienda tienda, ArrayList<Tendero> tenderos) {
		for(int i = 0; i < numTenderos; i++){
			tenderos.add(new Tendero(tienda));
		}
	}

	private void crearClientes(Tienda tienda, ArrayList<Cliente> clientes) {
		for(int i = 0; i < numClientes; i++){
			clientes.add(new Cliente(tienda));
		}
	}

	private void iniciarTenderos(ArrayList<Tendero> tenderos) {
		for(int i = 0; i < numTenderos; i++){
			tenderos.get(i).start();
		}
	}

	private void iniciarClientes(ArrayList<Cliente> clientes) {
		for(int i = 0; i < numClientes; i++){
			clientes.get(i).start();
		}
	}

	private void pararClientes(ArrayList<Cliente> clientes) {
		for(int i = 0; i < numClientes; i++){
			clientes.get(i).setDespierto(false);
			clientes.get(i).interrupt();
		}
	}

	private void pararTenderos(ArrayList<Tendero> tenderos) {
		for(int i = 0; i < numTenderos; i++){
			tenderos.get(i).setDespierto(false);
			tenderos.get(i).interrupt();
		}
	}

}
