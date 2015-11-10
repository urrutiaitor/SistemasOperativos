package itv;

public class Main {

	public static int MAXCOHESAPARCAMIENTO = 30;
	public static int MAXCOCHESCOCHERA = 3;
	public static int NUMOPERARIOS = 3;
	public static int NUMCOCHES = 20;
	public static boolean fin;
	
	Coche coches [];
	
	BuzonAsincrono aparcamiento;
	BuzonAsincrono cochera;
	BuzonAsincrono revisado;
	
	Operario operarios[];
	
	public static void main(String[] args) {
		Main ejercicio = new Main();
		ejercicio.iniciar();
		try {
			ejercicio.terminar();
		} catch (InterruptedException e) {}
	}
	
	public Main() {
		
		aparcamiento = new BuzonAsincrono(MAXCOHESAPARCAMIENTO);
		cochera = new BuzonAsincrono(MAXCOCHESCOCHERA);
		revisado = new BuzonAsincrono(NUMOPERARIOS);
		
		coches = new Coche [NUMCOCHES];
		for (int i = 0; i<NUMCOCHES; i++){
			coches[i]= new Coche(i, aparcamiento, cochera, revisado);
		}
		operarios = new Operario[NUMOPERARIOS];
		for (int i = 0; i<NUMOPERARIOS; i++){
			operarios[i]= new Operario(i,aparcamiento, cochera, revisado);
		}
		for(int i = 0; i < MAXCOHESAPARCAMIENTO; i++) {
			try {
				aparcamiento.send(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void iniciar(){
		for (int i = 0; i<NUMOPERARIOS; i++){
			operarios[i].start();
		}
		for (int i = 0; i<NUMCOCHES; i++){
			coches[i].start();
		}
	}
	public void terminar() throws InterruptedException {
		for (int i = 0; i<NUMCOCHES; i++){
			coches[i].join();
		}
		
		for (int i = 0; i < NUMOPERARIOS; i++){
			operarios[i].setTrabajando();
			operarios[i].interrupt();
		}
	}

}