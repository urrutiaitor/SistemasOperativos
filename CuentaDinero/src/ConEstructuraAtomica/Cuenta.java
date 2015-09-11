package ConEstructuraAtomica;

import java.util.concurrent.atomic.AtomicInteger;

public class Cuenta {

	private AtomicInteger saldo;

	public Cuenta(int saldo) {
		super();
		this.saldo = new AtomicInteger(saldo);
	}

	public void changeSaldo(int dinero) {

		saldo.getAndAdd(dinero);
		
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}

}
