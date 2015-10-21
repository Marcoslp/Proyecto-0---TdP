package Personajes;

import Grafica.ComponenteGrafico;
import Lógica.*;


public abstract class Enemigo extends Thread {
	
	//Atributos
	protected volatile boolean mDetener;
	protected ComponenteGrafico Graficos;
	protected int velocidad;
	protected boolean modoDios;
	protected Posicion miPosicion;
	protected Nivel miNivel;
	
	//Constructor
	
	protected Enemigo (int x, int y, Nivel MiNivel) {
		
		miPosicion = new Posicion(x,y);
		modoDios = false;
		this.miNivel = MiNivel;
		
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
