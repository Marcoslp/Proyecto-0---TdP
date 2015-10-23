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
	
	/**
	 * Método que retorna si dos posiciones son iguales
	 * @param p de tipo Posicion que representa una de las posiciones a comparar
	 * @return Boolean que representa si las 2 posiciones son o no iguales
	 */
	
	public boolean equals (Posicion p) {
		
		return x == p.obtenerX() && y == p.obtenerY();
	}
	
	/**
	 * Método que devuelve la posicion en el eje x
	 * @return int que representa la posicion en el eje X
	 */
	
	public int obtenerX () {
		
		return x ;
		
	}
	/**
	 * Método que devuelve la posicion en el eje Y
	 * @return int que representa la posicion en el eje Y
	 */

	public int obtenerY () {
		
		return y;
		
	}
	/**
	 * Método que establece la posicion en el eje X
	 * @param X de tipo Int que representa la posicion a establecer
	 */
	
	public void establecerX (int X) {
		
		x = X;
		
	}
	
	/**
	 * Método que establece la posicion en el eje y
	 * @param Y de tipo int que representa la posicion a establecer
	 */
	
	public void establecerY (int Y) {
		
		y = Y;
		
	}
			

}
