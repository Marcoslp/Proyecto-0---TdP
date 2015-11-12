package Logica;


import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase que modela la logica de una pared Destructible
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public class ParedDestructible extends Pared{
	
	//Atributos
	
	//Constructor
	
	public ParedDestructible (Celda c) {
		super(c);
	}
	
	//Operaciones
	
	/**
	 * Método que destruye la pared asociada a la celda
	 */
	
	public void destruirPared () {
		miCelda.obtenerNivel().incrementarPuntuacion(10);
		miCelda.eliminarPared();
	}
	
	/**
	 * Método que recibe un bomberman
	 * @param b de tipo Bomberman que representa el bomberman a recibir
	 */
	
	public void recibirBomberman(Bomberman b) {
		if(b.obtenerModoDios()){	//Lo elimina de la celda anterior y lo pone en la siguiente. Actualizando su posicion
			Celda celdaAnterior = miCelda.miNivel.obtenerCelda(b.obtenerPosicion().obtenerX(),b.obtenerPosicion().obtenerY());
			celdaAnterior.setBomberman(null);
			b.obtenerPosicion().establecerX(miCelda.obtenerPosicion().obtenerX());
			b.obtenerPosicion().establecerY(miCelda.obtenerPosicion().obtenerY());
			b.obtenerGrafico().obtenerImagenActual().setBounds(miCelda.obtenerPosicion().obtenerX()*32,miCelda.obtenerPosicion().obtenerY()*32,b.obtenerGrafico().obtenerAncho(),b.obtenerGrafico().obtenerAlto());
			this.miCelda.setBomberman(b);
			b.actualizarPosicionBomba();
		}
	}
	
	/**
	 * Método que recibe a un enemigo
	 * @param e de tipo Enemigo que representa el enemigo a recibir
	 */

	public void recibirEnemigo (Enemigo e) {
		if(e.obtenerModoDios()){   //Lo elimina de la celda anterior y lo pone en la siguiente. Actualizando su posicion
			Celda celdaAnterior = miCelda.miNivel.obtenerCelda(e.obtenerPosicion().obtenerX(),e.obtenerPosicion().obtenerY());
			celdaAnterior.eliminarEnemigo(e);
			e.obtenerPosicion().establecerX(miCelda.obtenerPosicion().obtenerX());
			e.obtenerPosicion().establecerY(miCelda.obtenerPosicion().obtenerY());
			e.obtenerGrafico().obtenerImagenActual().setBounds(miCelda.obtenerPosicion().obtenerX()*32,miCelda.obtenerPosicion().obtenerY()*32,e.obtenerGrafico().obtenerAncho(),e.obtenerGrafico().obtenerAlto());
			this.miCelda.añadirEnemigo(e);
		}
	}
	
	/**
	 * Método que establece la imagen de una pared Destructible
	 */

	public void establecerImagen() {
		miCelda.obtenerGraficos().establecerimagenActual(2);
	}
}
