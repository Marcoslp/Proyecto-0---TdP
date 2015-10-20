package PowerUps;

import Personajes.Bomberman;


public class SpeedUp extends PowerUp  {
	
	//Atributos
	
	//Constructor
	
	public SpeedUp (int x, int y) {
		
		super(x,y);
		
	}
	
	//Operaciones
	
	public void empower (Bomberman b) {
		b.DuplicarVelocidad();
	}

}
