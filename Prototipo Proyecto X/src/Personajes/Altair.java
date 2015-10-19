package Personajes;
import Lógica.*;


public class Altair extends Enemigo {
	
	//Atributos
	
	protected static final  int puntuacion = 20;
	
	//Constructor
	
	/*Estos son enemigos los que pueden
     *atravesar paredes destructibles */
	
	public Altair (int x, int y) {
		
		super(x,y);
		modoDios = true;      
		
	}
	
	//Operaciones
	
	public void morir () {
		
		miNivel.matarEnemigo(this);
		miNivel.incrementarPuntuacion(puntuacion);
	}
	
	public void moverse (){
		
	}
	
	

}
