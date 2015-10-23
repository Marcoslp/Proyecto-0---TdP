package Grafica;

import javax.swing.ImageIcon;

public class RoguloGrafico extends ComponenteGrafico {

	public RoguloGrafico(int i, int x, int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/rogulo-izq.png")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/rogulo-Der.png")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/rogulo-arriba.png")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/rogulo-abajo.png")), 3);
		this.establecerimagenActual(3);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
	}

}
