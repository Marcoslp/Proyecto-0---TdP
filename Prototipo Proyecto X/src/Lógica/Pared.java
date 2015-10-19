package Lógica;

import Personajes.Bomberman;
import Personajes.Enemigo;


public abstract class Pared {
	
	//Atributos
	
	protected Celda miCelda;
	
	
	//Constructor
	
	public Pared () {
		
	}
	
	//Operaciones 	
	
	public abstract void recibirBomberman (Bomberman b);

	public abstract  void recibirEnemigo (Enemigo e, int direccion);
	
	public abstract boolean destruirPared () ;
	
	

}
