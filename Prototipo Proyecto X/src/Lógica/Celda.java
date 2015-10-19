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
	protected Posicion miPosicion;
	protected Nivel miNivel;
	
	
	//Constructor
	
	public Celda (Pared p) {
		
		miPared = p;
	}
	
	public Celda(){
		
	}
	
	//Operaciones
	
	// Recibir Bomberman cambio, ahora tiene un parámetro
	public void recibirBomberman(Bomberman b) {
		if(miPared == null){
			Celda celdaAnterior = miNivel.obtenerCelda(b.obtenerPosicion().obtenerX(),b.obtenerPosicion().obtenerY());
			celdaAnterior.setBomberman(null);
			b.obtenerPosicion().establecerX(miPosicion.obtenerX());
			b.obtenerPosicion().establecerY(miPosicion.obtenerY());
			miBomberman=b;
		}
		else{
			miPared.recibirBomberman(b);
		}
	}
	
	public void setBomberman(Bomberman b){
		miBomberman= b;
	}

	public void recibirEnemigo (Enemigo e, int direccion) {
		
	}
	
	public Pared obtenerPared(){
		return miPared;
	}
	
	public void establecerPared(Pared p){
		miPared=p;
	}
	
	public Posicion obtenerPosicion(){
		return miPosicion;
	}

	
}
