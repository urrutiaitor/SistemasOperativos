package juegoJugador;

public class Jugador {

	int vidas;
	int vidasMax;

	public Jugador(int vidas) {
		super();
		this.vidas = vidas;
		this.vidasMax = 2*vidas;
	}
	
	public int getVidas(){
		return vidas;
	}
	
	public boolean quitarVida(){
		vidas--;
		System.out.println("Vidas: " + vidas);
		if(vidas == 0) return true;
		return false;
	}
	
	public boolean darVida(){
		vidas++;
		System.out.println("Vidas: " + vidas);
		if(vidas == vidasMax) return true;
		return false;
	}
}
