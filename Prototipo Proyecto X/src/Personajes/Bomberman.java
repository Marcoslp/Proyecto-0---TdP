package Personajes;

import javax.swing.ImageIcon;

import Grafica.ComponenteGrafico;
import Lógica.*;
import PowerUps.PowerUp;
import Threads.ContadorBomba;

public class Bomberman extends Thread {
	
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
		velocidad=10;
		miNivel= lvl;
		miBomba= new Bomba(this);
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
		try {
			this.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void ponerBomba() {
		/*
		 * ContadorBomba contador = new ContadorBomba (3,miBomba.clonar());
			contador.start();	
		 */
		Bomba bombaClonada = miBomba.clonar();  //CLONA UNA BOMBA Y LUEGO LA AGREGA A LA GUI
		bombaClonada.obtenerGraficos().obtenerImagenActual().setBounds(bombaClonada.obtenerPosicion().obtenerX()*32, bombaClonada.obtenerPosicion().obtenerY()*32,32,32);
		miNivel.obtenerGui().add(bombaClonada.obtenerGraficos().obtenerImagenActual());
		miNivel.obtenerGui().getContentPane().setComponentZOrder(bombaClonada.obtenerGraficos().obtenerImagenActual(), 1);
		
		//INICIO UN THREAD QUE HARA QUE A LOS 3 SEGUNDOS EXPLOTE TODO... incluido el programa
		ContadorBomba contador = new ContadorBomba (3,bombaClonada,miNivel);
		contador.start();
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
	
	public void actualizarPosicionBomba(){ //ACTUALIZA POSICION DE LA BOMBA
		this.miBomba.obtenerPosicion().establecerX(this.miPosicion.obtenerX());
		this.miBomba.obtenerPosicion().establecerY(this.miPosicion.obtenerY());
	}
		
}
