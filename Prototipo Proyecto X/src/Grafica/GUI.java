package Grafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import Logica.Nivel;
import PowerUps.Masacrality;
import PowerUps.PowerUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private JLabel miTiempo;
	private static final long serialVersionUID = 1L;
	private Nivel miNivel;
	private JPanel contentPane;
	private JLabel puntaje;
	private Sonido miSonido;
	
	/**
	 * Create the frame.
	 */

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 480);
		contentPane = new JPanel();
		this.setTitle("Bomberman: Digimon Edition");
		
		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				 switch(e.getKeyCode()){
					case KeyEvent.VK_LEFT:
						miNivel.obtenerBomberman().establecerDireccion(0);
						break;
			   		case KeyEvent.VK_RIGHT:
						miNivel.obtenerBomberman().establecerDireccion(1);
			   			break;
			   		case KeyEvent.VK_UP:
						miNivel.obtenerBomberman().establecerDireccion(2);
			   			break;
			   		case KeyEvent.VK_DOWN:
						miNivel.obtenerBomberman().establecerDireccion(3);
			   			break;		
			   		case KeyEvent.VK_SPACE:{
			   			miNivel.obtenerBomberman().establecerPuseBomba(true);			   		
			   		}
			   		break;
			   		
			   		case KeyEvent.VK_A:{
			   			miNivel.obtenerBomberman().establecerModoDios(true);
			   			miNivel.obtenerBomberman().DuplicarVelocidad();
			   			miNivel.obtenerBomberman().aumentarCapacidadBombas();
			   			miNivel.obtenerBomberman().obtenerBomba().duplicarAlcance();
			   		}
			   }
			}
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		miTiempo = new JLabel("Tiempo : 00 : 00 : 00");
		miTiempo.setFont(new java.awt.Font("Tahoma", 1, 11));
		miTiempo.setForeground(new java.awt.Color(2, 2, 2));
		miTiempo.setBounds(0, 417, 172, 25);
		contentPane.add(miTiempo);
		
		puntaje = new JLabel("Puntaje : 0");
		puntaje.setFont(new java.awt.Font("Tahoma", 1, 11));
		puntaje.setForeground(new java.awt.Color(2, 2, 2));
		puntaje.setBounds(181, 417, 191, 25);
		contentPane.add(puntaje);
		miNivel = new Nivel(this);
		setVisible(true);
	//	miSonido = new Sonido("Digimon - Butterfly.mid",true);
	//	miSonido.run();
		
	}
	
	public void establecerTiempo(String tiempo){
		miTiempo.setText(tiempo);
	}
	
	public void establecerPuntaje(String puntaje){
		this.puntaje.setText(puntaje);	
	}

public void cartelPerder() {
		miSonido.parar();
		int puntuacion = miNivel.obtenerPuntuacion();
		//miNivel=null;
		PanelImagen panel = new PanelImagen();
		panel.setVisible(true);
		panel.setLayout(null);
		setContentPane(panel);
		miNivel.terminoJuego();
		
		JLabel puntajeX = new JLabel("Puntaje : "+puntuacion);
		puntajeX.setFont(new java.awt.Font("Impact", 1, 40));
		puntajeX.setForeground(new java.awt.Color(2, 2, 2));
		puntajeX.setBounds(451, 300, 400, 100);
		panel.add(puntajeX);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton iniciar=new JButton();
		JButton salir=new JButton();
		iniciar.addActionListener(new Oyente());
		salir.addActionListener(new OyenteSalir());
		iniciar.setToolTipText("Inicia el juego");
		salir.setToolTipText("Sale del juego");
		panel.add(iniciar);
	  	panel.add(salir);
		Icon icon = new ImageIcon(getClass().getResource("/imagenes/nuevoJuego.png"));
		Icon iconsalir = new ImageIcon(getClass().getResource("/imagenes/salirJuego.png"));
		iniciar.setIcon(icon);	
		salir.setIcon(iconsalir);
	  	iniciar.setBounds(451, 400, 123, 40);
	  	salir.setBounds(600, 400, 123, 40);
	
	}

	private class Oyente implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GUI gui = new GUI();
			setVisible(false);
		}
	}

	private class OyenteSalir implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			System.exit(0);
		}
	}


	public void cartelGanar() {
		this.setVisible(false);
		MenuJuego frame = new MenuJuego();
		frame.setVisible(true);
		JOptionPane.showConfirmDialog(
			    frame, "¡¡¡Felicidades, ganaste !!! Tu puntuacion fue : " + this.miNivel.obtenerPuntuacion() ,
			    "¡ Ganaste !",
			    JOptionPane.PLAIN_MESSAGE);
		
	}
	
	private class PanelImagen extends javax.swing.JPanel {
		public PanelImagen(){
			this.setSize(1024,480);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		@Override
		public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/imagenPerdiste.png"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, this);
		setOpaque(false);
		super.paintComponent(g);
		}
	}	
}