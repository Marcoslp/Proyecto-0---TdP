package Personajes;

import Grafica.ComponenteGrafico;
import Grafica.RoguloGrafico;
import Logica.*;

import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Clase que modela la logica de los enemigos Rogulos
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public class Rogulo extends Enemigo {
	
	//Atributos
	
	protected static final  int puntuacion = 15;
	
	//Constructor
	
	public Rogulo(int x, int y, Nivel miNivel) {
		super(x,y,miNivel);
		this.mDetener = false;
		velocidad=4;
		Graficos = new RoguloGrafico(4,x,y);
		Graficos.establecerVelocidad(velocidad);
	}
	
	//Operaciones
	
	/**
	 * Método que se utiliza cuando muere un Rogulo
	 */
	
	public void morir () {
		System.out.println("holis");
		miNivel.incrementarPuntuacion(puntuacion);	
		this.destruir();
	}
	
	/**
	 * Método que se utiliza para mover un Rogulo
	 */
			
	public void moverse (){
		Random r = new Random ();
		int i = r.nextInt(4);
		miNivel.moverEnemigo(this,i);
	}
}