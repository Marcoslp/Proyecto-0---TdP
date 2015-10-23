package PowerUps;

import javax.swing.JLabel;

import Grafica.ComponenteGrafico;
import Logica.Celda;
import Logica.Nivel;
import Logica.Posicion;
import Personajes.Bomberman;


public abstract class PowerUp {
	
	//Activa el PowerUp en el bomberman
	
	//Atributos
	
	protected Nivel miNivel;
	protected Celda miCelda;
	protected Posicion miPosicion;
	protected JLabel miImagen;
	//Constructor
	
	protected PowerUp (int x, int y, Celda miCelda) {
		this.miCelda=miCelda;
		miPosicion = new Posicion(x,y);
	}
	
	//Operaciones
	
	public abstract void empower (Bomberman B);
	
	public Posicion obtenerPosicion () {
		return miPosicion;
	}
	
	public Nivel obtenerNivel(){
		return miNivel;		
	}
	
	public JLabel obtenerImagen(){
		return miImagen;
	}	
	
	
}
