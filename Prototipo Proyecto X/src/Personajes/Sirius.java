package Personajes;

import Lógica.*;

public class Sirius extends Enemigo {
	
	/*Sirius accede al Bomberman, pide su posición y calcula el camino más
	 *cercano a él, simulando que lo "persigue"
	 */
	
	//Atributos
	
	protected static final  int puntuacion = 50;
	
	//Constructor
	
	public Sirius (int x, int y,Nivel miNivel) {
		
		super(x,y, miNivel);
		
	}
	
	//Operaciones
	
	public void morir () {
		miNivel.matarEnemigo(this);
		miNivel.incrementarPuntuacion(puntuacion);
	}
	
	public void moverse (){
		
	}
}
