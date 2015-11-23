package Grafica;

import javax.swing.ImageIcon;

/**
 * Clase que representa la gráfica del Altair
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 *
 */
public class SiriusGrafico extends ComponenteGrafico{

	public SiriusGrafico(int i,int x,int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/altair-izquierda.gif")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/altair-derecha.gif")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/altair-arriba.png")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/altair-abajo.png")), 3);
		this.establecerimagenActual(3);
		this.obtenerImagenActual().setBounds(x*32, y*32, ALTO, ANCHO);
		
		miPosY=x*32;
		miPosY=y*32;
	}
	
	public void mover(int dir){
	}
}