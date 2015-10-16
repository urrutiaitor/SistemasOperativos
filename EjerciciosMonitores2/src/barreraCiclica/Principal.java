package barreraCiclica;


public class Principal {

	public static void main(String[] args) {
		final int MAXHILOS = 3;
		MiBarrera barrera = new MiBarrera (MAXHILOS,new Runnable(){

			@Override
			public void run() {
				
			}
			
		});
		
		Numerador hilos [] = new Numerador [MAXHILOS];
		for (int i= 0; i< MAXHILOS; i++){
			hilos [i]= new Numerador(i, barrera);
		}
		for (int i= 0; i< MAXHILOS; i++){
			hilos [i].start();
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
