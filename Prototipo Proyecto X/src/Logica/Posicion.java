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
	 * M�todo que retorna si dos posiciones son iguales
	 * @param p de tipo Posicion que representa una de las posiciones a comparar
	 * @return Boolean que representa si las 2 posiciones son o no iguales
	 */
	
	public boolean equals (Posicion p) {
		
		return x == p.obtenerX() && y == p.obtenerY();
	}
	
	/**
	 * M�todo que devuelve la posicion en el eje x
	 * @return int que representa la posicion en el eje X
	 */
	
	public int obtenerX () {
		
		return x ;
		
	}
	/**
	 * M�todo que devuelve la posicion en el eje Y
	 * @return int que representa la posicion en el eje Y
	 */

	public int obtenerY () {
		
		return y;
		
	}
	/**
	 * M�todo que establece la posicion en el eje X
	 * @param X de tipo Int que representa la posicion a establecer
	 */
	
	public void establecerX (int X) {
		
		x = X;
		
	}
	
	/**
	 * M�todo que establece la posicion en el eje y
	 * @param Y de tipo int que representa la posicion a establecer
	 */
	
	public void establecerY (int Y) {
		
		y = Y;
		
	}
			

}
