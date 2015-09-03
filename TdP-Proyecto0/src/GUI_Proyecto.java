import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI_Proyecto extends JFrame {

	private JPanel contentPane;
	private JButton botonFrase;
	private JLabel labelFrases;
	private JLabel imagenSimpson;
	private int contador;
	private JLabel labelFrases2;
	private JLabel labelFrases3;
	private JButton BotonReiniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Proyecto frame = new GUI_Proyecto();
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
	public GUI_Proyecto() {
		
		
		
		setTitle("Proyecto 0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contador=0;
		
		botonFrase = new JButton("Frase");
		botonFrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String frase="";
				if(contador==0){
				frase="Trabajo muy duro, como un esclavo.. ohh ya se me olvidó todo..";
				labelFrases2.setText("Bueno.. ehhmm paguenme dinero!!");
				labelFrases.setText(frase);
				labelFrases.setVisible(true);
				labelFrases2.setVisible(true);
				contador++;
				}
				else{
					if(contador==1){
						imagenSimpson.setIcon(new ImageIcon(getClass().getResource("/Imagenes/trabajo 2.jpg")));
						frase="Un excelente empleado Smithers, una sonrisa en los labios y una";
						labelFrases.setText(frase);
						labelFrases2.setText("canción en el corazón. Asciendalo.");
						contador++;
					}
					else{
						if(contador==2){
							imagenSimpson.setIcon(new ImageIcon(getClass().getResource("/Imagenes/trabajo 3.jpg")));
							frase="Trabaaajo muuy duroo.. coomoo un esclaavoo";
							labelFrases3.setText(frase);
							labelFrases2.setText("");
							labelFrases.setText("");
							contador++;
						}
						else{
							if(contador==3)
								imagenSimpson.setIcon(new ImageIcon(getClass().getResource("/Imagenes/trabajo 4.jpg")));
								botonFrase.setEnabled(false);
								
						}
					}
				}
				
			}
		});
		botonFrase.setBounds(486, 68, 107, 42);
		contentPane.add(botonFrase);
		
		BotonReiniciar = new JButton("Reiniciar");
		BotonReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imagenSimpson.setIcon(new ImageIcon(getClass().getResource("/Imagenes/trabajo1.jpg")));
				labelFrases.setText("");
				labelFrases2.setText("");
				labelFrases3.setText("");
				contador=0;
				botonFrase.setEnabled(true);
			}
		});
		BotonReiniciar.setBounds(0, 0, 89, 23);
		contentPane.add(BotonReiniciar);
		
		labelFrases= new JLabel("");
		labelFrases.setBounds(107, 202, 386, 60);
		contentPane.add(labelFrases);
		
		imagenSimpson = new JLabel("");
		imagenSimpson.setIcon(new ImageIcon(getClass().getResource("/Imagenes/trabajo1.jpg")));
		imagenSimpson.setBounds(139, 11, 300, 201);
		contentPane.add(imagenSimpson);
		
		labelFrases2 = new JLabel("");
		labelFrases2.setBounds(107, 223, 386, 42);
		contentPane.add(labelFrases2);
		
		labelFrases3 = new JLabel("");
		labelFrases3.setBounds(139, 223, 300, 23);
		contentPane.add(labelFrases3);
		labelFrases.setVisible(false);
	}
}
