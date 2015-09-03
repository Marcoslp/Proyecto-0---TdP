package GUI;

import java.awt.EventQueue;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JLabel Frase, Imagen;
	private JButton Boton;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame("Proyecto 0");
		frame.setBounds(100, 100, 379, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Imagen = new JLabel();
		Imagen.setBounds(86, 15, 181, 285);
		frame.getContentPane().add(Imagen);
		Imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/SeñorTopo.jpg")));
		
		Frase = new JLabel("");
		Frase.setBounds(40, 311, 313, 30);
		frame.getContentPane().add(Frase);
		
		Boton = new JButton("Ver frase");
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frase.setText("Tener un buen matrimonio es como comer una naranja");
				Imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/SeñorTopo2.jpg")));
				Boton.setEnabled(false);
			}
		});
		Boton.setBounds(96, 352, 161, 37);
		frame.getContentPane().add(Boton);
	}
}
