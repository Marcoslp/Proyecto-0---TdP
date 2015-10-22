package Threads;
import L�gica.Bomba;
import L�gica.Nivel;
import L�gica.Posicion;
import Personajes.Bomberman;

public class ContadorBomba extends Thread {
	
	//Atributos
	
	protected int tiempo;
	private Nivel miNivel;
	protected Bomba miBomba;
	
	
	//Constructor
	
	public ContadorBomba (int segundos, Bomba b, Nivel miNivel) {
		tiempo = segundos *1000;
		miBomba = b;
		this.miNivel = miNivel;
}
	
	//Operaciones

	public void run() {
			try {
				
				Thread.sleep(tiempo);
				miNivel.explosion(miBomba);
				Thread.sleep(500);
				miNivel.restaurarPiso(miBomba);
				this.interrupt ();
			} catch (InterruptedException e) { }		
		}
}
