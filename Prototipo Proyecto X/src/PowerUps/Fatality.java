package PowerUps;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Lógica.Celda;
import Personajes.Bomberman;


public class Fatality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Fatality (int x, int y, Celda miCelda) {
		super(x,y,miCelda);
		this.miImagen = new JLabel (new ImageIcon(this.getClass().getResource("/Imagenes/Fatality.png")));
		this.miImagen.setBounds(1*32, 5*32, 32, 32); //PROVISORIO, SOLO PARA EL PROTOTIPO, PORQUE SE NECESITARIA PODER EXPLOTAR LAS PAREDES
	}
	
	//Operaciones
	
	public void empower (Bomberman b) {
		//b.obtenerBomba().duplicarAlcance();
		this.miImagen.setVisible(false); //PROVISORIO PROTOTIPO, REALMENTE LA CELDA MANEJARIA LA IMAGEN
		System.out.println("Alcance x 2");
	}

}
