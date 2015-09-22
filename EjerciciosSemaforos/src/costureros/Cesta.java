package costureros;

import java.util.concurrent.Semaphore;

public class Cesta {

	int numMaxMangas;
	int numMaxCuerpos;

	int numMangas;
	int numCuerpos;

	Semaphore semaforoMangas;
	Semaphore semaforoCuerpos;

	Object cuerpo;
	Object manga;

	public Cesta(int numMaxMangas, int numMaxCuerpos, Semaphore semaforoMangas, Semaphore semaforoCuerpos) {
		super();
		cuerpo = new Object();
		manga = new Object();
		this.numMaxMangas = numMaxMangas;
		this.numMaxCuerpos = numMaxCuerpos;
		this.semaforoMangas = semaforoMangas;
		this.semaforoCuerpos = semaforoCuerpos;
	}

	public int getNumMaxMangas() {
		return numMaxMangas;
	}

	public void setNumMaxMangas(int numMaxMangas) {
		this.numMaxMangas = numMaxMangas;
	}

	public int getNumMaxCuerpos() {
		return numMaxCuerpos;
	}

	public void setNumMaxCuerpos(int numMaxCuerpos) {
		this.numMaxCuerpos = numMaxCuerpos;
	}

	public Semaphore getSemaforoMangas() {
		return semaforoMangas;
	}

	public void setSemaforoMangas(Semaphore semaforoMangas) {
		this.semaforoMangas = semaforoMangas;
	}

	public Semaphore getSemaforoCuerpos() {
		return semaforoCuerpos;
	}

	public void setSemaforoCuerpos(Semaphore semaforoCuerpos) {
		this.semaforoCuerpos = semaforoCuerpos;
	}

	public int getNumMangas() {
		return numMangas;
	}

	public void addNumMangas(int numMangas) {
		synchronized (manga) {
			this.numMangas = this.numMangas + numMangas;
		}
	}

	public void delNumMangas(int numMangas) {
		synchronized (manga) {
			this.numMangas = this.numMangas - numMangas;
		}
	}

	public int getNumCuerpos() {
		return numCuerpos;
	}

	public void addNumCuerpos(int numCuerpos) {
		synchronized (cuerpo) {
			this.numCuerpos = this.numCuerpos + numCuerpos;
		}
	}

	public void delNumCuerpos(int numCuerpos) {
		synchronized (cuerpo) {
			this.numCuerpos = this.numCuerpos - numCuerpos;
		}
	}

}
