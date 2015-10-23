package Personajes;

import Grafica.ComponenteGrafico;
import Logica.*;

/**
 * Clase que modela la logica de los enemigos
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 */

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
	
	/**
	 * M�todo que se utiliza cuando muere un enemigo
	 */
	
	public abstract void morir ();
	
	/**
	 * M�todo que se utiliza para mover un enemigo
	 */
	
	public abstract void moverse();
	
	/**
	 * M�todo que se utiliza cuando un enemigo mata al bomberman :(
	 */
	
	public void matar () {
		
		miNivel.matarBomberman ();
		
	}
	
	/**
	 * M�todo que devuelve la posicion asociada al enemigo
	 * @return Posicion que representa la posicion a devolver
	 */
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
	/**
	 * M�todo que devuelve si el enemigo esta o no en modo dios
	 * @return Boolean que representa el modo dios a devolver
	 */
	
	public boolean obtenerModoDios () {
		return modoDios;
	}
	
	/**
	 * M�todo que establece el modo dios del Enemigo
	 * @param b de tipo Boolean que representa el modo dios a establecer
	 */
	
	public void establecerModoDios (boolean b) {
		modoDios = b;
	}
	
	/**
	 * M�todo que devuelve el grafico de un enemig
	 * @return ComponenteGrafico que representa el grafico de un enemigo
	 */
	
	public ComponenteGrafico obtenerGrafico(){
		return Graficos;
	}
	
	/**
	 * M�todo que maneja el comportamiento de un enemigo
	 */
	
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.mDetener){
			try {
				Thread.sleep(1000);
				this.moverse();				
			} catch (InterruptedException e) { }
		}
	}
	
	/**
	 * M�todo utilizado para cuando muere un enemigo
	 */
	
	public void destruir() {
		this.mDetener = true;
	}
}
