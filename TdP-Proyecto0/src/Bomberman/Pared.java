package Bomberman;

public abstract class Pared {
	
	//Atributos
	
	protected Celda miCelda;
	
	
	//Constructor
	
	public Pared () {
		
	}
	
	//Operaciones 	
	
	public abstract void recibirBomberman (Bomberman b, int direccion);

	public abstract  void recibirEnemigo (Enemigo e, int direccion);
	
	public abstract boolean destruirPared () ;
	
	

}
