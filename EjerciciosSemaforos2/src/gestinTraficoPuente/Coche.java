package gestinTraficoPuente;

import java.util.Random;

public class Coche extends Thread {

	Puente puente;

	public Coche(Puente puente) {
		super();
		this.puente = puente;
	}

	public void run() {
		Random random = new Random();
		int direccion = random.nextInt(100);

		try {
			if (direccion % 2 == 0)
				puente.cruzar("norte");
			if (direccion % 2 == 1)
				puente.cruzar("sur");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
