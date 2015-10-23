package PowerUps;

import Logica.Celda;
import Personajes.Bomberman;



public class Bombality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Bombality (int x, int y, Celda miCelda) {
		
		super(x,y,miCelda);
		
	}
	//Operaciones
	
	public void empower (Bomberman b) {
		b.aumentarCapacidadBombas();
	}

}
