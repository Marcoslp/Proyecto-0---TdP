package Threads;

import Personajes.Enemigo;

public class EnemigoThread extends Thread {
	
	private Enemigo eLogica;
	
	private volatile boolean eDetener;
	
	public EnemigoThread(Enemigo logica) {
		this.eLogica  = logica;
		this.eDetener = false;
	}
	
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.eDetener){
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				Thread.sleep(1000);
				
				// Realizo el movimiento
				this.eLogica.moverse();
			} catch (InterruptedException e) { }
		}
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt(); 
		
		// Seteamos el flag para detener su ejecución.
		this.eDetener = true;
	}
	
	public void destruir() {
		// Detengo la ejecucion del hilo.
		this.detener();
		
		// Notificamos a la logica que este hilo se destruyo.
		this.eLogica.morir();
	}
	
}
