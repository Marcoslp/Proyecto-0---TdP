package Lógica;

import javax.swing.ImageIcon;

import Grafica.BombaGrafica;
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
		
		int Px = this.miPosicion.obtenerX();
		int Py = this.miPosicion.obtenerY();
		//INICIALIZO LA PARTE GRAFICA
		Graficos = new BombaGrafica(4,Px,Py);
		
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
