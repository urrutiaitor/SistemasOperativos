package fabricaEmpaquetado;

import java.util.concurrent.Semaphore;

public class Almacen {

	int numMaxCiclindro;
	int numMaxCubo;

	int numCilindros;
	int numCubos;
	int numPaquetes;

	Semaphore semaforoRobotA;
	Semaphore semaforoRobotB;

	Object robotA;
	Object robotB;
	Object robotC;

	public Almacen(int numMaxCiclindro, int numMaxCubo, Semaphore semaforoRobotA,
			Semaphore semaforoRobotB) {
		super();
		this.numMaxCiclindro = numMaxCiclindro;
		this.numMaxCubo = numMaxCubo;
		this.semaforoRobotA = semaforoRobotA;
		this.semaforoRobotB = semaforoRobotB;
		
		numCilindros = 0;
		numCubos = 0;
		numPaquetes = 0;

		robotA = new Object();
		robotB = new Object();
		robotC = new Object();
	}

	public int getNumMaxCiclindro() {
		return numMaxCiclindro;
	}

	public void setNumMaxCiclindro(int numMaxCiclindro) {
		this.numMaxCiclindro = numMaxCiclindro;
	}

	public int getNumMaxCubo() {
		return numMaxCubo;
	}

	public void setNumMaxCubo(int numMaxCubo) {
		this.numMaxCubo = numMaxCubo;
	}

	public int getNumCilindros() {
		return numCilindros;
	}

	public void setNumCilindros(int numCilindros) {
		this.numCilindros = numCilindros;
	}

	public int getNumCubos() {
		return numCubos;
	}

	public void setNumCubos(int numCubos) {
		this.numCubos = numCubos;
	}

	public Semaphore getSemaforoRobotA() {
		return semaforoRobotA;
	}

	public void setSemaforoRobotA(Semaphore semaforoRobotA) {
		this.semaforoRobotA = semaforoRobotA;
	}

	public Semaphore getSemaforoRobotB() {
		return semaforoRobotB;
	}

	public void setSemaforoRobotB(Semaphore semaforoRobotB) {
		this.semaforoRobotB = semaforoRobotB;
	}

	public void addNumCiclindros() {
		synchronized (robotA) {
			if(numCilindros < numMaxCiclindro) numCilindros++;
		}
	}
	
	public void addNumCubos() {
		synchronized (robotB) {
			if(numCubos < numMaxCubo) numCubos++;
		}
	}
	
	public int getNumPaquetes() {
		return numPaquetes;
	}
	
	public void montarPaquete() {
		synchronized (robotC) {
			if((numCilindros == numMaxCiclindro)&&(numCubos == numMaxCubo)){
				numCilindros = 0;
				numCubos = 0;
				numPaquetes++;
			}
		}
	}

}
