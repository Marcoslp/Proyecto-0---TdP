package PowerUps;

import Lógica.Celda;
import Personajes.Bomberman;


public class Fatality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Fatality (int x, int y, Celda miCelda) {
		
		super(x,y,miCelda);
		
	}
	
	//Operaciones
	
	public void empower (Bomberman b) {
		b.obtenerBomba().duplicarAlcance();
	}

}
