package Grafica;

import javax.swing.ImageIcon;

public class PowerUpGrafico extends ComponenteGrafico {
	public PowerUpGrafico(int i, int x, int y){
		super(4);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SpeedUp.png")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Fatality.png")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Bombality.png")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Masacrality.png")), 3);
		this.establecerimagenActual(i);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
	}
}
