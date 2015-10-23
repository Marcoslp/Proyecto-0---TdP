package Logica;

import Personajes.Bomberman;
import Personajes.Enemigo;


public abstract class Pared {
	
	//Atributos
	
	protected Celda miCelda;
	
	
	//Constructor
	
	protected Pared (Celda miCelda) {
		this.miCelda = miCelda;
	}
	
	//Operaciones 	
	
	public abstract void recibirBomberman (Bomberman b);

	public abstract  void recibirEnemigo (Enemigo e);
	
	public abstract void destruirPared () ;

	public abstract void establecerImagen() ;
	

}
