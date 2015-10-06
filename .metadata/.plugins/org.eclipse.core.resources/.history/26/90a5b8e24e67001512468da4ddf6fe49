package cena;

public class Persona extends Thread {
	
	Cena cena;
	int id;
	
	public Persona (Cena cena, int id){
		this.cena = cena;
		this.id = id;
	}
	
	
	public void run(){
		System.out.println(id + ".- Esperando");
		try {
			cena.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id + ".- Cena");
	}

}
