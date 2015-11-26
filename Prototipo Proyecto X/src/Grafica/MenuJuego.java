package Grafica;
import Logica.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class MenuJuego extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelImagen p;
	private JButton iniciar,salir;
	private GUI gui;
	private Sonido miSonido;
	
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
		iniciar=new JButton();
		salir=new JButton();
		iniciar.addActionListener(new Oyente());
		salir.addActionListener(new OyenteSalir());
		iniciar.setToolTipText("Inicia el juego");
		salir.setToolTipText("Sale del juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 480);
		p = new PanelImagen();
		p.setLayout(null);
		setContentPane(p);
		p.add(iniciar);
		p.add(salir);
		Icon icon = new ImageIcon(getClass().getResource("/imagenes/nuevoJuego.png"));
		Icon iconsalir = new ImageIcon(getClass().getResource("/imagenes/salirJuego.png"));
		iniciar.setIcon(icon);	
		salir.setIcon(iconsalir);
	  	iniciar.setBounds(451, 300, 123, 40);
	  	salir.setBounds(451, 350, 123, 40);
		miSonido = new Sonido("menu.wav",true);
		miSonido.run();
	  	
		
	}
	
	private class Oyente implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui = new GUI();
			setVisible(false);
			miSonido.parar();
		}
	}
	
	private class OyenteSalir implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			System.exit(0);
		}
	}
	
	private class PanelImagen extends javax.swing.JPanel {
		public PanelImagen(){
			this.setSize(1024,768);
		}
		@Override
		public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/logoBomberman.gif"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, this);
		setOpaque(false);
		super.paintComponent(g);
		}
	}	
}