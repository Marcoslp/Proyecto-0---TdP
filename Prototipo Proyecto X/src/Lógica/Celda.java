package Lógica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.ComponenteGrafico;

import Personajes.Bomberman;
import Personajes.Enemigo;
import PowerUps.PowerUp;


public class Celda {
	
	/*La celda contiene la colección de Enemigos que están parados sobre ella,
	 *el Bomberman y si hay, un PowerUp.
	 */
	
	//Atributos
	private ComponenteGrafico graficos;
	protected Bomberman miBomberman;
	protected Pared miPared;
	protected PowerUp miPowerUp;
	protected Enemigo [] misEnemigos;
	protected Posicion miPosicion;
	protected Nivel miNivel;
	
	
	//Constructor
	
	public Celda (int x,int y, Pared p, Nivel n) {
		miBomberman = null;
		miPared = p;
		misEnemigos = new Enemigo[6];
		miPosicion = new Posicion(x,y);
		miNivel = n;
		//CREA TODO EL COMPONENTE GRAFICO
		graficos = new ComponenteGrafico(3);
		graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Piso.png")), 0);
		graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/paredInd.jpg")), 1);
		graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/paredDes.jpg")), 2);
		p.establecerImagen(); //EVITA EL INSTANCE OF Y HACE QUE LA PARED PONGA LA IMAGEN
		graficos.obtenerImagenActual().setBounds(x*32, y*32, graficos.obtenerAncho(), graficos.obtenerAlto());
	}
	
	public Celda(int x,int y, Nivel n){
		miBomberman = null;
		miPared = null;
		miPowerUp = null;
		misEnemigos = new Enemigo[6];
		miPosicion = new Posicion(x,y);
		miNivel = n;
		//CREA TODO EL COMPONENTE GRAFICO
		graficos = new ComponenteGrafico(3);
		graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Piso.png")), 0);
		graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/paredInd.jpg")), 1);
		graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/paredDes.jpg")), 2);
		graficos.establecerimagenActual(0);
		graficos.obtenerImagenActual().setBounds(x*32, y*32, graficos.obtenerAncho(), graficos.obtenerAlto());
	}
	
	//Operaciones
	
	// Recibir Bomberman cambio, ahora tiene un parámetro
	public void recibirBomberman(Bomberman b) {
		if(miPared == null){
			Celda celdaAnterior = miNivel.obtenerCelda(b.obtenerPosicion().obtenerX(),b.obtenerPosicion().obtenerY());
			celdaAnterior.setBomberman(null);
			b.obtenerPosicion().establecerX(miPosicion.obtenerX());
			b.obtenerPosicion().establecerY(miPosicion.obtenerY());
			b.obtenerGrafico().obtenerImagenActual().setBounds(miPosicion.obtenerX()*32,miPosicion.obtenerY()*32,b.obtenerGrafico().obtenerAncho(),b.obtenerGrafico().obtenerAlto());
			miBomberman=b;
			for(int i = 0 ; i < misEnemigos.length; i++){
				if(misEnemigos[i]!=null){
					System.out.println("Bomberman toco enemigo");
					break; //PROVISORIO
				}
					
			}
			if(miPowerUp != null){
				miPowerUp.empower(b); //ACTIVA EL POWERUP
				miNivel.eliminarPowerUp(miPowerUp);
				this.quitarPowerUp();	
			}
		}
		else{
			miPared.recibirBomberman(b);
		}
	}
	
	public void setBomberman(Bomberman b){
		miBomberman= b;
	}

	public void recibirEnemigo (Enemigo e){
		if(miPared == null){
			Celda celdaAnterior = miNivel.obtenerCelda(e.obtenerPosicion().obtenerX(),e.obtenerPosicion().obtenerY()); 
			celdaAnterior.eliminarEnemigo(e);	//LO QUITA DE LA CELDA ANTERIOR
			e.obtenerPosicion().establecerX(this.obtenerPosicion().obtenerX());
			e.obtenerPosicion().establecerY(this.obtenerPosicion().obtenerY()); //ACTUALIZA LAS POSICIONES LOGICAS Y GRAFICAS
			e.obtenerGrafico().obtenerImagenActual().setBounds(miPosicion.obtenerX()*32,miPosicion.obtenerY()*32,e.obtenerGrafico().obtenerAncho(),e.obtenerGrafico().obtenerAlto());
			if(miBomberman != null){ //VERIFICA SI MATO AL BOMBERMAN
				System.out.println("Enemigo mato a bomberman");  // ACA LLAMARIA A LA FUNCION MATAR BOMBERMAN
			}			
			this.añadirEnemigo(e);
		}
		else{
			miPared.recibirEnemigo(e);
		}
	}
	
	public Pared obtenerPared(){
		return miPared;
	}
	
	public void establecerPared(Pared p){
		miPared=p;
		p.establecerImagen(); //CAMBIA EL ICONO DEL JLABEL
	}
	
	public Posicion obtenerPosicion(){
		return miPosicion;
	}
	
	public Nivel obtenerNivel(){
		return miNivel;
	}
	
	public void eliminarEnemigo(Enemigo e) {  //Busca al enemigo en el arreglo y lo elimina
		boolean cortar = false;

		for(int i=0; i < this.misEnemigos.length && !cortar ; i++){
			cortar = misEnemigos[i] == e;
			if(cortar){
				misEnemigos[i] = null;
			}
		}		
	}

	public void añadirEnemigo(Enemigo e) { //Busca el primer lugar libre y se lo asiga al enemigo
		boolean cortar = false;
		for(int i=0; i < this.misEnemigos.length && !cortar ; i++){
			cortar = misEnemigos[i] == null;
			if(cortar){
				misEnemigos[i] = e;
			}
		}
	}
	
	public ComponenteGrafico obtenerGraficos(){
		return graficos;
	}
	
	public void establecerPowerUp(PowerUp p){
		this.miPowerUp = p;
	}
	
	public void quitarPowerUp(){
		this.miPowerUp = null;
	}


	
}
