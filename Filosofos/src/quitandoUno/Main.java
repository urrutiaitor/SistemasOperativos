package quitandoUno;

import java.util.Scanner;

public class Main {
	
	int numFilosofos;
	long initTime;
	long finalTime;
	Filosofo filosofos[];
	Mesa mesa;

	public static void main(String[] args) throws InterruptedException {
		Scanner keyboard = new Scanner(System.in);
		long initTime = System.currentTimeMillis();
		System.out.println("Numero de filosofos: ");
		int numFilosofos = keyboard.nextInt();
		new Main(initTime, numFilosofos);
	}
	
	public Main (long initTime, int numFilosofos) throws InterruptedException {
		Scanner keyboard = new Scanner(System.in);
		this.initTime = initTime;
		this.numFilosofos = numFilosofos;
		
		mesa = new Mesa(numFilosofos);
		filosofos = new Filosofo[numFilosofos];
		
		for (int i = 0; i < numFilosofos; i++) {
			filosofos[i] = new Filosofo(i, mesa);
		}
		for (int i = 0; i < numFilosofos; i++) {
			filosofos[i].start();
		}
		Thread.sleep(10000);
		for (int i = 0; i < numFilosofos; i++) {
			filosofos[i].setVivo(false);
		}
		for (int i = 0; i < numFilosofos; i++) {
			try {
				filosofos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finalTime = System.currentTimeMillis();
		long tiempo = (finalTime - initTime)/1000;
		System.out.println("Todos los filosofos han terminado en " + tiempo + " segundos");
		
	}

	public int getNumFilosofos() {
		return numFilosofos;
	}

	public void setNumFilosofos(int numFilosofos) {
		this.numFilosofos = numFilosofos;
	}

	public long getInitTime() {
		return initTime;
	}

	public void setInitTime(long initTime) {
		this.initTime = initTime;
	}

	public long getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(long finalTime) {
		this.finalTime = finalTime;
	}
	
	

}
