package multiplicacionMatriz;

public class Main {

	final static int dimension = 10;
	final static int hilos = 7;
	
	public static void main(String[] args) {
		
		Matriz matrizA = new Matriz(dimension, dimension);
		Matriz matrizB = new Matriz(dimension, dimension);
		Matriz matrizC = new Matriz(dimension, dimension);
		
		int hilosParaCada = dimension/hilos;
		int resto = dimension%hilos;
		
		for(int i = 0; i < hilos; i++){
			Multiplicador multiplicador = new Multiplicador(matrizA, matrizB, matrizC, (i*hilosParaCada), ((i+1)*hilosParaCada));
			
			multiplicador.start();
		}
		
		if(resto > 0) {
			Multiplicador multiplicador = new Multiplicador(matrizA, matrizB, matrizC, (hilos*hilosParaCada), (hilos*hilosParaCada) + resto);
			
			multiplicador.start();
			
		}
		
		System.out.println("Matriz A:");
		System.out.println(matrizA.toString());

		System.out.println("Matriz B:");
		System.out.println(matrizB.toString());

		System.out.println("Matriz C:");
		System.out.println(matrizC.toString());

	}

}
