package Grafica;

import javax.swing.ImageIcon;


/**
 * Clase que representa la gr�fica del Altair
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 *
 */
public class AltairGrafico extends ComponenteGrafico{

	public AltairGrafico(int i,int x,int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/altair-izquierda.gif")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/altair-derecha.gif")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/AltairArriba.gif")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/AltairAbajo.gif")), 3);
		this.establecerimagenActual(3);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO, ALTO);
		miPosX=x*32;
		miPosY=y*32;
	}
		
	public void mover(int dir){	
			try {
				switch (dir){
					case 0 : // Izquierda
						for(int i = 0; i < ANCHO; i +=velocidad){
							this.obtenerImagenActual().setBounds( miPosX -= (this.velocidad%32), miPosY, ANCHO, ALTO);
							this.establecerimagenActual(0);
							Thread.sleep(22);
						}
						break;
					case 1 : // Derecha
						for(int i = 0; i<ANCHO; i+=velocidad){
							this.establecerimagenActual(1);
							Thread.sleep(22);
							this.obtenerImagenActual().setBounds( miPosX += (this.velocidad%32), miPosY, ANCHO, ALTO);
						}
						break;
					case 2 : // Arriba
						for(int i = 0; i < ALTO; i +=velocidad){
							this.obtenerImagenActual().setBounds( miPosX , miPosY-= this.velocidad, ANCHO, ALTO);
							this.establecerimagenActual(2);
							Thread.sleep(22);
						}
						break;
					case 3 : // Abajo
						for(int i = 0; i <ALTO; i +=velocidad){
							this.obtenerImagenActual().setBounds( miPosX , miPosY+= this.velocidad, ANCHO, ALTO);
							this.establecerimagenActual(3);
							Thread.sleep(22);
						}
						break;
				}
						
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
	
	}