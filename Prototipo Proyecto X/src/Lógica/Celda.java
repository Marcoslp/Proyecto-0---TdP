package L�gica;


public abstract class Celda {
	
	/*La celda contiene la colecci�n de Enemigos que est�n parados sobre ella,
	 *el Bomberman y si hay, un PowerUp.
	 */
	
	//Atributos
	
	protected Bomberman miBomberman;
	protected Pared miPared;
	protected PowerUp [] misPowerUps;
	protected Enemigo [] misEnemigos;
	
	
	//Constructor
	
	protected Celda (Pared p) {
		
		miPared = p;
	}
	
	//Operaciones
	
	public void recibirBomberman (Bomberman b, int direccion) {
		
	}

	public void recibirEnemigo (Enemigo e, int direccion) {
		
	}

	
}
