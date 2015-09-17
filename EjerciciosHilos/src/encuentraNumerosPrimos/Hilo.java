package encuentraNumerosPrimos;

public class Hilo extends Thread{

	int rangoInicio;
	int rangoFinal;
	
	
	public Hilo(int rangoInicio, int rangoFinal) {
		super();
		this.rangoInicio = rangoInicio;
		this.rangoFinal = rangoFinal;
	}
	
	public void run() {
		for(int i = rangoInicio; i < rangoFinal; i++){
			if(comprobar(i)) System.out.println(i);
		}
	}
	
	private boolean comprobar(int numero) {
		if(numero < 2) return false;
		for(int cont = 2; cont < numero; cont++){
			if(numero%cont == 0){
				return false;
			}
		}
		return true;
	}
	
}
