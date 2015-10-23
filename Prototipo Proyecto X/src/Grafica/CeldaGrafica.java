package Grafica;

import javax.swing.ImageIcon;

public class CeldaGrafica extends ComponenteGrafico {

	public CeldaGrafica(int i, int x, int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Piso.png")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/paredInd.jpg")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/paredDes.jpg")), 2);
		this.establecerimagenActual(0);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO, ALTO);
	}
	
}
