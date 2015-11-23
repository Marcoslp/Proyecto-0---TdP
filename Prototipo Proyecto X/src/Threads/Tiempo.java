package Threads;

import Grafica.GUI;
import Grafica.ManejadorGUI;
import Logica.Nivel;

public class Tiempo extends Thread {
	
	private int segundos;
	private int minutos;
	private int horas;
	private Nivel miNivel;

	public Tiempo(Nivel miNivel){
		segundos = 0;
		minutos = 0;
		horas = 0;
		this.miNivel = miNivel;
	}
	
	public void run() {
		while(this.miNivel.obtenerBomberman() != null){ //MIENTRAS EL BOMBERMAN ESTE VIVO
			try {
				segundos++;
				Thread.sleep(1000);
				if(segundos == 60){
					segundos = 0;
					minutos++;
				}
				if(minutos == 60){
					minutos = 0;
					horas++;
				}
				String tiempoActual = "Tiempo : " + horas + " : " + minutos + " : " + segundos;
				this.miNivel.establecerMarcadorTiempo(tiempoActual);
				this.miNivel.obtenerManejadorGUI().establecerTiempo(tiempoActual);
				
			}catch (InterruptedException e) { 
			
			}	
		}
	}
	
}
