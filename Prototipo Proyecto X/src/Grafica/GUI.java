package Grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import L�gica.Bomba;
import L�gica.Nivel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
	private Nivel miNivel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 480);
		contentPane = new JPanel();
		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				 switch(e.getKeyCode()){
					case KeyEvent.VK_LEFT:
			   			miNivel.obtenerBomberman().moverIzquierda();
			  		break;
			   		case KeyEvent.VK_RIGHT:
			   			miNivel.obtenerBomberman().moverDerecha();
			   			break;
			   		case KeyEvent.VK_UP:
			   			miNivel.obtenerBomberman().moverArriba();
			   			break;
			   		case KeyEvent.VK_DOWN:
			   			miNivel.obtenerBomberman().moverAbajo();
			   			break;
			   		case KeyEvent.VK_SPACE:{
			   			Bomba bombaClonada = miNivel.obtenerBomberman().ponerBomba();
			   			//LE MODIFICA LA POSICION AL LABEL
			   			bombaClonada.obtenerGraficos().obtenerImagenActual().setBounds(bombaClonada.obtenerPosicion().obtenerX()*32, bombaClonada.obtenerPosicion().obtenerY()*32,32,32);
			   			add(bombaClonada.obtenerGraficos().obtenerImagenActual());
			   			getContentPane().setComponentZOrder(bombaClonada.obtenerGraficos().obtenerImagenActual(), 0);
			   		
			   		}
			   		break;			   		
			   }
			}

		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		miNivel = new Nivel(this);
	}

}
