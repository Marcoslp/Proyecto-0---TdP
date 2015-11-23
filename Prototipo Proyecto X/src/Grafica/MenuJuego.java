package Grafica;
import Logica.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuJuego extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton iniciar;
	private GUI gui;
	private Nivel miNivel;
	
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
		setLayout(new GridLayout());
		panel=new JPanel();
		setContentPane(panel);
		iniciar=new JButton("Iniciar Juego");
		iniciar.addActionListener(new Oyente());
		panel.add(iniciar);
	}
	
	private class Oyente implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gui = new GUI();
			setVisible(false);
		}
	}
}