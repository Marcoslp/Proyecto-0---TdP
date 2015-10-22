package Personajes;

import Grafica.ComponenteGrafico;
import Grafica.RoguloGrafico;
import Lógica.*;

import java.util.Random;

import javax.swing.ImageIcon;

public class Rogulo extends Enemigo {
	
	//Atributos
	
	protected static final  int puntuacion = 15;
	
	//Constructor
	
	public Rogulo(int x, int y, Nivel miNivel) {
		super(x,y,miNivel);
		this.mDetener = false;
		Graficos = new RoguloGrafico(4,x,y);
	}
	
	//Operaciones
	
	public void morir () {
		miNivel.matarEnemigo(this);
		miNivel.incrementarPuntuacion(puntuacion);	
	}
			
	public void moverse (){
		Random r = new Random ();
		int i = r.nextInt(4);
		miNivel.moverEnemigo(this,i);
		Graficos.establecerimagenActual(i);
		
	}
}