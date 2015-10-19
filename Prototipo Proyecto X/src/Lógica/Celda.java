package Lógica;

import Personajes.Bomberman;
import Personajes.Enemigo;
import PowerUps.PowerUp;


public class Celda {
	
	/*La celda contiene la colección de Enemigos que están parados sobre ella,
	 *el Bomberman y si hay, un PowerUp.
	 */
	
	//Atributos
	
	protected Bomberman miBomberman;
	protected Pared miPared;
	protected PowerUp [] misPowerUps;
	protected Enemigo [] misEnemigos;
	
	
	//Constructor
	
	public Celda (Pared p) {
		
		miPared = p;
	}
	
	protected Celda(){
		
	}
	
	//Operaciones
	
	public void recibirBomberman (Bomberman b, int direccion) {
		
	}
	
	public void setBomberman(Bomberman b){
		miBomberman= b;
	}

	public void recibirEnemigo (Enemigo e, int direccion) {
		
	}

	
}
