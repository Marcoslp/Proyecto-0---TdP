package PowerUps;

import L�gica.Nivel;
import L�gica.Posicion;
import Personajes.Bomberman;


public abstract class PowerUp {
	
	//Activa el PowerUp en el bomberman
	
	//Atributos
	
	protected Nivel miNivel;
	
	protected Posicion miPosicion;
	
	//Constructor
	
	protected PowerUp (int x, int y) {
		miPosicion = new Posicion(x,y);
	}
	
	//Operaciones
	
	public abstract void empower (Bomberman B);
	
	public Posicion obtenerPosicion () {
		return miPosicion;
	}
	
	public Nivel obtenerNivel(){
		return miNivel;		
	}
		
	
	
	
	
	 
	
	
	
	
	
	
}
