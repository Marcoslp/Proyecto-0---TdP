package Personajes;

import Logica.*;
import Grafica.*;

/**
 * Clase que modela la lógica de los enemigos Sirius
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public class Sirius extends Enemigo {
	
	/*Sirius accede al Bomberman, pide su posición y calcula el camino más
	 *cercano a él, simulando que lo "persigue"
	 */
	
	//Atributos
	
	protected static final  int puntuacion = 50;
	
	//Constructor
	
	public Sirius (int x, int y,Nivel miNivel) {
		super(x,y, miNivel);
		Graficos = new SiriusGrafico(12,x,y);	
	}
	
	//Operaciones
	
	/**
	 * Método utilizado para cuando muere un Sirius
	 */ 
	
	public void morir () {
		miNivel.incrementarPuntuacion(puntuacion);
	}
	
	/**
	 *Método utilizado para cuando se mueve un Sirius
	 */
	
	public void moverse (){
		
	}
}
