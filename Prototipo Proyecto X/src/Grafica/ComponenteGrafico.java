package Grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ComponenteGrafico {
	protected JLabel imagenActual;
	protected Icon misImagenes[];
	protected final int ALTO  = 32;
	protected final int ANCHO = 32;
	
	public ComponenteGrafico(int i){
		misImagenes = new Icon[i];
		imagenActual = new JLabel();
	}
	public void establecerimagenActual(int i){
		if(i!=-1)
			imagenActual.setIcon(misImagenes[i]);
		//PROVISORIO
		else
			imagenActual.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/morido.png")));
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
}
