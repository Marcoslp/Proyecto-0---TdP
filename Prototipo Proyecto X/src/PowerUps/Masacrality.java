package PowerUps;

import Grafica.PowerUpGrafico;
import Logica.Celda;
import Personajes.Bomberman;
import Threads.ContadorBomba;
import Threads.*;
/**
 * Clase que modela la logica del powerUp Masacrality
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public class Masacrality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Masacrality (int x, int y, Celda miCelda) {
		super(x,y,miCelda);
		miGrafico = new PowerUpGrafico(3,x,y);
	}
	
	//Operaciones
	
	/**
	 * Método que efectiviza el powerUp Masacrality en el bomberman
	 * @param b de tipo Bomberman que representa el bomberman que piso el PowerUp
	 */
	
	public void empower(Bomberman b) {
		b.obtenerNivel().incrementarPuntuacion(50);
		ContadorMasacrality contador = new ContadorMasacrality(5,b,miNivel);
		contador.start();
		miGrafico.eliminarImagen();
	}
}