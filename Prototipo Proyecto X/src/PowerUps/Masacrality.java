package PowerUps;

import Personajes.Bomberman;


public class Masacrality extends PowerUp{
	
	//Atributos
	
	//Constructor
	
	public Masacrality (int x, int y) {
		
		super(x,y);
		
	}
	
	//Operaciones
	
	public void powa (Bomberman b) {
		b.establecerModoDios(true);
		int capacidadBombas = b.obtenerCapacidadBombas();
		b.establecerCapacidadBombas(9999);
		int tiempoINI = miNivel.obtenerMarcadorTiempo();
		int tiempoFIN = tiempoINI+5;
		while(tiempoINI != tiempoFIN){
			//No hace nada y espera 5 segundos, para no tener que hacer un thread nuevo
		}
		b.establecerCapacidadBombas(capacidadBombas);
		b.establecerModoDios(false);
	}

}