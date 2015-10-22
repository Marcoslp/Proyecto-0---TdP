package Lógica;

import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Personajes.Bomberman;


public class Bomba {
	
	//Atributos
	protected ComponenteGrafico Graficos;
	protected static int alcance = 1;
	protected Bomberman miBomberman;
	protected Posicion miPosicion;
	
	//Constructor
	
	public Bomba (Bomberman b) {
		miBomberman = b;
		miPosicion = new Posicion(miBomberman.obtenerPosicion().obtenerX(),miBomberman.obtenerPosicion().obtenerY());
		
		
		//INICIALIZO LA PARTE GRAFICA
		Graficos = new ComponenteGrafico(4);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Bomba.png")), 0);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ExplosionVertical.png")), 1);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ExplosionHorizontal.png")), 2);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ExplosionCentral.png")), 3);
		Graficos.establecerimagenActual(0);
		Graficos.obtenerImagenActual().setBounds(miPosicion.obtenerX()*32, miPosicion.obtenerY()*32, Graficos.obtenerAncho(), Graficos.obtenerAlto());
	}
	
	//Operaciones
	

	public void explotar (Posicion p, Bomberman b) {
		
	}
	
	public void duplicarAlcance () {
		alcance *= 2;		
	}
	
	public void establecerAlcance(int i){
		alcance = i;
	}
	
	public int obtenerAlcance() {
		return alcance;
	}
	
	public ComponenteGrafico obtenerGraficos(){
		return Graficos;
	}
	
	public Posicion obtenerPosicion(){
		return this.miPosicion;
	}

	public Bomba clonar() {
		Bomba devolver = new Bomba(miBomberman);
		devolver.obtenerPosicion().establecerX(miPosicion.obtenerX());
		devolver.obtenerPosicion().establecerY(miPosicion.obtenerY());
		devolver.establecerAlcance(this.obtenerAlcance());
		return devolver;
	}
	

	

}
