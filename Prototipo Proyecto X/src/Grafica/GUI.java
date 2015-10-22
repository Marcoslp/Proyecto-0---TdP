package Grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lógica.Bomba;
import Lógica.Nivel;

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
		this.setTitle("Bomberman");
		addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
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
			   			miNivel.obtenerBomberman().ponerBomba();			   		
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
