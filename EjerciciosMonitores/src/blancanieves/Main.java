package blancanieves;

public class Main {

	Blancanieves bn;
	Enanito enanitos[];
	Mesa mesa;
	
	final static int numEnanitos = 7;
	final static int numSillas = 4;
	
	
	public static void main(String[] args) {
		Main main = new Main();
	}
	
	public Main () {
		Mesa mesa = new Mesa(numSillas);
		bn = new Blancanieves(mesa);
		
		enanitos = new Enanito[numEnanitos];
		
		for (int i = 0; i < numEnanitos; i++) {
			enanitos[i] = new Enanito(mesa, i);
		}
		
		bn.start();
		for (int i = 0; i < numEnanitos; i++) {
			enanitos[i].start();
			
		}
		
		for (int i = 0; i < numEnanitos; i++) {
			try {
				enanitos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mesa.setTerminado();
		bn.interrupt();
		try {
			bn.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
