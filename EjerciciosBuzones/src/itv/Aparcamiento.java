package itv;

import java.util.concurrent.Semaphore;

public class Aparcamiento {
	
	BuzonAsincrono<Integer> buzonAparcamiento;
	BuzonAsincrono<Integer> buzonInspeccion;
	BuzonAsincrono<Integer> buzonFinal;
	
	Semaphore candadoAparcamiento;
	Semaphore candadoOperario;
	
	public Aparcamiento(int numCochesParking, int numCochesInspeccion, int numCochesMaximo, int numInspeccionesMaximo) {
		super();
		
		buzonAparcamiento = new BuzonAsincrono<Integer>(numCochesMaximo);
		buzonInspeccion = new BuzonAsincrono<Integer>(numInspeccionesMaximo);
		buzonFinal = new BuzonAsincrono<Integer>(numInspeccionesMaximo);
		
		for(int i = 0; i < numCochesMaximo; i++){
			try {
				buzonAparcamiento.send(i+1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 0; i < numInspeccionesMaximo; i++){
			try {
				buzonFinal.send(i+1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void inspeccionarCoche() throws InterruptedException{
		int sitioInspeccion = buzonFinal.recieve();
		buzonInspeccion.send(sitioInspeccion);
		
		int sitioAparcamiento = buzonInspeccion.recieve();
		buzonAparcamiento.send(sitioAparcamiento);
		
		System.out.println("Coche inspeccionando en sitio " + sitioInspeccion);
		
		buzonAparcamiento.send(sitioAparcamiento);
		
	}
	
	public void aparcarCoche() throws InterruptedException{
		int sitioAparcamiento = buzonAparcamiento.recieve();
		System.out.println("Coche aparcando en sitio " + sitioAparcamiento);
		buzonInspeccion.send(sitioAparcamiento);
	}
}
