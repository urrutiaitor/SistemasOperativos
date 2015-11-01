package productorConsumidor;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer extends Thread{

	final static int MAXBUFFER=5;
	int valores[];
	int contador;
	Condition colaC, colaP;
	Lock candado;
	
	public Buffer(){
		candado=new ReentrantLock();
		valores=new int[MAXBUFFER];
		colaP=candado.newCondition();
		colaC=candado.newCondition();
		
	}
	
	public void meter(int valor) throws InterruptedException{
		candado.lock();
			while(contador==MAXBUFFER){
				colaP.await();
			}
		
			valores[contador]=valor;
			contador++;
			System.out.println("mete "+valor);
			colaC.signal();
		candado.unlock();
		
	}
	
	public int sacar() throws InterruptedException{
		int valor;
		candado.lock();
	
			while(contador==0){
				colaC.await();
			}
		
			valor=valores[contador];
			contador--;
			System.out.println("saca "+valor);
			colaP.signal();
		candado.unlock();
		return valor;
	}
	
	
}
