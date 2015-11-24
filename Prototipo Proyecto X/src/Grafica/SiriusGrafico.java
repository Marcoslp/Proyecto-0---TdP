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
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusIzquierda.gif")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusDerecha.gif")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusArriba.gif")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusIzquierda.gif")), 3);
		this.establecerimagenActual(3);
		this.obtenerImagenActual().setBounds(x*32, y*32, ALTO, ANCHO);
		
		miPosY=x*32;
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