package Lógica;


public abstract class Celda {
	
	/*La celda contiene la colección de Enemigos que están parados sobre ella,
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
