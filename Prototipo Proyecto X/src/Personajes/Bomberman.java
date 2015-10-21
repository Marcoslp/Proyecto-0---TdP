package Personajes;

import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Lógica.*;
import PowerUps.PowerUp;

public class Bomberman {
	
	//Atributos
	protected ComponenteGrafico Graficos;
	protected int velocidad;
	protected boolean modoDios;
	protected int capacidadBombas;
	protected Bomba miBomba;
	protected Nivel miNivel;
	protected Posicion miPosicion;
	
	
	//Constructor
	
	public Bomberman (int x, int y, Nivel lvl){
		miPosicion = new Posicion(x,y);
		modoDios = false;
		velocidad=15;
		miNivel= lvl;
		//miBomba= new Bomba(this);
		capacidadBombas=1;
		Graficos = new ComponenteGrafico(4);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/B-izquierda.png")), 0);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/B-derecha.png")), 1);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/B-arriba.png")), 2);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/B-abajo.png")), 3);
		Graficos.establecerimagenActual(3);
		Graficos.obtenerImagenActual().setBounds(x*32, y*32, Graficos.obtenerAncho(), Graficos.obtenerAlto());
	}
	
	//Operaciones
	
	public void moverIzquierda () {
		miNivel.moverBomberman(0);
		Graficos.establecerimagenActual(0);
	}
	
	public void moverDerecha () {
		miNivel.moverBomberman(1);
		Graficos.establecerimagenActual(1);
	}

	public void moverArriba () {
		miNivel.moverBomberman(2);
		Graficos.establecerimagenActual(2);
	}

	public void moverAbajo() {
		Graficos.establecerimagenActual(3);
		miNivel.moverBomberman(3);
	}

	public void ponerBomba () {
		miNivel.explosion(this.miPosicion, miBomba);
	}

	public void morir () {
		
		miNivel.matarBomberman();
		
	}
	
	public void añadirPowerUp (PowerUp p) {
		p.empower(this);
	}
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
	
	public Nivel obtenerNivel () {
		
		return miNivel;
		
	}
	
	public void DuplicarVelocidad () {
		
		velocidad *= 2;
		
	}
	
	public void establecerModoDios (boolean b) {
		
		modoDios = b;

	}
	
	public boolean obtenerModoDios () {
		
		return this.modoDios;
		
	}
	
	public int obtenerCapacidadBombas(){
		return this.capacidadBombas;
	}
	
	public void establecerCapacidadBombas(int i){
		this.capacidadBombas = i;
	}
	
	public Bomba obtenerBomba(){
		return this.miBomba;
	}
	
	public void aumentarCapacidadBombas(){
		this.capacidadBombas++;
	}
	
	public ComponenteGrafico obtenerGrafico(){
		return this.Graficos;
	}
}
