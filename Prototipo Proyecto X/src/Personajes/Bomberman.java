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
	
	public Bomberman (int x, int y, Nivel lvl){
		
		miPosicion.establecerX(x);
		miPosicion.establecerY(y);
		modoDios = false;
		velocidad=15;
		miNivel= lvl;
		miBomba= new Bomba();
	}
	
	//Operaciones
	
	public void moverIzquierda () {
		miNivel.moverBomberman(1);
	}
	
	public void moverDerecha () {
		miNivel.moverBomberman(2);
	}

	public void moverArriba () {
		miNivel.moverBomberman(3);
	}

	public void moverAbajo() {
		miNivel.moverBomberman(4);
	}

	public void ponerBomba () {
		miNivel.explosion(this.miPosicion, miBomba.obtenerAlcance());
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
