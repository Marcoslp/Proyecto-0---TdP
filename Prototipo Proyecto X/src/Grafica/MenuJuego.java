package Grafica;
import Logica.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class MenuJuego extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelImagen p;
	private JButton iniciar;
	private GUI gui;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJuego frame = new MenuJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MenuJuego(){
		setTitle("Bomberman: Digimon Edition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 480);
		iniciar=new JButton("Iniciar Juego");
		iniciar.addActionListener(new Oyente());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 480);
		p = new PanelImagen();
		p.setLayout(null);
		setContentPane(p);
		p.add(iniciar);
		iniciar.setBounds(100, 100,100,100);
		
	}
	
	private class Oyente implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui = new GUI();
			setVisible(false);
		}
	}
	
	private class PanelImagen extends javax.swing.JPanel {
		public PanelImagen(){
			this.setSize(1024,768);
		}
		@Override
		public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/b.png"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
		}
	}	
}