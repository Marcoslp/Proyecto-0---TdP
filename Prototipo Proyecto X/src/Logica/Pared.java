package Logica;

import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase que modela la lógica de una pared
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public abstract class Pared {
	
	//Atributos
	
	protected Celda miCelda;
	
	
	//Constructor
	
	protected Pared (Celda miCelda) {
		this.miCelda = miCelda;
	}
	
	//Operaciones 	
	
	/**
	 * Método que recibe un bomberman
	 * @param b de tipo Bomberman que representa el bomberman a recibir
	 */
	
	public abstract void recibirBomberman (Bomberman b,int dir);
	
	/**
	 * Método que recibe un enemigo
	 * @param e de tipo Enemigo que representa el enemigo a recibir
	 */

	public abstract  void recibirEnemigo (Enemigo e,int dir);
	
	/**
	 * Método que destruye una pared
	 */
	
	public abstract void destruirPared () ;
	
	/**
	 * Método que establece la imagen de una pared
	 */

	public abstract void establecerImagen() ;
	

}
