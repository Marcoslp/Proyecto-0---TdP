package PowerUps;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Celda;
import Personajes.Bomberman;
import Grafica.*;

/**
 * Clase que modela la logica del powerUp Fatality
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public class Fatality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Fatality (int x, int y, Celda miCelda) {
		super(x,y,miCelda);
		miGrafico = new PowerUpGrafico(1,x,y);
	}
	
	//Operaciones
	
	/**
	 * Método que efectiviza el powerUp Fatality en el bomberman
	 * @param b de tipo Bomberman que representa el bomberman que piso el PowerUp
	 */
	
	public void empower (Bomberman b) {
		b.obtenerBomba().duplicarAlcance();
		b.obtenerNivel().incrementarPuntuacion(35);
		miGrafico.eliminarImagen(); //PROVISORIO PROTOTIPO, REALMENTE LA CELDA MANEJARIA LA IMAGEN
		System.out.println("Alcance x 2");
	}

}
