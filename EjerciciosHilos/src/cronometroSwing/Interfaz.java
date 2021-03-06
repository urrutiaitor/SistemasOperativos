package cronometroSwing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interfaz extends JFrame implements Observer{

	JLabel number;
	
	public Interfaz (){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(crearPanel(), BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	private Component crearPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		number = new JLabel("0");

		panel.add(number, BorderLayout.CENTER);
		
		return panel;
	}

	@Override
	public void update(Observable o, Object arg) {
		int i = ((Cronometro)o).getTime();
		number.setText(Integer.toString(i));
		System.out.println("Updated");
		this.repaint();
	}
	
}
