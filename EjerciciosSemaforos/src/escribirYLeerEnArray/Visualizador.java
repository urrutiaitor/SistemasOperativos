package escribirYLeerEnArray;

public class Visualizador extends Thread{

	int numeros[];

	public Visualizador(int[] numeros) {
		super();
		this.numeros = numeros;
	}
	
	public void run(){
		while(true){
			
			System.out.println(Integer.toString(numeros[0]) + Integer.toString(numeros[1])
			+ Integer.toString(numeros[2]) + Integer.toString(numeros[3]));
		}
	}
	
}
