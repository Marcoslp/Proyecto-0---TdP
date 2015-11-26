package Grafica;

import javax.swing.ImageIcon;



/**
 * Clase que representa la gráfica del Rogulo
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 *
 */

public class RoguloGrafico extends ComponenteGrafico {

	public RoguloGrafico(int i, int x, int y) {
		super(i);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/fizq.png")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/fizq2.png")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/fizq3.png")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/fizq.png")), 3);
		
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/fder.png")), 4);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/fder2.png")), 5);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/fder3.png")), 6);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/fder.png")), 7);
		this.establecerimagenActual(0);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO,ALTO);
		miPosX= x*32;
		miPosY= y*32;
	}
	public void mover(int dir){
		try {
			switch (dir){
				case 0 : // Izquierda
					for(int i = 0; i < 4; i ++){
						this.obtenerImagenActual().setBounds( miPosX -= 8, miPosY, ANCHO, ALTO);
						this.establecerimagenActual(i);
						Thread.sleep(200/velocidad);
					}
					break;
				case 1 : // Derecha
					for(int i = 0; i<4; i++){
						this.obtenerImagenActual().setBounds( miPosX += 8, miPosY, ANCHO, ALTO);
						this.establecerimagenActual(4+i);
						Thread.sleep(200/velocidad);
						}
					break;
				case 2 : // Arriba
					for(int i = 0; i < 4; i ++){
						this.obtenerImagenActual().setBounds( miPosX , miPosY-= 8, ANCHO, ALTO);
						this.establecerimagenActual(i);
						Thread.sleep(200/velocidad);
					}
					break;
				case 3 : // Abajo
					for(int i = 0; i <4; i ++){
						this.obtenerImagenActual().setBounds( miPosX , miPosY+= 8, ANCHO, ALTO);
						this.establecerimagenActual(4+i);
						Thread.sleep(200/velocidad);
						}
					break;
			}
					
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
}
