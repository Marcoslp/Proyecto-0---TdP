package Lógica;

import Personajes.Bomberman;
import Personajes.Enemigo;
import PowerUps.PowerUp;


public class Nivel {
	
	//Atributos
	
	protected int marcadorTiempo;
	protected int marcadorPuntos;
	protected Bomberman miBomberman;
	protected Enemigo[] misEnemigos;
	protected Celda [][] misCeldas;
	protected PowerUp [] misPowerUps;
	
	//Constructor
	
	public Nivel (Bomberman b, Enemigo[] e, PowerUp [] p) {
		
		miBomberman = b;
		misEnemigos = e;
		misPowerUps = p;
		
	}
	
	//Operaciones
	
	public void explosion (Posicion e, int alcance) {
		
	}
	
	public void incrementarPuntuacion (int x) {
		
		marcadorPuntos  += x;
		
	}
	
	public void bombermanPisoPowerUp () {
		
	}
	
	public Bomberman obtenerBomberman () {
		
		return miBomberman;
		
	}
	
	public void moverBomberman (int Direccion) {
		
	}
	
	public void MoverEnemigo (Enemigo e) {
		
	}
}
