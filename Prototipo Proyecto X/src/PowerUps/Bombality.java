package PowerUps;

import Logica.Celda;
import Personajes.Bomberman;

/**
 * Clase que modela la logica del powerUp Bombality
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 */

public class Bombality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Bombality (int x, int y, Celda miCelda) {
		
		super(x,y,miCelda);
		
	}
	//Operaciones
	
	/**
	 * M�todo que efectiviza el powerUp Bombality en el bomberman
	 * @param b de tipo Bomberman que representa el bomberman que piso el PowerUp
	 */
	
	public void empower (Bomberman b) {
		b.aumentarCapacidadBombas();
	}

}
