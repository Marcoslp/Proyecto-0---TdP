package Logica;

import javax.swing.ImageIcon;

import Grafica.BombaGrafica;
import Grafica.ComponenteGrafico;
import Personajes.Bomberman;

/**
 * Clase que modela la bomba l�gica
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 *
 */
public class Bomba {
	
	//Atributos
	protected ComponenteGrafico Graficos;
	protected static int alcance = 1;
	protected Bomberman miBomberman;
	protected Posicion miPosicion;
	
	//Constructor
	
	public Bomba (Bomberman b) {
		miBomberman = b;
		miPosicion = new Posicion(miBomberman.obtenerPosicion().obtenerX(),miBomberman.obtenerPosicion().obtenerY());
		
		int Px = this.miPosicion.obtenerX();
		int Py = this.miPosicion.obtenerY();
		//INICIALIZO LA PARTE GRAFICA
		Graficos = new BombaGrafica(4,Px,Py);
		
	}
	
	//Operaciones
	
	//ver
	public void explotar (Posicion p, Bomberman b) {
		
	}
	/**
	 * M�todo que duplica el alcance de una bomba
	 */
	
	public void duplicarAlcance () {
		alcance *= 2;		
	}
	
	/**
	 * M�todo que establece el alcance de una bomba
	 * @param i	de tipo int, que representa el alcance
	 */
	
	public void establecerAlcance(int i){
		alcance = i;
	}
	
	/**
	 * M�todo que devuelve el alcance de una bomba
	 * @return int que representa el alcance
	 */
	public int obtenerAlcance() {
		return alcance;
	}
	
	/**
	 * Metodo que devuelve el componente grafico de una bomba
	 * @return ComponenteGrafico que representa el grafico
	 */
	
	public ComponenteGrafico obtenerGraficos(){
		return Graficos;
	}
	
	/**
	 * M�todo que devuelve la posicion de la bomba
	 * @return Posicion que representa la posicion
	 */
	
	public Posicion obtenerPosicion(){
		return this.miPosicion;
	}

	/**
	 * M�todo que clona las bombas, utilizado para colocarlas
	 * @return Bomba que representa la bomba clonada
	 */
	public Bomba clonar() {
		Bomba devolver = new Bomba(miBomberman);
		devolver.obtenerPosicion().establecerX(miPosicion.obtenerX());
		devolver.obtenerPosicion().establecerY(miPosicion.obtenerY());
		devolver.establecerAlcance(this.obtenerAlcance());
		return devolver;
	}
	

	

}
