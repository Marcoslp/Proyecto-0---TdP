package Grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public abstract class ComponenteGrafico {
	protected JLabel imagenActual;
	protected Icon misImagenes[];
	protected final int ALTO  = 32;
	protected final int ANCHO = 32;
	protected int velocidad;
	protected int miPosX,miPosY;
	
	public ComponenteGrafico(int i){
		misImagenes = new Icon[i];
		imagenActual = new JLabel();
	}
	public void establecerimagenActual(int i){
			imagenActual.setIcon(misImagenes[i]);
	}
	
	public void establecerImagen(Icon j, int i){
		misImagenes[i] = j;
	}
	
	
	public Icon obtenerIconoActual(int i){
		return misImagenes[i];
	}
	public JLabel obtenerImagenActual(){
		return imagenActual;
	}
	public int obtenerAncho() {
		return ANCHO;
	}
	public int obtenerAlto() {
		return ALTO;
	}
	public void eliminarImagen() {
		this.obtenerImagenActual().setVisible(false);	
	}
	
	public void establecerVelocidad(int i){
		velocidad=i;
	}
	
	public void duplicarVelocidad(){
		velocidad= velocidad*2;
	}
	
	public abstract void mover(int i);
	
	
	
}
