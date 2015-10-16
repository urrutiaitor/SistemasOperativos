package itv;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	final static int numCochesMax = 2;
	final static int numInspeccionesMax = 1;
	final static int numOperariosMax = 3;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();
		
		ArrayList<Operario> operarios = new ArrayList<>();
		Aparcamiento aparcamiento = new Aparcamiento(0, 0, numCochesMax, numInspeccionesMax);
		
		CreadorClientes clientes = new CreadorClientes(aparcamiento);
		main.crearOperarios(operarios, aparcamiento);
		clientes.start();
		main.iniciarOperarios(operarios);
		
		scanner.nextLine();
		
		clientes.setAbierto(false);
		clientes.interrupt();
		
		main.pararOperarios(operarios);
	
	}
	
	public void crearOperarios(ArrayList<Operario> operarios, Aparcamiento aparcamiento){
		for(int i = 0; i < numOperariosMax; i++){
			operarios.add(new Operario(aparcamiento));
		}
	}
	
	public void iniciarOperarios(ArrayList<Operario> operarios){
		for(int i = 0; i < numOperariosMax; i++){
			operarios.get(i).start();
		}
	}
	
	public void pararOperarios(ArrayList<Operario> operarios){
		for(int i = 0; i < numOperariosMax; i++){
			operarios.get(i).setTrabajando(false);
			operarios.get(i).interrupt();
		}
	}

}