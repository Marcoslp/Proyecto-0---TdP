package PowerUps;

import javax.swing.JLabel;

import Grafica.ComponenteGrafico;
import Logica.Celda;
import Logica.Nivel;
import Logica.Posicion;
import Personajes.Bomberman;
import Grafica.*;

/**
 * Clase que modela la logica de los PowerUps
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 */

public abstract class PowerUp {
	
	//Activa el PowerUp en el bomberman
	
	//Atributos
	
	protected Nivel miNivel;
	protected Celda miCelda;
	protected Posicion miPosicion;
	protected ComponenteGrafico miGrafico;
	//Constructor
	
	protected PowerUp (int x, int y, Celda miCelda) {
		this.miCelda = miCelda;
		miPosicion = new Posicion(x,y);
	}
	
	//Operaciones
	
	/**
	 * M�todo que efectiviza el powerUp en el bomberman
	 * @param b de tipo Bomberman que representa el bomberman que piso el PowerUp
	 */
	
	public abstract void empower (Bomberman b);
	
	/**
	 * M�todo que devuelve la posicion asociada al powerUp
	 * @return Posicion que representa la posicion a devolver
	 */
	
	public Posicion obtenerPosicion () {
		return miPosicion;
	}
	
	/**
	 * M�todo que representa la imagen del powerUp
	 * @return JLabel que representa la imagen a devolver
	 */
	
	public ComponenteGrafico obtenerGrafico(){
		return miGrafico;
	}	
	
	
}
