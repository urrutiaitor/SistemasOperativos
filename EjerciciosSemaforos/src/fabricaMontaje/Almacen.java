package fabricaMontaje;

import java.util.concurrent.Semaphore;

public class Almacen {

	int numPiezas;
	int numMontajes;
	
	boolean piezas[];

	Object robotA;
	Object robotB;
	Object robotC;
	Object robotMontaje;

	public Almacen(int numPiezas) {
		
		this.numPiezas = numPiezas;
		
		piezas = new boolean[numPiezas];

		robotA = new Object();
		robotB = new Object();
		robotC = new Object();
		robotMontaje = new Object();
		
		numMontajes = 0;
	}
	
	public boolean añadirPieza(int posicion){
		switch (posicion) {
		case 0:
			synchronized (robotA) {
				if(!piezas[posicion]){
					piezas[posicion] = true;
					return true;
				}
			}
			break;
		case 1:
			synchronized (robotB) {
				if(!piezas[posicion]){
					piezas[posicion] = true;
					return true;
				}
			}
			break;
		case 2:
			synchronized (robotC) {
				if(!piezas[posicion]){
					piezas[posicion] = true;
					return true;
				}
			}
			break;
		}
		return false;
	}
	
	public boolean montar(){
		synchronized (robotMontaje) {
			for(int i = 0; i < numPiezas; i++){
				if(!piezas[i]) return false;
			}
			for(int i = 0; i < numPiezas; i++){
				piezas[i] = false;
				numMontajes++;
			}	
		}
		return true;
	}

}
