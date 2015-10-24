package Grafica;
import Personajes.*;
import Logica.*;

import javax.swing.ImageIcon;

/**
 * Clase que representa la gr�fica de una celda
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 *
 */
public class CeldaGrafica extends ComponenteGrafico {

	public CeldaGrafica(int i, int x, int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Piso.png")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/paredInd.jpg")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/paredDes.jpg")), 2);
		this.establecerimagenActual(0);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO, ALTO);
	}
	
	/**
	 * M�todo que recibe la gr�fica del bomberman en una celda
	 * @param b Bomberman , miPosicion Posicion
	 * @param miPosicion
	 */
	
	public void recibirBomberman(Bomberman b, Posicion miPosicion){
		b.obtenerGrafico().obtenerImagenActual().setBounds(miPosicion.obtenerX()*32,miPosicion.obtenerY()*32,b.obtenerGrafico().obtenerAncho(),b.obtenerGrafico().obtenerAlto());
		
	}
	/**
	 * M�todo que recibe la gr�fica de un enemigo en una celda
	 * @param e
	 * @param miPosicion
	 */

	public void recibirEnemigo(Enemigo e, Posicion miPosicion) {
		e.obtenerGrafico().obtenerImagenActual().setBounds(miPosicion.obtenerX()*32,miPosicion.obtenerY()*32,e.obtenerGrafico().obtenerAncho(),e.obtenerGrafico().obtenerAlto());
	}
}
