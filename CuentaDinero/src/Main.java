import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		Cuenta cuenta = new Cuenta(10000);
		Ahorrador ahorrador;
		Gastador gastador;
		ArrayList<Ahorrador> ahorradores = new ArrayList<Ahorrador>();
		ArrayList<Gastador> gastadores = new ArrayList<Gastador>();
		
		for(int i = 0; i < 10; i ++){
			ahorrador = new Ahorrador(10, cuenta);
			ahorradores.add(ahorrador);
			ahorrador.start();
			gastador = new Gastador(10, cuenta);
			gastadores.add(gastador);
			gastador.start();
			
		}
		for(int i = 0; i < 10; i ++){
			try {
				ahorradores.get(i).join();
				gastadores.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(cuenta.toString());
	}

}
