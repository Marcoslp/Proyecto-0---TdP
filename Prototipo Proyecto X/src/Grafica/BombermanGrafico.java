package Grafica;

import javax.swing.ImageIcon;

import Personajes.*;


/**
 * Clase que representa la gráfica del Bomberman
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
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

		miPosX=x*32;
		miPosY=y*32;
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
	}

		
	public void mover(int dir){
		System.out.println(miBomberman.obtenerPosicion().obtenerX()+" "+miBomberman.obtenerPosicion().obtenerY());
		
		int movimiento=1,indiceImagen;
		
		try {
			switch (dir){
				case 0 : // Izquierda
					for(int i = 0; i < ANCHO; i += this.velocidad){
						this.obtenerImagenActual().setBounds( miPosX -= (this.velocidad%32), miPosY, ANCHO, ALTO);
						movimiento = (2/velocidad) +1;
						indiceImagen=((i/movimiento)%5)+5*dir;
						if(i%(movimiento)==0)
							this.establecerimagenActual(indiceImagen);
						Thread.sleep(22);
					}
					break;
				case 1 : // Derecha
					for(int i = 0; i<ANCHO; i += this.velocidad){
						this.obtenerImagenActual().setBounds( miPosX += this.velocidad, miPosY, ANCHO, ALTO);
						movimiento = (2/velocidad) +1;
						indiceImagen=((i/movimiento)%5)+5*dir;
						if(i%(movimiento)==0)
							this.establecerimagenActual(indiceImagen);
						Thread.sleep(22);
					}
					
					break;
				case 2 : // Arriba
					for(int i = 0; i < ALTO; i += this.velocidad){
						this.obtenerImagenActual().setBounds( miPosX , miPosY-= this.velocidad, ANCHO, ALTO);
						movimiento = (2/velocidad) +1;
						indiceImagen=((i/movimiento)%5)+5*dir;
						if(i%(movimiento)==0)
							this.establecerimagenActual(indiceImagen);
						Thread.sleep(22);

					}
					break;
				case 3 : // Abajo
					for(int i = 0; i <ALTO; i += this.velocidad){
						this.obtenerImagenActual().setBounds( miPosX , miPosY+= this.velocidad, ANCHO, ALTO);
						movimiento = (2/velocidad) +1;
						indiceImagen=((i/movimiento)%5)+5*dir;
						if(i%(movimiento)==0)
							this.establecerimagenActual(indiceImagen);
						Thread.sleep(22);

					}
					break;
					
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
