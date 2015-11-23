package Threads;
import Logica.*;
import Personajes.*;

public class ContadorMasacrality extends Thread {
	
	//Atributos
	
	protected int tiempo;
	private Nivel miNivel;
	protected Bomberman miBomberman;
	protected Celda celdaAux;
	
	//Constructor
	
	public ContadorMasacrality (int segundos, Bomberman b, Nivel miNivel) {
		tiempo = segundos *1000;
		miBomberman = b;
		this.miNivel = miNivel;
}
	
	//Operaciones

	public void run() {
			try {
				int bombas = miBomberman.obtenerCapacidadBombas();
				miBomberman.establecerModoDios(true);
				miBomberman.establecerCapacidadBombas(99999);
				Thread.sleep(tiempo);
				miBomberman.establecerModoDios(false);
				miBomberman.establecerCapacidadBombas(bombas);
				this.interrupt();
			}catch (InterruptedException e) { 
			}		
		}
}

