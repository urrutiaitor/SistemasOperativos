package Inicial;

public class Cuenta {

	float saldo;

	public Cuenta(float saldo) {
		super();
		this.saldo = saldo;
	}

	public void changeSaldo(float dinero) {

		this.saldo = this.saldo + dinero;
		
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + "]";
	}

}
