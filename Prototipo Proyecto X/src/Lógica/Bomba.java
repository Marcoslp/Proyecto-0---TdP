package Lógica;

import Personajes.Bomberman;


public class Bomba {
	
	//Atributos
	
	protected int alcance;
	protected Bomberman miBomberman;
	protected Posicion miPosicion;
	
	//Constructor
	
	public Bomba () {
		alcance =1;
	}
	
	//Operaciones
	
	public void explotar (Posicion p, Bomberman b) {
		
	}
	
	public void duplicarAlcance () {
		
		alcance *= 2;
		
	}

	

}
