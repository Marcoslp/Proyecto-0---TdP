package Bomberman;

public abstract class Enemigo {
	
	//Atributos
	
	protected int velocidad;
	protected boolean modoDios;
	protected Posicion miPosicion;
	protected Nivel miNivel;
	
	//Constructor
	
	protected Enemigo (int x, int y) {
		
		miPosicion.establecerX(x);
		miPosicion.establecerY(y);
		modoDios = false;
		
	}
	
	//Operaciones
	
	public abstract void morir ();
	
	public abstract void moverse();
	
	public void matar () {
		
	}
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
	
	public boolean obtenerModoDios () {
		
		return modoDios;
		
	}
	
	public void establecerModoDios (boolean b) {
		
		modoDios = b;
		
	}

}
