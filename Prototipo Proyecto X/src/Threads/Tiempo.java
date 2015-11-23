package Threads;

import Grafica.GUI;
import Grafica.ManejadorGUI;
import Logica.Nivel;

public class Tiempo extends Thread {
	
	private int milisegundos;
	private int segundos;
	private int minutos;
	private int horas;
	private Nivel miNivel;

	public Tiempo(Nivel miNivel){
		milisegundos = 0;
		segundos = 0;
		minutos = 0;
		horas = 0;
		this.miNivel = miNivel;
	}
	
	public void run() {
		while(this.miNivel.obtenerBomberman() != null){ //MIENTRAS EL BOMBERMAN ESTE VIVO
			try {
				milisegundos++;
				Thread.sleep(20);
				if(milisegundos == 60){
					milisegundos = 0;
					segundos++;
				}
				if(segundos == 60){
					segundos = 0;
					minutos++;
				}
				if(minutos==60){
					minutos = 0;
					horas++;
				}
								
				
				String tiempoActual = "Tiempo : " + horas + " : " + minutos + " : " + segundos + " : "+milisegundos;
				this.miNivel.establecerMarcadorTiempo(tiempoActual);
				this.miNivel.obtenerManejadorGUI().establecerTiempo(tiempoActual);
				
			}catch (InterruptedException e) { 
			
			}	
		}
	}
	
}
