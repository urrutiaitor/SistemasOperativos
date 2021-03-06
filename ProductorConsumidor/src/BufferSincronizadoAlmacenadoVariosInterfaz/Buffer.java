package BufferSincronizadoAlmacenadoVariosInterfaz;

import java.util.concurrent.Semaphore;

public class Buffer {

	int numeros[];
	Semaphore escribir;
	Semaphore leer;
	int indiceLeer;
	int indiceEscribir;
	int valoresMax = 30;

	public Buffer(Semaphore escribir, Semaphore leer, int valoresMax) {
		numeros = new int[valoresMax];
		this.escribir = escribir;
		this.leer = leer;
		indiceLeer = 0;
		indiceEscribir = 0;
		this.valoresMax = valoresMax;
	}

	public int getNumero() {
		esperar(100);
		
		try {
			leer.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		esperar(400);
		int numero = numeros[indiceLeer++%valoresMax];
		escribir.release();
		esperar(100);
		System.out.println("Numero leido: " + numero);
		
		esperar(100);
		
		return numero;
		
	}

	public void setNumero(int numero) {
		esperar(100);
		try {
			escribir.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		esperar(100);
		numeros[indiceEscribir++%valoresMax] = numero;
		leer.release();
		esperar(100);
		System.out.println("Numero escrito: " + numero);
		esperar(100);
		
		System.out.println(visualizarArray());
		
	}
	
	public void esperar(int tiempo){
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String visualizarArray(){
		return "Numeros: [" + numeros[0] + " / " + numeros[1] + " / " + numeros[2] + " / " + numeros[3] + " / "  + numeros[4]
				+ " / " + numeros[5] + " / " + numeros[6] + " / " + numeros[7] + " / " + numeros[8] + " / " + numeros[9] + " / "+
				numeros[10] + " / " + numeros[11] + " / " + numeros[12] + " / " + numeros[13] + " / "  + numeros[14] + " / " +
				numeros[15] + " / " + numeros[16] + " / " + numeros[17] + " / " + numeros[18] + " / " + numeros[19] + " / "+
				numeros[20] + " / " + numeros[21] + " / " + numeros[22] + " / " + numeros[23] + " / "  + numeros[24] + " / " +
				numeros[25] + " / " + numeros[26] + " / " + numeros[27] + " / " + numeros[28] + " / " + numeros[29] + " ]";
		}
	
}
