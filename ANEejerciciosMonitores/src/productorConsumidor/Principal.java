package productorConsumidor;

public class Principal {

	Buffer buffer;
	Productor p;
	Consumidor c;
	
	public Principal(){
		buffer=new Buffer();
		p=new Productor(buffer);
		p.start();
		c=new Consumidor(buffer);
		c.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal ejercicio=new Principal();
	}

}
