package Grafica;

import javax.swing.ImageIcon;

/**
 * Clase que representa la gráfica del Rogulo
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 *
 */

public class RoguloGrafico extends ComponenteGrafico {

	public RoguloGrafico(int i, int x, int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/FichinIzquierda.gif")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/FichinDerecha.gif")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/FichinIzquierda.gif")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/FichinIzquierda.gif")), 3);
		this.establecerimagenActual(3);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
	}
	public void mover(int dir){
	}
}
