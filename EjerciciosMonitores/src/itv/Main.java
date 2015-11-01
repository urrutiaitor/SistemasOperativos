package itv;

public class Main {

	public static int MAXCOHESAPARCAMIENTO = 3;
	public static int NUMOPERARIOS = 3;
	public static int NUMCOCHES = 20;
	public static boolean fin;
	
	Coche coches [];
	ITV itv;
	Operario operarios[];
	
	public static void main(String[] args) {
		Main ejercicio = new Main();
		ejercicio.iniciar();
		try {
			ejercicio.terminar();
		} catch (InterruptedException e) {}
	}
	
	public Main() {
		itv = new ITV(MAXCOHESAPARCAMIENTO, NUMOPERARIOS);
		coches = new Coche [NUMCOCHES];
		for (int i = 0; i<NUMCOCHES; i++){
			coches[i]= new Coche(i,itv);
		}
		operarios = new Operario[NUMOPERARIOS];
		for (int i = 0; i<NUMOPERARIOS; i++){
			operarios[i]= new Operario(i,itv);
		}
		fin = false;
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
		Main.fin = true;
		itv.cerrar();
		for (int i = 0; i < NUMOPERARIOS; i++){
			operarios[i].interrupt();
		}
	}

}