package Threads;
import Logica.Bomba;
import Logica.Celda;
import Logica.Nivel;
import Logica.Posicion;
import Personajes.Bomberman;
import PowerUps.*;


public class ContadorBomba extends Thread {
	
	//Atributos
	
	protected int tiempo;
	private Nivel miNivel;
	protected Bomba miBomba;
	protected Celda celdaAux;
	
	//Constructor
	
	public ContadorBomba (int segundos, Bomba b, Nivel miNivel) {
		tiempo = segundos *1000;
		miBomba = b;
		this.miNivel = miNivel;
		celdaAux= miNivel.obtenerCelda(miBomba.obtenerPosicion().obtenerX(), miBomba.obtenerPosicion().obtenerY());
		celdaAux.setBomba(miBomba);
}
	
	//Operaciones

	public void run() {
			try {
				Thread.sleep(tiempo);
				miNivel.explosion(miBomba);
				miNivel.obtenerBomberman().aumentarCapacidadBombas();
				Thread.sleep(500);
				miNivel.restaurarPiso(miBomba);
				celdaAux.setBomba(null);
				this.interrupt ();
			}catch (InterruptedException e) { 
			}		
		}
}

