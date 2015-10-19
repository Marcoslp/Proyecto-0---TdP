package Personajes;

import L�gica.*;

public class Sirius extends Enemigo {
	
	/*Sirius accede al Bomberman, pide su posici�n y calcula el camino m�s
	 *cercano a �l, simulando que lo "persigue"
	 */
	
	//Atributos
	
	protected static final  int puntuacion = 50;
	
	//Constructor
	
	public Sirius (int x, int y) {
		
		super(x,y);
		
	}
	
	//Operaciones
	
	public void morir () {
		miNivel.matarEnemigo(this);
		miNivel.incrementarPuntuacion(puntuacion);
	}
	
	public void moverse (){
		
	}
}
