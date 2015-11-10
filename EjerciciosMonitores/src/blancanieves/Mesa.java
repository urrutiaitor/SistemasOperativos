package blancanieves;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {

	int silla[];
	boolean servidos[];
	boolean terminado = false;

	Lock candadoMesa;
	Condition colaEnanitosFuera;
	Condition colaEnanitosDentro;
	Condition colaBN;

	public Mesa(int numSillas) {
		super();

		silla = new int[numSillas];
		servidos = new boolean[numSillas];

		candadoMesa = new ReentrantLock();
		colaEnanitosFuera = candadoMesa.newCondition();
		colaEnanitosDentro = candadoMesa.newCondition();
		colaBN = candadoMesa.newCondition();

		for (int i = 0; i < silla.length; i++) {
			silla[i] = -1;
		}
	}

	public void pasear() throws InterruptedException {

		candadoMesa.lock();
		colaBN.await();
		candadoMesa.unlock();

	}

	public void servir(int posicion) {
		candadoMesa.lock();

		servidos[posicion] = true;
		System.out.println("\t\tBlancanieves sirve comida en posicion " + posicion + " a enanito " + silla[posicion]);
		colaEnanitosDentro.signalAll();

		candadoMesa.unlock();
	}

	public int encontrarComensal() {

		candadoMesa.lock();

		for (int i = 0; i < silla.length; i++) {
			if ((silla[i] != -1) && (!servidos[i])) {
				candadoMesa.unlock();
				return i;
			}
		}

		candadoMesa.unlock();
		return -1;
	}

	public int encontrarAsiento(int id) {
		System.out.println("Enanito " + id + " viene de trabajar y esta hambriento");

		candadoMesa.lock();
		for (int i = 0; i < silla.length; i++) {
			if (silla[i] == -1) {
				silla[i] = id;
				servidos[i] = false;
				candadoMesa.unlock();
				System.out.println("\tEnanito " + id + " toma asiento en posicion " + i);
				return i;
			}
		}
		candadoMesa.unlock();
		return -1;
	}

	public void esperarFuera() {
		candadoMesa.lock();
		try {
			colaEnanitosFuera.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		candadoMesa.unlock();
	}

	public void comer(int posicion) {
		candadoMesa.lock();

		colaBN.signal();

		while (!servidos[posicion]) {
			try {
				colaEnanitosDentro.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("\t\t\tEnanito " + silla[posicion] + " ha comido en posicion " + posicion + " y se va");
		silla[posicion] = -1;
		colaEnanitosFuera.signal();
		candadoMesa.unlock();

	}

	public boolean terminado() {
		return terminado;
	}

	public void setTerminado() {
		terminado = true;
	}

}
