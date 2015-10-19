package Lógica;

import Personajes.Bomberman;
import Personajes.Enemigo;


public class ParedDestructible extends Pared{
	
	//Atributos
	
	//Constructor
	
	public ParedDestructible () {
		
	}
	
	//Operaciones
	
	public boolean destruirPared () {
		
		boolean seCumplio = false;
		
		return seCumplio;
	}
	
	public void recibirBomberman (Bomberman b) {
		if(b.obtenerModoDios()){
			Celda celdaAnterior = miCelda.miNivel.obtenerCelda(b.obtenerPosicion().obtenerX(),b.obtenerPosicion().obtenerY());
			celdaAnterior.setBomberman(null);
			b.obtenerPosicion().establecerX(miCelda.obtenerPosicion().obtenerX());
			b.obtenerPosicion().establecerX(miCelda.obtenerPosicion().obtenerY());
		}
	}

	public void recibirEnemigo (Enemigo e, int direccion) {
		
	}
	
	

}
