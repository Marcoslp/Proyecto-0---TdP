package Logica;

import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase que modela la l�gica de una pared
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
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
	 * M�todo que recibe un bomberman
	 * @param b de tipo Bomberman que representa el bomberman a recibir
	 */
	
	public abstract void recibirBomberman (Bomberman b,int dir);
	
	/**
	 * M�todo que recibe un enemigo
	 * @param e de tipo Enemigo que representa el enemigo a recibir
	 */

	public abstract  void recibirEnemigo (Enemigo e,int dir);
	
	/**
	 * M�todo que destruye una pared
	 */
	
	public abstract void destruirPared () ;
	
	/**
	 * M�todo que establece la imagen de una pared
	 */

	public abstract void establecerImagen() ;
	

}
