package Lógica;

import Personajes.Bomberman;


public class Bomba {
	
	//Atributos
	
	protected static int alcance = 1;
	protected Bomberman miBomberman;
	protected Posicion miPosicion;
	
	//Constructor
	
	public Bomba (Bomberman b) {
		miBomberman = b;
		miPosicion.establecerX(miBomberman.obtenerPosicion().obtenerX());
		miPosicion.establecerY(miBomberman.obtenerPosicion().obtenerY());
	}
	
	//Operaciones
	
	public void explotar (Posicion p, Bomberman b) {
		
	}
	
	public void duplicarAlcance () {
		
		alcance *= 2;
		
	}

	public int obtenerAlcance() {
		
		return alcance;
		
	}
	

	

}
