package escribirYLeerEnArray;

public class Visualizador extends Thread{

	int numeros[];

	public Visualizador(int[] numeros) {
		super();
		this.numeros = numeros;
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Integer.toString(numeros[0]) + Integer.toString(numeros[1])
			+ Integer.toString(numeros[2]) + Integer.toString(numeros[3]));
		}
	}
	
}