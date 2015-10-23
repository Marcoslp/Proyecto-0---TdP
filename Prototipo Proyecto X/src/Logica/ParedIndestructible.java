package Logica;


import Personajes.Bomberman;
import Personajes.Enemigo;


public class ParedIndestructible extends Pared{
	
	//Atributos
	
	//Constructor
	
	public ParedIndestructible (Celda c) {
		super(c);
	}
	
	//Operaciones
	
	public void destruirPared () {
		miCelda.obtenerGraficos().establecerimagenActual(1);
	}
	
	public void recibirBomberman (Bomberman b) {
		//DEBERIA CAMBIAR LA IMAGEN DEL BOMBERMAN
	}

	public void recibirEnemigo (Enemigo e) {
		//DEBERIA CAMBIAR LA IMAGEN DEL ENEMIGO
	}

	
	public void establecerImagen() {
		
		miCelda.obtenerGraficos().establecerimagenActual(1); //ELIGE LA IMAGEN
		//miCelda.obtenerGraficos().obtenerImagenActual().setBounds(miCelda.obtenerPosicion().obtenerX()*32, miCelda.obtenerPosicion().obtenerY()*32, miCelda.obtenerGraficos().obtenerAncho(), miCelda.obtenerGraficos().obtenerAlto());
		
	}
}