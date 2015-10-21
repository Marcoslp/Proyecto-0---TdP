package Lógica;

import Personajes.Bomberman;
import Personajes.Enemigo;


public class ParedDestructible extends Pared{
	
	//Atributos
	
	//Constructor
	
	public ParedDestructible (Celda c) {
		super(c);
	}
	
	//Operaciones
	
	public boolean destruirPared () {
		boolean seCumplio = true;
		miCelda.obtenerNivel().incrementarPuntuacion(10);
		miCelda.obtenerGraficos().establecerimagenActual(0); //MUESTRA EL PISO NUEVAMENTE DESPUES DE SER DESTRUIDA
		return seCumplio;
	}
	
	public void recibirBomberman (Bomberman b) {
		if(b.obtenerModoDios()){	//Lo elimina de la celda anterior y lo pone en la siguiente. Actualizando su posicion
			Celda celdaAnterior = miCelda.miNivel.obtenerCelda(b.obtenerPosicion().obtenerX(),b.obtenerPosicion().obtenerY());
			celdaAnterior.setBomberman(null);
			b.obtenerPosicion().establecerX(miCelda.obtenerPosicion().obtenerX());
			b.obtenerPosicion().establecerX(miCelda.obtenerPosicion().obtenerY());
			this.miCelda.setBomberman(b);
		}
	}

	public void recibirEnemigo (Enemigo e) {
		if(e.obtenerModoDios()){   //Lo elimina de la celda anterior y lo pone en la siguiente. Actualizando su posicion
			Celda celdaAnterior = miCelda.miNivel.obtenerCelda(e.obtenerPosicion().obtenerX(),e.obtenerPosicion().obtenerY());
			celdaAnterior.eliminarEnemigo(e);
			e.obtenerPosicion().establecerX(miCelda.obtenerPosicion().obtenerX());
			e.obtenerPosicion().establecerX(miCelda.obtenerPosicion().obtenerY());
			this.miCelda.añadirEnemigo(e);
		}
	}

	public void establecerImagen() {
		miCelda.obtenerGraficos().establecerimagenActual(2);		
	}
	
	

}
