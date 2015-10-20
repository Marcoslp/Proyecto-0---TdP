package PowerUps;

import Personajes.Bomberman;



public class Bombality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Bombality (int x, int y) {
		
		super(x,y);
		
	}
	
	//Operaciones
	
	public void empower (Bomberman b) {
		b.aumentarCapacidadBombas();
	}

}
