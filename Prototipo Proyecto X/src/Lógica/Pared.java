package Lógica;

import Personajes.Bomberman;
import Personajes.Enemigo;


public abstract class Pared {
	
	//Atributos
	
	protected Celda miCelda;
	
	
	//Constructor
	
	protected Pared () {
		
	}
	
	//Operaciones 	
	
	public abstract void recibirBomberman (Bomberman b);

	public abstract  void recibirEnemigo (Enemigo e);
	
	public abstract boolean destruirPared () ;

	public abstract void establecerImagen() ;
	

}
