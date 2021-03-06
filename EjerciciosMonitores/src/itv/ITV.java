package itv;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ITV {

	int aforoAparcamiento;
	int aforoCochera;
	
	boolean abierto;
	
	Object aparcamiento;
	
	Lock candadoAparcamiento;
	Condition colaApCoche;
	
	Lock candadoCochera;
	Condition colaCocheraCoche;
	Condition colaCocheraOperario;
	
	boolean cochesRevisados[];
	int cochesEnCochera[];
	int cochesEnAparcamiento[];
	
	
	public ITV(int aforoAparcamiento, int aforoCochera) {
		super();
		this.aforoAparcamiento = aforoAparcamiento;
		this.aforoCochera = aforoCochera;
		
		abierto = true;
		
		candadoAparcamiento = new ReentrantLock();
		colaApCoche = candadoAparcamiento.newCondition();
		
		candadoCochera = new ReentrantLock();
		colaCocheraCoche = candadoCochera.newCondition();
		colaCocheraOperario = candadoCochera.newCondition();
		
		cochesRevisados = new boolean[aforoCochera];
		cochesEnCochera = new int[aforoCochera];
		cochesEnAparcamiento = new int[aforoAparcamiento];
		
		for (int i = 0; i < aforoAparcamiento; i++) {
			cochesEnAparcamiento[i] = -1;
		}
		
		for (int i = 0; i < aforoCochera; i++) {
			cochesRevisados[i] = true;
			cochesEnCochera[i] = -1;
		}
	}

	public boolean abierto() {
		return abierto;
	}
	
	public void cerrar() {
		abierto = false;
	}
	
	public int encontrarCoche() {
		
		for (int i = 0; i < aforoCochera; i++) {
			if (cochesRevisados[i] == false) {
				candadoCochera.unlock();
				return i;
			}
		}
		
		return -1;
	}

	public void revisarCoche(int idOperario) {
		int posicion;
		
		candadoCochera.lock();
		
		while ((posicion = encontrarCoche()) == -1) {
			try {
				colaCocheraOperario.await();
			} catch (InterruptedException e) {
				System.err.println("Operario " + idOperario + " interrumpido");
				return;
			}
		}
		
		if (!cochesRevisados[posicion]) System.err.println("Operario " + idOperario + " encuentra coche " + cochesEnCochera[posicion] + " en cochera " + posicion + " revisado");
		System.out.println("\t\tOperario " + idOperario + " revisa coche " + cochesEnCochera[posicion] + " en cochera " + posicion);
		cochesRevisados[posicion] = true;
		candadoCochera.unlock();
		colaCocheraCoche.signalAll();
	}

	public int entrarEnAparcamiento(int id) {
		int posicion;
		
		if((posicion = aparcamientoLibre(id)) == -1){
			//System.out.println("Coche " + id + " no encuentra sitio en aparcamiento y se va");
			return posicion;
		} else {
			System.out.println("Coche " + id + " encuentra sitio en aparcamiento y aparca");
			return posicion;
		}
	}

	private int aparcamientoLibre(int id) {
		candadoAparcamiento.lock();
		
		for (int i = 0; i < aforoAparcamiento; i++) {
			if (cochesEnAparcamiento[i] == -1) {
				cochesEnAparcamiento[i] = id;
				candadoAparcamiento.unlock();
				return i;
			}
		}
		candadoAparcamiento.unlock();
		return -1;
	}

	public int entrarEnCochera(int id, int posicionAparcamiento) {
		int posicion;
		candadoAparcamiento.lock();		
		while((posicion = cocheraLibre(id)) == -1){
			try {
				colaApCoche.await();
			} catch (InterruptedException e) {
				System.err.println("Coche " + id + " interrumpido");
				return -1;
			}
		}
		cochesEnAparcamiento[posicionAparcamiento] = -1;
		candadoAparcamiento.unlock();
		
		System.out.println("\tCoche " + id + " sale del aparcamiento " + posicionAparcamiento + " y se va a la cochera " + posicion);
		
		return posicion;
	}

	private int cocheraLibre(int id) {
		candadoCochera.lock();
		for (int i = 0; i < aforoCochera; i++) {
			if (cochesEnCochera[i] == -1) {
				cochesEnCochera[i] = id;
				candadoCochera.unlock();
				return i;
			}
		}
		candadoCochera.unlock();
		return -1;
	}

	public void salirCochera(int id, int posicion) {
		candadoCochera.lock();
		cochesEnCochera[posicion] = -1;
		candadoCochera.unlock();
		
		candadoAparcamiento.lock();
		colaApCoche.signalAll();
		candadoAparcamiento.unlock();
				
		System.out.println("\t\t\tCoche " + id + " sale de la cochera " + posicion);
	}

}
