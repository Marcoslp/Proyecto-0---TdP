package Personajes;

import Grafica.ComponenteGrafico;
import L�gica.*;


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
	
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.mDetener){
			try {
				Thread.sleep(1000);
				this.moverse();				
			} catch (InterruptedException e) { }
		}
	}
	
	
	public void destruir() {
		this.mDetener = true;
	}
}
