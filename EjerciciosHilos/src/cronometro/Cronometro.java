package cronometro;

public class Cronometro extends Thread{

	public void run() {
		long initialTime = System.currentTimeMillis();
		
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long currentTime = System.currentTimeMillis();
			System.out.println("> " + ((currentTime - initialTime)/1000.));
		}
	}
	
}
