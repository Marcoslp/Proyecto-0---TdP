package PowerUps;

import Lógica.Nivel;
import Lógica.Posicion;
import Personajes.Bomberman;


public abstract class PowerUp {
	
	//Activa el PowerUp en el bomberman
	
	//Atributos
	
	protected Nivel miNivel;
	
	protected Posicion miPosicion;
	
	//Constructor
	
	public PowerUp (int x, int y) {
		
	}
	
	//Operaciones
	
	abstract public void powa (Bomberman B);
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
	
	public Nivel obtenerNivel(){
		return miNivel;		
	}
		
	
	
	
	
	 
	
	
	
	
	
	
}
