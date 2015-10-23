package PowerUps;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Celda;
import Personajes.Bomberman;

/**
 * Clase que modela la logica del powerUp Fatality
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 */

public class Fatality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Fatality (int x, int y, Celda miCelda) {
		super(x,y,miCelda);
		this.miImagen = new JLabel (new ImageIcon(this.getClass().getResource("/Imagenes/Fatality.png")));
		this.miImagen.setBounds(1*32, 5*32, 32, 32); //PROVISORIO, SOLO PARA EL PROTOTIPO, PORQUE SE NECESITARIA PODER EXPLOTAR LAS PAREDES
	}
	
	//Operaciones
	
	/**
	 * M�todo que efectiviza el powerUp Fatality en el bomberman
	 * @param b de tipo Bomberman que representa el bomberman que piso el PowerUp
	 */
	
	public void empower (Bomberman b) {
		b.obtenerBomba().duplicarAlcance();
		this.miImagen.setVisible(false); //PROVISORIO PROTOTIPO, REALMENTE LA CELDA MANEJARIA LA IMAGEN
		System.out.println("Alcance x 2");
	}

}
