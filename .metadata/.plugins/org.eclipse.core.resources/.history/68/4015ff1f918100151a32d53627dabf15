package copiadorArchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

public class Copiador implements Callable<String> {

	File origen;
	String pathDestino;
	FileInputStream in;
	FileOutputStream out;
	
	public Copiador(File origen, String path){
		this.origen = origen;
		this.pathDestino = path+"//"+origen.getName();
	}
	
	@Override
	public String call() throws Exception {
		try {
			in = new FileInputStream(origen);
			out = new FileOutputStream(pathDestino);
			int c;
			while ((c=in.read())!=-1){
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (in!=null) in.close();
			if (out!=null) out.close();
		}
		return origen.getName();
	}

}
