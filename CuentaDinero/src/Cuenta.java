import java.util.concurrent.atomic.AtomicInteger;


public class Cuenta {
	public static AtomicInteger saldo = new AtomicInteger(0);
	MainClass.number.incrementAndGet();

	public Cuenta(float saldo) {
		super();
		this.saldo = saldo;
	}
	
	

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void changeSaldo(float saldo) {
		this.saldo = this.saldo + saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}
	
	
}
