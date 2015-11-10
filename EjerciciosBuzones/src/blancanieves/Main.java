package blancanieves;

public class Main {

	Blancanieves bn;
	Enanito enanitos[];
	
	final static int numEnanitos = 7;
	final static int numSillas = 4;
	
	
	public static void main(String[] args) {
		Main main = new Main();
	}
	
	public Main () {
		BuzonAsincrono buzonEntrar = new BuzonAsincrono(numSillas);
		BuzonSincrono buzonComer = new BuzonSincrono();
		
		for (int i = 0; i < numSillas; i++) {
			buzonEntrar.send(i);
		}
		
		bn = new Blancanieves(buzonEntrar, buzonComer, numEnanitos);
		
		enanitos = new Enanito[numEnanitos];
		
		for (int i = 0; i < numEnanitos; i++) {
			enanitos[i] = new Enanito(buzonEntrar, buzonComer, i);
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
		try {
			bn.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
