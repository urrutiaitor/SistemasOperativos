package EsperarVariasVeces;

import java.util.Random;

public class Trabajo {

	int limite;
	int trabajosHechos;
	
	
	public Trabajo(int limite) {
		super();
		this.limite = limite;
	}
	
	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getTrabajosHechos() {
		return trabajosHechos;
	}

	public void setTrabajosHechos(int trabajosHechos) {
		this.trabajosHechos = trabajosHechos;
	}

	public synchronized boolean añadirTrabajo() {
		trabajosHechos++;
		
		if(trabajosHechos == limite) {
			return true;
		}
		return false;
	}
	
	public synchronized boolean crearTrabajo() {
		trabajosHechos--;
		
		if(trabajosHechos == 0) {
			return true;
		}
		return false;
	}

	public void trabajar(int num) {
		Random random = new Random();
		long a = 0;
		
		for(int i = 0; i < 10; i++){
			for(int y = 0; y < 10; y++){
				try {
					Thread.sleep(random.nextInt(1));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a = a + y;
			}
		}
		System.out.println(num);
	}
	
}
