package Personajes;

import javax.swing.ImageIcon;

import Grafica.BombermanGrafico;
import Grafica.ComponenteGrafico;
import Logica.*;
import PowerUps.PowerUp;
import Threads.ContadorBomba;

public class Bomberman extends Thread{
	
	//Atributos
	protected BombermanGrafico Graficos;
	protected int velocidad;
	protected boolean modoDios;
	protected int capacidadBombas;
	protected Bomba miBomba;
	protected Nivel miNivel;
	protected Posicion miPosicion;
	protected int direccion;
	protected boolean puseBomba;
	
	
	//Constructor
	
	public Bomberman (int x, int y, Nivel lvl){
		miPosicion = new Posicion(x,y);
		modoDios = false;
		puseBomba=false;
		velocidad=10;
		miNivel= lvl;
		miBomba= new Bomba(this);
		capacidadBombas=1;
		Graficos = new BombermanGrafico(4,x,y);
		direccion=-1;		
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

	public void ponerBomba() {
		if(capacidadBombas>0){
			capacidadBombas--;
			Bomba bombaClonada = miBomba.clonar();  //CLONA UNA BOMBA Y LUEGO LA AGREGA A LA GUI
			miNivel.obtenerManejadorGUI().añadirBombaClonada(bombaClonada);
			//INICIO UN THREAD QUE HARA QUE A LOS 3 SEGUNDOS EXPLOTE TODO... 
			ContadorBomba contador = new ContadorBomba (3,bombaClonada,miNivel);
			contador.start();
		}
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
	
	public void establecerDireccion(int i){
		direccion=i;
	}
	
	public void establecerPuseBomba(boolean b){
		puseBomba=b;
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(direccion==0){
				this.moverIzquierda();
			}
			else if(direccion==1){
					this.moverDerecha();
				}
			else if(direccion==2){
					this.moverArriba();
			}
			else if(direccion==3){
					this.moverAbajo();
			}
			
			if(puseBomba){
				ponerBomba();
				puseBomba=false;
			}
		}
	}
	
		
}
