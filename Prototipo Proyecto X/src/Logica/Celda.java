package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.CeldaGrafica;
import Grafica.ComponenteGrafico;
import Personajes.Bomberman;
import Personajes.Enemigo;
import PowerUps.PowerUp;

/**
 * Clase que modela la celda logica
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 *
 */

public class Celda {
	
	
	/*La celda contiene la colección de Enemigos que están parados sobre ella,
	 *el Bomberman y si hay, un PowerUp.
	 */
	
	//Atributos
	private CeldaGrafica graficos;
	protected Bomberman miBomberman;
	protected Pared miPared;
	protected PowerUp miPowerUp;
	protected Enemigo [] misEnemigos;
	protected Posicion miPosicion;
	protected Nivel miNivel;
	protected Bomba miBomba;
	
	
	//Constructor
	
		public Celda(int x,int y, Nivel n){
		miBomberman = null;
		miPared = null;
		miPowerUp = null;
		miBomba= null;
		misEnemigos = new Enemigo[6];
		miPosicion = new Posicion(x,y);
		miNivel = n;
		//CREA TODO EL COMPONENTE GRAFICO
		graficos = new CeldaGrafica(3,x,y);
		
	}
	
	//Operaciones
	
	// Recibir Bomberman cambio, ahora tiene un parámetro
		/**
		 * Método que recibe al bomberman en la celda
		 * @param b de tipo Bomberman que representa el Bomberman a recibir
		 */
	public void recibirBomberman(Bomberman b) {
		if(miBomba==null){
			if(miPared == null){
				Celda celdaAnterior = miNivel.obtenerCelda(b.obtenerPosicion().obtenerX(),b.obtenerPosicion().obtenerY());
				celdaAnterior.setBomberman(null);
				b.obtenerPosicion().establecerX(miPosicion.obtenerX());
				b.obtenerPosicion().establecerY(miPosicion.obtenerY());
				graficos.recibirBomberman(b,miPosicion);
				miBomberman=b;
				
				
				for(int i = 0 ; i < misEnemigos.length; i++){ //TESTEO PARA CHEQUEAR COLISION ENTRE BOMBERMAN Y ENEMIGO
					if(misEnemigos[i]!=null){
						System.out.println("Bomberman toco enemigo");
						break; //PROVISORIO
					}
				}
				//PROVISORIO PARA PROBAR POWERUPS, ESTÁN SUELTOS EN LAS CELDAS. ESTO DEBERÍA MODELARSE EN OTRA CLASE
				if(miPowerUp != null){
					miPowerUp.empower(b); //ACTIVA EL POWERUP
					miNivel.eliminarPowerUp(miPowerUp);
					this.quitarPowerUp();	
				}
				b.actualizarPosicionBomba();
			}
			else{
				miPared.recibirBomberman(b);
			}
		}
	}
	/**
	 * Método que establece el Bomberman en la celda
	 * @param b de tipo Bomberman que representa el Bomberman a establecer
	 */
	
	public void setBomberman(Bomberman b){
		miBomberman= b;
	}
	
	/**
	 * Método que recibe a un enemigo en la celda
	 * @param e de tipo Enemigo que representa el enemigo a recibir
	 */

	public void recibirEnemigo (Enemigo e){
		if(miBomba== null){
			if(miPared == null){
				Celda celdaAnterior = miNivel.obtenerCelda(e.obtenerPosicion().obtenerX(),e.obtenerPosicion().obtenerY()); 
				celdaAnterior.eliminarEnemigo(e);	//LO QUITA DE LA CELDA ANTERIOR
				e.obtenerPosicion().establecerX(this.obtenerPosicion().obtenerX());
				e.obtenerPosicion().establecerY(this.obtenerPosicion().obtenerY()); //ACTUALIZA LAS POSICIONES LOGICAS Y GRAFICAS
				graficos.recibirEnemigo(e,miPosicion);
				if(miBomberman != null){ //VERIFICA SI MATO AL BOMBERMAN
					System.out.println("Enemigo mato a bomberman");  // ACA LLAMARIA A LA FUNCION MATAR BOMBERMAN
				}			
				this.añadirEnemigo(e);
			}
			else{
				miPared.recibirEnemigo(e);
			}
		}
	}
	
