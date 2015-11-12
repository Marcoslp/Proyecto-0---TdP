package Personajes;

import javax.swing.ImageIcon;

import Grafica.BombermanGrafico;
import Grafica.ComponenteGrafico;
import Logica.*;
import PowerUps.PowerUp;
import Threads.ContadorBomba;

/**
 * Clase que modela la lógica del personaje Bomberman
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

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
	protected volatile boolean Detener;
	
	
	//Constructor
	
	public Bomberman (int x, int y, Nivel lvl){
		Detener=false;
		miPosicion = new Posicion(x,y);
		modoDios = false;
		puseBomba=false;
		velocidad=1;
		miNivel= lvl;
		miBomba= new Bomba(this);
		capacidadBombas=1;
		Graficos = new BombermanGrafico(20,x,y);
		Graficos.establecerVelocidad(velocidad);
		direccion=-1;		
	}
	
	//Operaciones
	
	/**
	 * Método utilizado para mover el bomberman a la izquierda
	 */
	
	public void moverIzquierda () {
		miNivel.moverBomberman(0);
		Graficos.mover(0);
	}
	
	/**
	 * Método utilizado para mover el bomberman a la derecha
	 */
	
	public void moverDerecha () {
		miNivel.moverBomberman(1);
		Graficos.mover(1);
	}

	/**
	 * Método utilizado para mover el bomberman hacia arriba
	 */
	
	public void moverArriba () {
		miNivel.moverBomberman(2);
		Graficos.mover(2);
	}

	/**
	 * Método utilizado para mover el bomberman hacia abajo
	 */
	
	public void moverAbajo() {
		miNivel.moverBomberman(3);
		Graficos.mover(3);
		
	}

	/**
	 * Metodo utilizado para que el bomberman ponga una bomba
	 */
	
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

	/**
	 * Método utilizado para matar al bomberman :(
	 */
	
	public void morir () {
		miNivel.matarBomberman();
	
	}
	
	/**
	 * Método utilizado cuando muere el bomberman :(
	 */
	
	public void detener(){
		this.interrupt();
		Detener=true;
	}
	
	/**
	 * Método utilizado para añadir un powerUp al bomberman
	 * @param p de tipo PowerUp que representa el powerUp obtenido
	 */
	
	public void añadirPowerUp (PowerUp p) {
		p.empower(this);
	}
	
	/**
	 * Método que retorna a posicion del bomberman
	 * @return Posicion que representa la posicion a retornar
	 */
	
	public Posicion obtenerPosicion () {
		
		return miPosicion;
		
	}
	
	/**
	 * Método que devuelve el nivel asociado al bomberman
	 * @return Nivel que representa el nivel a retornar
	 */
	
	public Nivel obtenerNivel () {
		
		return miNivel;
		
	}
	
	/**
	 * Método que duplica la velocidad del Bomberman
	 */
	
	public void DuplicarVelocidad () {
		
		velocidad *= 2;
		Graficos.duplicarVelocidad();
		
	}
	
	/**
	 * Método que establece el Modo Dios del bomberman
	 * @param b de tipo Booleano que representa el Modo Dios
	 */
	
	public void establecerModoDios (boolean b) {
		
		modoDios = b;

	}
	
	/**
	 * Método que devuelve si el bomberman esta o no en modo dios
	 * @return Boolean que representa el modo dios a devolver
	 */
	
	public boolean obtenerModoDios () {
		
		return this.modoDios;
		
	}
	
	/**
	 * Método que devuelve la capacidad de bombas del bomberman
	 * @return int que representa la capacidad de bombas a devolver
	 */
	
	public int obtenerCapacidadBombas(){
		return this.capacidadBombas;
	}
	
	/**
	 * Método que establece la capacidad de bombas del bomberman
	 * @param i de tipo int que representa la capacidad de bombas a establecer
	 */
	
	public void establecerCapacidadBombas(int i){
		this.capacidadBombas = i;
	}
	
	/**
	 * Método que devuelve la bomba asociada al bomberman
	 * @return Bomba que representa la bomba a devolver
	 */
	
	public Bomba obtenerBomba(){
		return this.miBomba;
	}
	
	/**
	 * Método que aumenta la capacidad de bombas del bomberman
	 */
	
	public void aumentarCapacidadBombas(){
		this.capacidadBombas++;
	}
	
	/**
	 * Método que devuelve la grafica del bomberman
	 * @return ComponenteGrafico que representa la grafica a devolver
	 */
	
	public ComponenteGrafico obtenerGrafico(){
		return this.Graficos;
	}
	/**
	 * Método que actualiza la posicion de la bomba
	 */
	
	public void actualizarPosicionBomba(){ //ACTUALIZA POSICION DE LA BOMBA
		this.miBomba.obtenerPosicion().establecerX(this.miPosicion.obtenerX());
		this.miBomba.obtenerPosicion().establecerY(this.miPosicion.obtenerY());
	}
	
	/**
	 * Método que establece la direccion a mover
	 * @param i de tipo int que representa la direccion
	 */
	
	public void establecerDireccion(int i){
		direccion=i;
	}
	
	/**
	 * Metodo que establece si se puso o no la bomba
	 * @param b de tipo Boolean que representa si se puso o no la bomba
	 */
	
	public void establecerPuseBomba(boolean b){
		puseBomba=b;
	}
	
	/** 
	 * Método que maneja la ejecuccion de un hilo para las acciones del Bomberman
	 */
	
	public void run() {
		while(!Detener){
			try {
				Thread.sleep(200/velocidad);
			} catch (InterruptedException e) {
			}
			
			int direccion_cached = this.direccion;
			this.direccion = -1;
			
			if(direccion_cached==0){
				this.moverIzquierda();
			}
			else if(direccion_cached==1){
					this.moverDerecha();
				}
			else if(direccion_cached==2){
					this.moverArriba();
			}
			else if(direccion_cached==3){
					this.moverAbajo();
			}
			
			if(puseBomba){
				ponerBomba();
				puseBomba=false;
			}
			
		}
	}
	
		
}
