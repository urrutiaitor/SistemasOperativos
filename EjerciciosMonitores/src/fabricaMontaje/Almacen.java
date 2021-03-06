package fabricaMontaje;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Almacen {

	int numPiezas;

	int piezas[];

	Lock candado;
	Condition cRobot;
	Condition cRobotMontaje;

	public Almacen(int numPiezas) {

		this.numPiezas = numPiezas;

		piezas = new int[numPiezas];

		candado = new ReentrantLock();

		cRobot = candado.newCondition();
		cRobotMontaje = candado.newCondition();

		for (int i = 0; i < piezas.length; i++) {
			piezas[i] = -1;
		}

	}

	public void añadirPieza(int id) throws InterruptedException {
		int posicion;

		candado.lock();
		while ((posicion = encontrarPosicion(id)) == -1) {

			cRobot.await();

		}
		cRobotMontaje.signal();
		candado.unlock();

		System.out.println("Robot " + id + " a puesto pieza en posicion " + posicion);
	}

	private int encontrarPosicion(int id) {
		for (int i = 0; i < piezas.length; i++) {
			if (piezas[i] == -1) {
				piezas[i] = id;
				return i;
			}
		}
		return -1;
	}

	public void montar() throws InterruptedException {
		int posicion;
		candado.lock();
		while ((posicion = encontrarPosicion()) == -1) {
			System.out.println("1");

			cRobotMontaje.await();

			System.out.println("u");
		}
		int pieza = piezas[posicion];
		piezas[posicion] = -1;
		cRobot.signal();
		candado.unlock();

		System.out.println("Robot de montaje a recogido pieza " + pieza + " en posicion " + posicion);
	}

	private int encontrarPosicion() {
		for (int i = 0; i < piezas.length; i++) {
			if (piezas[i] != -1) {
				return i;
			}
		}
		return -1;
	}

}