	/**
	 * Método que devuelve la pared
	 * @return Pared que representa la pared a devolver
	 */
	
	public Pared obtenerPared(){
		return miPared;
	}
	
	/**
	 * Método que establece la pared en la celda
	 * @param p de tipo Pared que representa la pared a establecer
	 */
	
	public void establecerPared(Pared p){
		miPared=p;
		p.establecerImagen(); //CAMBIA EL ICONO DEL JLABEL
	}
	
	/**
	 * Método que devuelve la posicion de una celda
	 * @return Posicion que representa la posicion de la celda
	 */
	
	public Posicion obtenerPosicion(){
		return miPosicion;
	}
	
	/**
	 * Método que devuelve los enemigos situados en la celda
	 * @return Enemigo [] que representa la coleccion de enemigos en la celda
	 */
	
	public Enemigo[] obtenerEnemigos(){
		return misEnemigos;
	}
	
	/**
	 * Método que retorna el nivel
	 * @return Nivel que representa el nivel a retornar
	 */
	
	public Nivel obtenerNivel(){
		return miNivel;
	}
	
	/**
	 * Método que devuelve el Bomberman
	 * @return Bomberman que representa el bomberman
	 */
	
	public Bomberman obtenerBomberman(){
		return miBomberman;
	}
	
	/**
	 * Método que elimina un enemigo de la celda
	 * @param e de tipo Enemigo que representa el enemigo a eliminar
	 */
	
	public void eliminarEnemigo(Enemigo e) {  //Busca al enemigo en el arreglo y lo elimina
		boolean cortar = false;
		for(int i=0; i < this.misEnemigos.length && !cortar ; i++){
			cortar = misEnemigos[i] == e;
			if(cortar){
				misEnemigos[i] = null;
			}
		}	
	}
	
	/**
	 * Método que mata a un enemigo
	 * @param e de tipo Enemigo que representa el enemigo a matar
	 */
	public void matarEnemigo(Enemigo e){
		boolean cortar = false;
		for(int i=0; i < this.misEnemigos.length && !cortar ; i++){
			cortar = misEnemigos[i] == e;
			if(cortar){
				misEnemigos[i].morir();
				misEnemigos[i].obtenerGrafico().eliminarImagen();
				misEnemigos[i].destruir();
			}
		}
	}
	
	/**
	 * Método que añade un enemigo a la celda
	 * @param e de tipo Enemigo que representa el enemigo a añadir
	 */
	
	public void añadirEnemigo(Enemigo e) { //Busca el primer lugar libre y se lo asiga al enemigo
		boolean cortar = false;
		for(int i=0; i < this.misEnemigos.length && !cortar ; i++){
			cortar = misEnemigos[i] == null;
			if(cortar){
				misEnemigos[i] = e;
			}
		}
	}
	
	/**
	 * Método que retorna el grafico de la celda
	 * @return ComponenteGrafico que representa el grafico de la celda
	 */
	
	public ComponenteGrafico obtenerGraficos(){
		return graficos;
	}
	
	/**
	 * Método que establece un PowerUp en la celda
	 * @param p de tipo PowerUp que representa el PowerUp a establecer
	 */
	
	public void establecerPowerUp(PowerUp p){
		this.miPowerUp = p;
	}
	
	/**
	 * Método que remueve un powerUp de la celda
	 */
	
	public void quitarPowerUp(){
		this.miPowerUp = null;
	}

	/**
	 * Método que elimina la pared de una celda
	 */
	
	public void eliminarPared() {
				miPared=null;	
	}
	
	/**
	 * Método que establece la bomba de una celda
	 * @param b de tipo Bomba que representa la bomba a establecer
	 */

	public void setBomba(Bomba b) {
		miBomba=b;
	}
}
