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
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq1.png")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq2.png")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq3.png")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq4.png")), 3);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq5.png")), 4);

		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der1.png")), 5);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der2.png")), 6);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der3.png")), 7);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der4.png")), 8);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der5.png")), 9);

		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba1.png")), 10);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba2.png")), 11);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba3.png")), 12);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba4.png")), 13);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba5.png")), 14);

		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo1.png")), 15);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo2.png")), 16);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo3.png")), 17);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo4.png")), 18);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo5.png")), 19);
		this.establecerimagenActual(15);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
	}
	
	public void mover(int dir){
		try {
			switch (dir){
				case 0 : // Izquierda
					for(int i = 0; i < 5; i += this.velocidad){
						this.establecerimagenActual(i);
						Thread.sleep(100);
					}
					break;
				case 1 : // Derecha
					for(int i = 5; i < 10; i += this.velocidad){
						this.establecerimagenActual(i);
						Thread.sleep(100);
					}
					break;
				case 2 : // Arriba
					for(int i = 10; i < 15; i += this.velocidad){
						this.establecerimagenActual(i);
						Thread.sleep(100);
					}
					break;
				case 3 : // Abajo
					for(int i = 15; i < this.misImagenes.length; i += this.velocidad){
						this.establecerimagenActual(i);
						Thread.sleep(100);
					}
					break;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
