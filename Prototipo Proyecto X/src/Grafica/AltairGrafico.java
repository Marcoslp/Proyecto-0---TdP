package Grafica;

import javax.swing.ImageIcon;

public class AltairGrafico extends ComponenteGrafico{

	public AltairGrafico(int i,int x,int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ricky.jpg")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ricky.jpg")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ricky.jpg")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ricky.jpg")), 3);
		this.establecerimagenActual(3);
		this.obtenerImagenActual().setBounds(x*32, y*32, ALTO, ANCHO);
	}

}
