package Bomberman;

public abstract class PowerUp {
	
	//Activa el PowerUp en el bomberman
	
	//Atributos
	
	protected Posicion miPosicion;
	
	//Constructor
	
	public PowerUp (int x, int y) {
		
	}
	
	//Operaciones
	
	abstract public void powa (Bomberman B);
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
		
	
	
	
	
	 
	
	
	
	
	
	
}
