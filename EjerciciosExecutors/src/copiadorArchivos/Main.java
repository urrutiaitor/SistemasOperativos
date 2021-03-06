package copiadorArchivos;

import java.io.File;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	
	ExecutorService executor;
	CompletionService<String> copyService;

	public Main(int i) {
		executor = Executors.newFixedThreadPool(i);
		copyService = new ExecutorCompletionService<>(executor);
	}

	public static void main(String[] args) {
		File file = new File("music");
		String path = "copia";
		Main main = new Main(4);
		
		if (!main.copiarFicheros(file, path)) {
			System.err.println("Debes introducir un directorio");
		}
	}

	private boolean copiarFicheros(File file, String path) {
		if (!file.isDirectory()){
			return false;
		}
		File [] ficheros;
		int ficherosACopiar = 0;
		ficheros = file.listFiles();
		for (int i = 0; i<ficheros.length;i++){
			if (ficheros[i].isFile()){
				Copiador copiador = new Copiador(ficheros[i],path);
				ficherosACopiar++;
				copyService.submit(copiador);
			}
		}
		
		
		for (int i=0; i<ficherosACopiar; i++){
			String nombre;
			Future<String> future;
			try {
				future = copyService.take();
				nombre = future.get();
				System.out.println(nombre +" copiado");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		executor.shutdown();
		return true;
	}

}
