package productorConsumidor;

import java.util.concurrent.Semaphore;

public class Buffer {

	int numeros[];
	Object escribir;
	Object leer;
	int indiceLeer;
	int indiceEscribir;
	int valoresMax = 30;
	int contador = 0;

	public Buffer(Object oEscribir, Object oLeer, int valoresMax) {
		numeros = new int[valoresMax];
		this.escribir = oEscribir;
		this.leer = oLeer;
		indiceLeer = 0;
		indiceEscribir = 0;
		this.valoresMax = valoresMax;
	}

	public int getNumero() {

		int numero = 0;

		synchronized (leer) {
			while (contador == 0)
				try {
					leer.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		synchronized (this) {
			contador--;
			numero = numeros[indiceLeer++ % valoresMax];
		}

		synchronized (escribir) {
			escribir.notify();
		}

		return numero;
	}

	public void setNumero(int numero) {
		synchronized (escribir) {
			while (contador == valoresMax)
				try {
					escribir.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		synchronized (this) {
			contador++;
			numeros[indiceEscribir++ % valoresMax] = numero;
		}

		synchronized (leer) {
			leer.notify();
		}

	}

	public String visualizarArray() {
		return "Numeros: [" + numeros[0] + " / " + numeros[1] + " / " + numeros[2] + " / " + numeros[3] + " / "
				+ numeros[4] + " / " + numeros[5] + " / " + numeros[6] + " / " + numeros[7] + " / " + numeros[8] + " / "
				+ numeros[9] + " / " + numeros[10] + " / " + numeros[11] + " / " + numeros[12] + " / " + numeros[13]
				+ " / " + numeros[14] + " / " + numeros[15] + " / " + numeros[16] + " / " + numeros[17] + " / "
				+ numeros[18] + " / " + numeros[19] + " / " + numeros[20] + " / " + numeros[21] + " / " + numeros[22]
				+ " / " + numeros[23] + " / " + numeros[24] + " / " + numeros[25] + " / " + numeros[26] + " / "
				+ numeros[27] + " / " + numeros[28] + " / " + numeros[29] + " ]";
	}

}
