package barreraCiclica;


public class Numerador extends Thread {
	final int 	MAXNUM = 10;
	private int id;
	
	MiBarrera barrera;
	static int ultimo;
	
	
	
	public Numerador (int id,  MiBarrera barrera){
		this.id = id;
		
		this.barrera = barrera;
		ultimo = 0;
	}
	@Override
	public void run() {
		for (int i = 0; i<MAXNUM; i++){
			System.out.println("Hilo "+id+": "+i);
			try {
				System.out.println("Esperar");
				barrera.esperar();
				System.out.println("Sleep");
				Thread.sleep(10000);
			} catch (Exception e) {
			}
		}
		
		System.out.println("Hilo "+id+" adios");
	}

}
