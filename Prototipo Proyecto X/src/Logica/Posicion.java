package Logica;

public class Posicion {
	
	//Atributos
	
	protected int x;
	protected int y;
	
	//Constructor
	
	public Posicion (int X, int Y) {
		
		x = X;
		y = Y;
		
	}
	
	//Operaciones
	
	public boolean equals (Posicion p) {
		
		return x == p.obtenerX() && y == p.obtenerY();
	}
	
	public int obtenerX () {
		
		return x ;
		
	}

	public int obtenerY () {
		
		return y;
		
	}
	
	public void establecerX (int X) {
		
		x = X;
		
	}
	
	public void establecerY (int Y) {
		
		y = Y;
		
	}
			

}
