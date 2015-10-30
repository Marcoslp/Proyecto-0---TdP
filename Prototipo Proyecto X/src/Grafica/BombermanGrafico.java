package Grafica;

import javax.swing.ImageIcon;

/**
 * Clase que representa la gráfica del Bomberman
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 *
 */

public class BombermanGrafico extends ComponenteGrafico {

	public BombermanGrafico(int i, int x, int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/B-izquierda.gif")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/B-derecha.gif")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/B-arriba.gif")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/B-abajo.gif")), 3);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-centro1.png")), 4);
		this.establecerimagenActual(3);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
	}
	
}
