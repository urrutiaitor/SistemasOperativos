package BufferSincronizadoAlmacenadoVariosInterfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interfaz extends JFrame{

	ArrayList<Buffer> bufferes;
	
	public Interfaz (ArrayList<Buffer> bufferes)){
		this.bufferes = bufferes;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(crearPanel(), BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	private Component crearPanel() {
		JPanel panel = new JPanel(new GridLayout(1, bufferes.size()));
		
		for(int i = 0; i < bufferes.size(); i++){
			panel.add(crearPanelIndividual());
		}
		
		return panel;
	}
}
