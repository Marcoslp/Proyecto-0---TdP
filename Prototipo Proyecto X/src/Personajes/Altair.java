package Personajes;
import java.util.Random;

import javax.swing.ImageIcon;

import Grafica.AltairGrafico;
import Grafica.ComponenteGrafico;
import Logica.*;

/**
 * Clase que modela la l�gica de un enemigo Altair
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 */

public class Altair extends Enemigo {
	
	//Atributos
	
	protected static final  int puntuacion = 20;
	
	//Constructor
	
	/*Estos son enemigos los que pueden
     *atravesar paredes destructibles */
	
	public Altair (int x, int y, Nivel miNivel) {
		super(x,y,miNivel);
		modoDios = true;      
		this.mDetener = false;
		velocidad=4;
		Graficos = new AltairGrafico(4,x,y);
		Graficos.establecerVelocidad(velocidad);
	}
	
	//Operaciones
	
	/**
	 * M�todo utlizado cuando un Altair muere
	 */
	
	public void morir () {
		miNivel.incrementarPuntuacion(puntuacion);
		this.destruir();
	}
	
	/**
	 * M�todo utilizado para mover un Altair
	 */
	
	public void moverse (){
		Random r = new Random ();
		int i = r.nextInt(4);
		miNivel.moverEnemigo(this,1);
	}
	
	

}
