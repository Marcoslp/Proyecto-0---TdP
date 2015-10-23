package Grafica;
import Logica.Bomba;
import Logica.Celda;
import Personajes.*;
import PowerUps.PowerUp;

public class ManejadorGUI {
	
	protected GUI miGui;
	
	public ManejadorGUI(GUI gui){
		miGui=gui;
	}
	
	public void añadirBomberman(Bomberman b){
		miGui.add(b.obtenerGrafico().obtenerImagenActual());
		//PARA PONER EL LABEL DEL BOMBERMAN POR ENCIMA DEL PISO
		miGui.getContentPane().setComponentZOrder(b.obtenerGrafico().obtenerImagenActual(), 0);
	}

	public void añadirCelda(Celda celda) {
		miGui.add(celda.obtenerGraficos().obtenerImagenActual());
		miGui.getContentPane().setComponentZOrder(celda.obtenerGraficos().obtenerImagenActual(), 1);
		
	}

	public void añadirEnemigo(Enemigo enemigo) {
		miGui.add(enemigo.obtenerGrafico().obtenerImagenActual());
		miGui.getContentPane().setComponentZOrder(enemigo.obtenerGrafico().obtenerImagenActual(), 0);
		
	}

	public void añadirPowerUp(PowerUp powerUp) {
		miGui.add(powerUp.obtenerImagen());
		//PARA PONER EL LABEL DEL POWERUP POR ENCIMA DEL PISO
	    miGui.getContentPane().setComponentZOrder(powerUp.obtenerImagen(), 0); 
	}
	
	public void añadirBombaClonada(Bomba bomba){
		bomba.obtenerGraficos().obtenerImagenActual().setBounds(bomba.obtenerPosicion().obtenerX()*32, bomba.obtenerPosicion().obtenerY()*32,32,32);
		miGui.add(bomba.obtenerGraficos().obtenerImagenActual());
		miGui.getContentPane().setComponentZOrder(bomba.obtenerGraficos().obtenerImagenActual(), 1);
	}
}
