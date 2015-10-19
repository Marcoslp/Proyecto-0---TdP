package Personajes;
import Lógica.*;


public class Altair extends Enemigo {
	
	//Atributos
	
	//Constructor
	
	public Altair (int x, int y) {
		
		super(x,y);
		modoDios = true;       /*Estos son enemigos los que pueden
						        *atravesar paredes destructibles */
		
	}
	
	//Operaciones
	
	public void morir () {
		
		miNivel.matarEnemigo();
	}
	
	public void moverse (){
		
	}
	
	

}
