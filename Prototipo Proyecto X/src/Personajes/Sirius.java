package Personajes;

import Logica.*;

/**
 * Clase que modela la l�gica de los enemigos Sirius
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 */

public class Sirius extends Enemigo {
	
	/*Sirius accede al Bomberman, pide su posici�n y calcula el camino m�s
	 *cercano a �l, simulando que lo "persigue"
	 */
	
	//Atributos
	
	protected static final  int puntuacion = 50;
	
	//Constructor
	
	public Sirius (int x, int y,Nivel miNivel) {
		
		super(x,y, miNivel);
		this.modoDios= true;
		
	}
	
	//Operaciones
	
	/**
	 * M�todo utilizado para cuando muere un Sirius
	 */ 
	
	public void morir () {
		miNivel.matarEnemigo(this);
		miNivel.incrementarPuntuacion(puntuacion);
	}
	
	/**
	 *M�todo utilizado para cuando se mueve un Sirius
	 */
	
	public void moverse (){
		
	}
}
