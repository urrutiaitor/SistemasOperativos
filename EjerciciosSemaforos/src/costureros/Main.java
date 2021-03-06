package costureros;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numMaxMangas = 100;
		int numMaxCuerpos = 100;
		
		int numMaxHilosMangas = 10;
		int numMaxHilosCuerpos = 10;
		
		Semaphore semaforoMangas = new Semaphore(numMaxMangas);
		Semaphore semaforoCuerpos = new Semaphore(numMaxCuerpos);
		
		Cesta cesta = new Cesta(numMaxCuerpos, numMaxCuerpos, semaforoMangas, semaforoCuerpos);
		
		ArrayList<Cuerpo> cuerpos = new ArrayList<Cuerpo>();
		crearCuerpos(numMaxHilosCuerpos, cuerpos, cesta, semaforoCuerpos);
		
		ArrayList<Manga> mangas = new ArrayList<Manga>();
		crearMangas(numMaxHilosMangas, mangas, cesta, semaforoCuerpos);
		
		Ensamblaje ensamblaje = new Ensamblaje(cesta);

		iniciarCuerpos(cuerpos);
		iniciarMangas(mangas);
		ensamblaje.start();
		
		scanner.nextLine();
		
		pararCuerpos(cuerpos);
		pararMangas(mangas);
		ensamblaje.interrupt();
	}

	private static void crearCuerpos(int numMaxCuerpos, ArrayList<Cuerpo> cuerpos, Cesta cesta, Semaphore semaforoCuerpos) {
		for(int i = 0; i < numMaxCuerpos; i++){
			cuerpos.add(new Cuerpo(cesta));
		}
	}

	private static void crearMangas(int numMaxMangas, ArrayList<Manga> mangas, Cesta cesta, Semaphore semaforoMangas) {
		for(int i = 0; i < numMaxMangas; i++){
			mangas.add(new Manga(cesta));
		}
	}
	
	private static void iniciarCuerpos(ArrayList<Cuerpo> cuerpos) {
		for(int i = 0; i < cuerpos.size(); i++){
			cuerpos.get(i).start();
		}
	}

	private static void iniciarMangas(ArrayList<Manga> mangas) {
		for(int i = 0; i < mangas.size(); i++){
			mangas.get(i).start();
		}
	}

	private static void pararCuerpos(ArrayList<Cuerpo> cuerpos) {
		for(int i = 0; i < cuerpos.size(); i++){
			cuerpos.get(i).interrupt();
		}
	}

	private static void pararMangas(ArrayList<Manga> mangas) {
		for(int i = 0; i < mangas.size(); i++){
			mangas.get(i).interrupt();
		}
	}
}
