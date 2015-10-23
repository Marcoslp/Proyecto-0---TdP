package Grafica;

import javax.swing.ImageIcon;

public class BombaGrafica extends ComponenteGrafico {
	public BombaGrafica(int i, int x, int y){
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Bomba.gif")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ExplosionVertical.png")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ExplosionHorizontal.png")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ExplosionCentral.png")), 3);
		this.establecerimagenActual(0);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
	}
}
