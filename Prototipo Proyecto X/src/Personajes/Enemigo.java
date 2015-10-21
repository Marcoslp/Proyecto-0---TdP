package Personajes;

import Grafica.ComponenteGrafico;
import L�gica.*;


public abstract class Enemigo {
	
	//Atributos
	protected ComponenteGrafico Graficos;
	protected int velocidad;
	protected boolean modoDios;
	protected Posicion miPosicion;
	protected Nivel miNivel;
	
	//Constructor
	
	protected Enemigo (int x, int y) {
		
		miPosicion = new Posicion(x,y);
		modoDios = false;
		
	}
	
	//Operaciones
	
	public abstract void morir ();
	
	public abstract void moverse();
	
	public void matar () {
		
		miNivel.matarBomberman ();
		
	}
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
	
	public boolean obtenerModoDios () {
		
		return modoDios;
		
	}
	
	public void establecerModoDios (boolean b) {
		
		modoDios = b;
		
	}
	
	public ComponenteGrafico obtenerGrafico(){
		return Graficos;
	}

}
