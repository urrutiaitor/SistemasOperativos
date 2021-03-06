package Inicial;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();

		Cuenta cuenta = new Cuenta(10000);

		ArrayList<Ahorrador> ahorradores = new ArrayList<Ahorrador>();
		ArrayList<Gastador> gastadores = new ArrayList<Gastador>();

		main.crearClientes(ahorradores, gastadores, cuenta);
		main.iniciarClientes(ahorradores, gastadores);
		main.esperarClientes(ahorradores, gastadores);

		System.out.println(cuenta.toString());
	}

	public void crearClientes(ArrayList<Ahorrador> ahorradores, ArrayList<Gastador> gastadores, Cuenta cuenta) {
		Ahorrador ahorrador;
		Gastador gastador;

		for (int i = 0; i < 100; i++) {
			ahorrador = new Ahorrador(1000, cuenta);
			ahorradores.add(ahorrador);
			gastador = new Gastador(1000, cuenta);
			gastadores.add(gastador);

		}
	}

	public void iniciarClientes(ArrayList<Ahorrador> ahorradores, ArrayList<Gastador> gastadores) {
		ListIterator<Ahorrador> ahorradoresIt = ahorradores.listIterator();
		ListIterator<Gastador> gastadoresIt = gastadores.listIterator();

		while (ahorradoresIt.hasNext())
			ahorradoresIt.next().start();

		while (gastadoresIt.hasNext())
			gastadoresIt.next().start();
	}

	public void esperarClientes(ArrayList<Ahorrador> ahorradores, ArrayList<Gastador> gastadores) {
		ListIterator<Ahorrador> ahorradoresIt = ahorradores.listIterator();
		ListIterator<Gastador> gastadoresIt = gastadores.listIterator();

		while (ahorradoresIt.hasNext()) {
			try {
				ahorradoresIt.next().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		while (gastadoresIt.hasNext()) {
			try {
				gastadoresIt.next().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
