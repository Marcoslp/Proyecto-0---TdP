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
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusIzq1.png")), 0);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusIzq2.png")), 1);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusIzq3.png")), 2);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusIzq2.png")), 3);
		
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusDer1.png")), 4);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusDer2.png")), 5);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusDer3.png")), 6);
		this.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusDer2.png")), 7);
				
		this.establecerimagenActual(0);
		this.obtenerImagenActual().setBounds(x*32, y*32, ANCHO, ALTO);
		miPosX=x*32;
		miPosY=y*32;
	}
	
	public void mover(int dir){
		try {
			switch (dir){
				case 0 : // Izquierda
					for(int i = 0; i < 4; i ++){
						this.obtenerImagenActual().setBounds( miPosX -= 8, miPosY, ANCHO, ALTO);
						this.establecerimagenActual(i);
						Thread.sleep(400/velocidad);
					}
					break;
				case 1 : // Derecha
					for(int i = 0; i<4; i++){
						this.obtenerImagenActual().setBounds( miPosX += 8, miPosY, ANCHO, ALTO);
						this.establecerimagenActual(4 + i);
						Thread.sleep(400/velocidad);
					}
					break;
				case 2 : // Arriba
					for(int i = 0; i < 4; i ++){
						this.obtenerImagenActual().setBounds( miPosX , miPosY-= 8, ANCHO, ALTO);
						this.establecerimagenActual(4+i);
						Thread.sleep(400/velocidad);
					}
					break;
				case 3 : // Abajo
					for(int i = 0; i <4; i ++){
						this.obtenerImagenActual().setBounds( miPosX , miPosY+= 8, ANCHO, ALTO);
						this.establecerimagenActual(i);
						Thread.sleep(400/velocidad);
						}
					break;
			}
					
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}

	}
}