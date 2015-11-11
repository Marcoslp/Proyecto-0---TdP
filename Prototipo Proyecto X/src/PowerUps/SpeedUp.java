package PowerUps;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.PowerUpGrafico;
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
		miGrafico = new PowerUpGrafico(0,x,y);
	}
	
	//Operaciones
	
	/**
	 * Método que efectiviza el powerUp SpeedUp en el bomberman
	 * @param b de tipo Bomberman que representa el bomberman que piso el PowerUp
	 */
	
	public void empower (Bomberman b) {
		b.DuplicarVelocidad();
		miGrafico.eliminarImagen();
		System.out.println("Velocidad x 2");
	}

}
