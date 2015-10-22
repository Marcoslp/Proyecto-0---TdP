package Grafica;

import javax.swing.Icon;
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
		imagenActual.setIcon(misImagenes[i]);
	}
	
	public void establecerImagen(Icon j, int i){
		misImagenes[i] = j;
	}
	
	
	public JLabel obtenerIconoActual(int i){
		return new JLabel(misImagenes[i]);
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
