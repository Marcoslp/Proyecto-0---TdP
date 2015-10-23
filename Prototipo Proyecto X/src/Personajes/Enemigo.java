package Personajes;

import Grafica.ComponenteGrafico;
import Logica.*;

/**
 * Clase que modela la logica de los enemigos
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
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
	 * Método que se utiliza cuando muere un enemigo
	 */
	
	public abstract void morir ();
	
	/**
	 * Método que se utiliza para mover un enemigo
	 */
	
	public abstract void moverse();
	
	/**
	 * Método que se utiliza cuando un enemigo mata al bomberman :(
	 */
	
	public void matar () {
		
		miNivel.matarBomberman ();
		
	}
	
	/**
	 * Método que devuelve la posicion asociada al enemigo
	 * @return Posicion que representa la posicion a devolver
	 */
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
	/**
	 * Método que devuelve si el enemigo esta o no en modo dios
	 * @return Boolean que representa el modo dios a devolver
	 */
	
	public boolean obtenerModoDios () {
		return modoDios;
	}
	
	/**
	 * Método que establece el modo dios del Enemigo
	 * @param b de tipo Boolean que representa el modo dios a establecer
	 */
	
	public void establecerModoDios (boolean b) {
		modoDios = b;
	}
	
	/**
	 * Método que devuelve el grafico de un enemig
	 * @return ComponenteGrafico que representa el grafico de un enemigo
	 */
	
	public ComponenteGrafico obtenerGrafico(){
		return Graficos;
	}
	
	/**
	 * Método que maneja el comportamiento de un enemigo
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
	 * Método utilizado para cuando muere un enemigo
	 */
	
	public void destruir() {
		this.mDetener = true;
	}
}
