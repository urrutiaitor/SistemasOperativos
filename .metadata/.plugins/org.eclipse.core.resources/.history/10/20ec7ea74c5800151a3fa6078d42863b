import java.util.concurrent.Semaphore;



public class Cuenta {
	
	float saldo;
	Semaphore semaforo;

	public Cuenta(float saldo, Semaphore semaforo) {
		super();
		this.saldo = saldo;
		this.semaforo = semaforo;
	}

	public void changeSaldo(float saldo) {
		
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.saldo = this.saldo + saldo;
		
		semaforo.release();
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}
	
	
}
