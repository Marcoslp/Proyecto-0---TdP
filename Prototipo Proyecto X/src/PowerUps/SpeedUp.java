package PowerUps;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Celda;
import Personajes.Bomberman;

/**
 * Clase que modela la logica del powerUp SpeedUp
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public class SpeedUp extends PowerUp  {
	
	//Atributos
	
	//Constructor
	
	public SpeedUp (int x, int y, Celda miCelda) {
		super(x,y,miCelda);
		this.miImagen = new JLabel (new ImageIcon(this.getClass().getResource("/Imagenes/SpeedUp.png")));
		this.miImagen.setBounds(1*32, 2*32, 32, 32); //PROVISORIO, SOLO PARA EL PROTOTIPO, PORQUE SE NECESITARIA PODER EXPLOTAR LAS PAREDES
													//POSICION TOTALMENTE ARBITRARIA
	}
	
	//Operaciones
	
	/**
	 * Método que efectiviza el powerUp SpeedUp en el bomberman
	 * @param b de tipo Bomberman que representa el bomberman que piso el PowerUp
	 */
	
	public void empower (Bomberman b) {
		b.DuplicarVelocidad();
		this.miImagen.setVisible(false); //PROVISORIO PROTOTIPO, REALMENTE LA CELDA MANEJARIA LA IMAGEN ---> PREGUNTAR  SI ESTA BIEN
										 //SINO DEBERIA PASAR LA GUI POR PARAMETRO D:
		System.out.println("Velocidad x 2");
	}

}
