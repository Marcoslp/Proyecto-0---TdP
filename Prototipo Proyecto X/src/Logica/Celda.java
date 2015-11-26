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
 * @author Hern�n Pocchiola, Marcos Leguizam�n, Jos� Ochoa
 *
 */

public class Celda {
	
	
	/*La celda contiene la colecci�n de Enemigos que est�n parados sobre ella,
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
	
		public Bomba obtenerBomba(){
			return miBomba;
		}
	
	// Recibir Bomberman cambio, ahora tiene un par�metro
		/**
		 * M�todo que recibe al bomberman en la celda
		 * @param b de tipo Bomberman que representa el Bomberman a recibir
		 */
	public void recibirBomberman(Bomberman b, int dir) {
		if(miBomba==null){
			if(miPared == null){
				Celda celdaAnterior = miNivel.obtenerCelda(b.obtenerPosicion().obtenerX(),b.obtenerPosicion().obtenerY());
				celdaAnterior.setBomberman(null);
				b.obtenerPosicion().establecerX(miPosicion.obtenerX());
				b.obtenerPosicion().establecerY(miPosicion.obtenerY());
				//graficos.recibirBomberman(b,miPosicion); No modifica en nada, seguir probando y borrarla de �ltima
				miBomberman=b;
				b.obtenerGrafico().mover(dir);
				
				for(int i = 0 ; i < misEnemigos.length; i++){ //TESTEO PARA CHEQUEAR COLISION ENTRE BOMBERMAN Y ENEMIGO
					if(misEnemigos[i]!=null){
						miBomberman.morir();// ACA LLAMARIA A LA FUNCION MATAR BOMBERMAN
						this.miNivel.obtenerManejadorGUI().cartelPerder();
						break; //PROVISORIO
					}
				}
				//PROVISORIO PARA PROBAR POWERUPS, EST�N SUELTOS EN LAS CELDAS. ESTO DEBER�A MODELARSE EN OTRA CLASE
				if(miPowerUp != null){
					System.out.println("PowerUp tocado");
					miPowerUp.empower(b); //ACTIVA EL POWERUP
					miNivel.eliminarPowerUp(miPowerUp);
					this.quitarPowerUp();	
					//AUMENTA LA PUNTUACION
					this.miNivel.obtenerManejadorGUI().establecerPuntaje(this.miNivel.obtenerPuntuacion());
				}
				b.actualizarPosicionBomba();
				
			}
			else{
				miPared.recibirBomberman(b,dir);
			}
		}
	}
	/**
	 * M�todo que establece el Bomberman en la celda
	 * @param b de tipo Bomberman que representa el Bomberman a establecer
	 */
	
	public void setBomberman(Bomberman b){
		miBomberman= b;
	}
	
	/**
	 * M�todo que recibe a un enemigo en la celda
	 * @param e de tipo Enemigo que representa el enemigo a recibir
	 */

	public void recibirEnemigo (Enemigo e,int dir){
		if(miBomba== null){
			if(miPared == null){
				Celda celdaAnterior = miNivel.obtenerCelda(e.obtenerPosicion().obtenerX(),e.obtenerPosicion().obtenerY()); 
				celdaAnterior.eliminarEnemigo(e);	//LO QUITA DE LA CELDA ANTERIOR
				e.obtenerPosicion().establecerX(miPosicion.obtenerX());
				e.obtenerPosicion().establecerY(miPosicion.obtenerY()); //ACTUALIZA LAS POSICIONES LOGICAS Y GRAFICAS
				graficos.recibirEnemigo(e,miPosicion);
				e.obtenerGrafico().mover(dir);
				if(miBomberman != null){ //VERIFICA SI MATO AL BOMBERMAN
					miBomberman.morir();// ACA LLAMARIA A LA FUNCION MATAR BOMBERMAN
					this.miNivel.obtenerManejadorGUI().cartelPerder();
				}			
				this.a�adirEnemigo(e);
			}
			else{
				miPared.recibirEnemigo(e,dir);
			}
		}
	}
	
	/**
	 * M�todo que devuelve la pared
	 * @return Pared que representa la pared a devolver
	 */
	
	public Pared obtenerPared(){
		return miPared;
	}
	
	/**
	 * M�todo que establece la pared en la celda
	 * @param p de tipo Pared que representa la pared a establecer
	 */
	
	public void establecerPared(Pared p){
		miPared=p;
		p.establecerImagen();
	}
	
	/**
	 * M�todo que devuelve la posicion de una celda
	 * @return Posicion que representa la posicion de la celda
	 */
	
	public Posicion obtenerPosicion(){
		return miPosicion;
	}
	
	/**
	 * M�todo que devuelve los enemigos situados en la celda
	 * @return Enemigo [] que representa la coleccion de enemigos en la celda
	 */
	
	public Enemigo[] obtenerEnemigos(){
		return misEnemigos;
	}
	
	/**
	 * M�todo que retorna el nivel
	 * @return Nivel que representa el nivel a retornar
	 */
	
	public Nivel obtenerNivel(){
		return miNivel;
	}
	
	/**
	 * M�todo que devuelve el Bomberman
	 * @return Bomberman que representa el bomberman
	 */
	
	public Bomberman obtenerBomberman(){
		return miBomberman;
	}
	
	/**
	 * M�todo que elimina un enemigo de la celda
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
	 * M�todo que mata a un enemigo
	 * @param e de tipo Enemigo que representa el enemigo a matar
	 */
	public void matarEnemigo(Enemigo e){
		boolean cortar = false;
		for(int i=0; i < this.misEnemigos.length && !cortar ; i++){
			if(misEnemigos[i]!=null){
				cortar = misEnemigos[i] == e;
				if(cortar){
					misEnemigos[i].obtenerGrafico().eliminarImagen();
					misEnemigos[i].morir();
					misEnemigos[i]=null;
				}
			}
		}
		//LUEGO DE QUE MUEREN LOS ENEMIGOS SE ACTUALIZA LA PUNTACION
		this.miNivel.obtenerManejadorGUI().establecerPuntaje(this.miNivel.obtenerPuntuacion());
	}
	
	public PowerUp obtenerPowerUp(){
		return miPowerUp;
	}
	
	/**
	 * M�todo que a�ade un enemigo a la celda
	 * @param e de tipo Enemigo que representa el enemigo a a�adir
	 */
	
	public void a�adirEnemigo(Enemigo e) { //Busca el primer lugar libre y se lo asiga al enemigo
		boolean cortar = false;
		for(int i=0; i < this.misEnemigos.length && !cortar ; i++){
			cortar = misEnemigos[i] == null;
			if(cortar){
				misEnemigos[i] = e;
			}
		}
	}
	
	/**
	 * M�todo que retorna el grafico de la celda
	 * @return ComponenteGrafico que representa el grafico de la celda
	 */
	
	public ComponenteGrafico obtenerGraficos(){
		return graficos;
	}
	
	/**
	 * M�todo que establece un PowerUp en la celda
	 * @param p de tipo PowerUp que representa el PowerUp a establecer
	 */
	
	public void establecerPowerUp(PowerUp p){
		this.miPowerUp = p;
	}
	
	/**
	 * M�todo que remueve un powerUp de la celda
	 */
	
	public void quitarPowerUp(){
		this.miPowerUp = null;
	}

	/**
	 * M�todo que elimina la pared de una celda
	 */
	
	public void eliminarPared() {
		miPared=null;
	}
	
	/**
	 * M�todo que establece la bomba de una celda
	 * @param b de tipo Bomba que representa la bomba a establecer
	 */

	public void setBomba(Bomba b) {
		miBomba=b;
	}
}
