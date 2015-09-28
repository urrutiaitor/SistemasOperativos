package gestinTraficoPuente;

public class Creador {

	Puente puente;
	boolean creando;
	
	public Creador(Puente puente){
		this.puente = puente;
		creando = true;
	}
	
	public void run(){
		Coche coche;
		while (creando){
			coche = new Coche(puente);
			coche.start();
		}
	}
}
