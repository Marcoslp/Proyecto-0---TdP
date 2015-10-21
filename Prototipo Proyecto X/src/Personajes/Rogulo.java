package Personajes;

import Lógica.*;
import java.util.Random;

public class Rogulo extends Enemigo {
	
	//Atributos
	
	protected static final  int puntuacion = 15;
	
	//Constructor
	
	public Rogulo(int x, int y) {
		super(x,y);
	}
	
	//Operaciones
	
	public void morir () {
		miNivel.matarEnemigo(this);
		miNivel.incrementarPuntuacion(puntuacion);	
	}
	
	public void moverse (){
		Random r = new Random ();
		miNivel.moverEnemigo(this,r.nextInt(4));
	}
}