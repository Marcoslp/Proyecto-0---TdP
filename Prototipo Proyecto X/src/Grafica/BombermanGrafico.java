package Grafica;

import javax.swing.ImageIcon;

import Personajes.*;


/**
 * Clase que representa la gr�fica del Bomberman
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 *
 */

public class BombermanGrafico extends ComponenteGrafico {
	
	protected Bomberman miBomberman;

	public BombermanGrafico(int i, int x, int y, Bomberman b) {
		super(i);
		miBomberman=b;
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq1.png")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq2.png")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq3.png")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq4.png")), 3);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq5.png")), 4);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq6.png")), 5);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq7.png")), 6);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-izq8.png")), 7);
		
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der1.png")), 8);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der2.png")), 9);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der3.png")), 10);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der4.png")), 11);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der5.png")), 12);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der6.png")), 13);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der7.png")), 14);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-der8.png")), 15);
		
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba1.png")), 16);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba2.png")), 17);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba3.png")), 18);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba4.png")), 19);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba5.png")), 20);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba6.png")), 21);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba7.png")), 22);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-arriba8.png")), 23);
		
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo1.png")), 24);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo2.png")), 25);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo3.png")), 26);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo4.png")), 27);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo5.png")), 28);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo6.png")), 29);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo7.png")), 30);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/b-abajo8.png")), 31);
		
		this.establecerimagenActual(31);
		miPosX=x*32;
		miPosY=y*32;
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
	}

		
	public void mover(int dir){
		try {
			switch (dir){
				case 0 : // Izquierda
					for(int i = 0; i < 4; i ++){
							this.obtenerImagenActual().setBounds(miPosX -= 8, miPosY, ANCHO, ALTO);
							this.establecerimagenActual(i);
							Thread.sleep(100/velocidad);
						
					}
					this.establecerimagenActual(7);
					break;
				case 1 : // Derecha
					for(int i = 0; i<4; i++){
						this.obtenerImagenActual().setBounds( miPosX += 8, miPosY, ANCHO, ALTO);
						this.establecerimagenActual(8+i);
						Thread.sleep(100/velocidad);
					}
					this.establecerimagenActual(15);
					break;
				case 2 : // Arriba
					for(int i = 0; i < 4; i++){
						this.obtenerImagenActual().setBounds( miPosX , miPosY-= 8, ANCHO, ALTO);
						this.establecerimagenActual(16+i);
						Thread.sleep(100/velocidad);
					}
					this.establecerimagenActual(23);
					break;
				case 3 : // Abajo
					for(int i = 0; i <4; i ++){
						this.obtenerImagenActual().setBounds( miPosX , miPosY+=8, ANCHO, ALTO);
						this.establecerimagenActual(28+i);
						Thread.sleep(100/velocidad);
					}
					this.establecerimagenActual(31);
					break;
					
			}
		} catch (InterruptedException e) {
		}
	}
}
