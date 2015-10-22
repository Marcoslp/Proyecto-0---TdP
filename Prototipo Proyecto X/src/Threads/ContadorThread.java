package Threads;
import Lógica.Posicion;
import Personajes.Bomberman;

public class ContadorThread extends Thread {
	
	//Atributos
	
	protected int tiempo;
	protected Bomberman miBomberman;
	protected Posicion miPosicion;
	
	//Constructor
	
	public ContadorThread (int segundos, Bomberman b) {
		tiempo = segundos *1000;
		miBomberman = b;
		miPosicion = b.obtenerPosicion();
}
	
	//Operaciones

	public void run() {
			try {
				Thread.sleep(tiempo);
				miBomberman.obtenerBomba().explotar(miPosicion,miBomberman);
				this.interrupt ();
			} catch (InterruptedException e) { }		
		}
	}
