package Personajes;

import Lógica.*;
import PowerUps.PowerUp;

public class Bomberman {
	
	//Atributos
	
	protected int velocidad;
	protected boolean modoDios;
	protected int capacidadBombas;
	protected Bomba miBomba;
	protected Nivel miNivel;
	protected Posicion miPosicion;
	
	
	//Constructor
	
	public Bomberman (int x, int y) {
		
		miPosicion.establecerX(x);
		miPosicion.establecerY(y);
		modoDios = false;
		
	}
	
	//Operaciones
	
	public void moverIzquierda () {
		
	}
	
	public void moverDerecha () {
		
	}

	public void moverArriba () {
		
	}

	public void moverAbajo() {
		
	}

	public void ponerBomba () {
		
	}

	public void morir () {
		
		miNivel.matarBomberman();
		
	}
	
	public void añadirPowerUp (PowerUp p) {
		
	}
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
	
	public Nivel obtenerNivel () {
		
		return miNivel;
		
	}
	
	public void DuplicarVelocidad () {
		
		velocidad *= 2;
		
	}
	
	public void establecerModoDios (boolean b) {
		
		modoDios = b;

	}
	
	public boolean obtenerModoDios () {
		
		return modoDios;
		
	}
}
