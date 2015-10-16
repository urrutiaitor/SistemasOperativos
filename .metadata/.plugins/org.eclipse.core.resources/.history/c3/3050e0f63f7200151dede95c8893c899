package itv;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class BuzonAsincrono <E>{

	ArrayList<E> buzon;
	Semaphore lleno, vacio;
	Semaphore candado;
	
	public BuzonAsincrono(int capacidad) {
		super();
		buzon = new ArrayList<>();
		lleno = new Semaphore(capacidad);
		candado = new Semaphore(1);
		vacio = new Semaphore(0);
	}
	
	public void send (E msg) throws InterruptedException {
		lleno.acquire();
		candado.acquire();
		buzon.add(msg);
		candado.release();
		vacio.release();
	}
	
	public void send() throws InterruptedException {
		lleno.acquire();
		candado.acquire();
		buzon.add(null);
		candado.release();
		vacio.release();
	}
	
	public E recieve() throws InterruptedException {
		vacio.acquire();
		candado.acquire();
		E msg = buzon.remove(0);
		candado.release();
		lleno.release();
		return msg;
	}
}
