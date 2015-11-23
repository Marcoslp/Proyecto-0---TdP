package Logica;

import Grafica.GUI;
import Grafica.ManejadorGUI;
import Personajes.*;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.JLabel;

import PowerUps.*;
import Threads.ContadorBomba;
import Threads.Tiempo;

/**
 * Clase que modela la lógica del nivel
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 *
 */
public class Nivel {
	
	private static final int largo=31;
	private static final int ancho=13;
	protected Tiempo tiempo;
	//Atributos
	protected String marcadorTiempo;
	protected int marcadorPuntos;
	protected Bomberman miBomberman;
	protected Enemigo[] misEnemigos;
	protected Celda [][] misCeldas;
	protected PowerUp [] misPowerUps;
	protected ManejadorGUI miManejador;
	
	//Constructor
	
	public Nivel (GUI miGui) {
		
	
		miManejador= new ManejadorGUI(miGui);
		miBomberman = new Bomberman(1,1,this);
		miBomberman.start();
		//Añade el bomberman a la GUI
		miManejador.añadirBomberman(miBomberman);
		//misPowerUps = p;
		marcadorPuntos=0;
		//INICIALIZO EL TEMPORIZADOR
		tiempo = new Tiempo(this);
		tiempo.start();
		
		//Ver como modelar el marcador de tiempo
		
		
		int contadorCelda=0;
		//Creo el arreglo de celdas vacío
		misCeldas= new Celda[largo][ancho];
		for(int i=0; i<largo; i++){
			for(int j=0; j<ancho; j++){
				misCeldas[i][j]= new Celda(i,j,this);
				contadorCelda++;
				//Añade las celdas a la GUI
				miManejador.añadirCelda(misCeldas[i][j]);
			}
		}
		
		//Inicializo los bordes con paredes indestructibles
		
		for(int i=0; i<largo; i++){ //hasta 31
			
			misCeldas[i][0].establecerPared(new ParedIndestructible(misCeldas[i][0]));
			misCeldas[i][12].establecerPared(new ParedIndestructible(misCeldas[i][12]));
			contadorCelda-=2;
		}
		
		for(int j=0; j<ancho; j++){
			misCeldas[0][j].establecerPared(new ParedIndestructible(misCeldas[0][j]));
			misCeldas[30][j].establecerPared(new ParedIndestructible(misCeldas[30][j]));
			contadorCelda-=2;
		}
		
		
		//Seteo al Bomberman en la posición inicial
		misCeldas[1][1].setBomberman(miBomberman);
		
		//Creo las paredes indestructibles dentro de la grilla
		int cantParedes=0;
		int largoAux=2;
		int anchoAux=2;
			while(largoAux<largo-1){
				while(anchoAux<ancho-1){
				misCeldas[largoAux][anchoAux].establecerPared(new ParedIndestructible(misCeldas[largoAux][anchoAux]));
				anchoAux+=2;
				cantParedes++;
				}
				largoAux+=2;
				anchoAux=2;
			}
			
			Random rnd= new Random();
			boolean termine=false;
			int Px,Py;
			Pared paredAux;
			int total= contadorCelda - cantParedes;
			int aux=0;
			boolean derecha,abajo,yo;
			int k=0;
			
			
			this.misPowerUps = new PowerUp[11]; 
			while(k<11){
				Px= rnd.nextInt(30);
				Py= rnd.nextInt(12);
				
				yo= misCeldas[Px][Py] != misCeldas[1][1];
				derecha= misCeldas[Px][Py] != misCeldas[1][2];
				abajo= misCeldas[Px][Py] != misCeldas[2][1];
				if(misCeldas[Px][Py].obtenerPared() == null){
					if(abajo && derecha && yo && misCeldas[Px][Py] != misCeldas[1][3] && misCeldas[Px][Py] != misCeldas[3][1]){
						if(k<4){
							this.misPowerUps[k] = new SpeedUp(Px,Py,this.misCeldas[Px][Py]);	
						}
						else{
							if(k<7){
								this.misPowerUps[k] = new Fatality(Px,Py,this.misCeldas[Px][Py]);
							}
							else{
								if(k<10){
									this.misPowerUps[k] = new Bombality(Px,Py,this.misCeldas[Px][Py]);
								}
								else
									this.misPowerUps[k] = new Masacrality(Px,Py,this.misCeldas[Px][Py]);								
							}
						}
						misCeldas[Px][Py].establecerPowerUp(misPowerUps[k]);
						System.out.println("Powerup en: x= "+Px+" y = "+Py);
						miManejador.añadirPowerUp(misPowerUps[k]);
						misPowerUps[k].obtenerGrafico().obtenerImagenActual().setVisible(false);
						paredAux= new ParedDestructible(misCeldas[Px][Py]);						
						misCeldas[Px][Py].establecerPared(paredAux);
						k++;
						aux++;
					}
				}
			}
			
			
			// INICIALIZACION PAREDES DESTRUCTIBLES
			while(!termine){
				Px= rnd.nextInt(31);
				Py= rnd.nextInt(13);
				//boolean derecha,abajo,yo;
				yo= misCeldas[Px][Py] != misCeldas[1][1];
				derecha= misCeldas[Px][Py] != misCeldas[1][2];
				abajo= misCeldas[Px][Py] != misCeldas[2][1];
				if(misCeldas[Px][Py].obtenerPared() == null){ //EVITA QUE SE PONGA ARRIBA DEL BOMBERMAN Y LOS POWERUPS, PROVISORIO. SE HARIA UN PRIVADO QUE CONTROLE MAS POSICIONES PROHIBIDAS
					if(abajo && derecha && yo && misCeldas[Px][Py] != misCeldas[1][3] && misCeldas[Px][Py] != misCeldas[3][1]){
						paredAux= new ParedDestructible(misCeldas[Px][Py]);
						misCeldas[Px][Py].establecerPared(paredAux);
						if(misCeldas[Px][Py].obtenerPowerUp() == null){
							
						}
						aux++;
					}
				}
				if(aux == (total/2))
					termine=true;
			}
			//SE INICILIZAN ENEMIGOS
			//ROGULOS
			misEnemigos = new Enemigo [6];
			termine = false;
			int i = 0;
			while (i < 3){
				int Ex= rnd.nextInt(30);
				int Ey= rnd.nextInt(12);
				if(misCeldas[Ex][Ey].obtenerPared() == null){
					misEnemigos[i] = new Rogulo (Ex,Ey,this);
					misCeldas[Ex][Ey].añadirEnemigo(misEnemigos[i]);
					miManejador.añadirEnemigo(misEnemigos[i]);
					misEnemigos[i].start();
					i++;					
				}
			}
				
			//ALTAIR
			while (i<5) {
				int Fx= rnd.nextInt(30);
				int Fy= rnd.nextInt(12);
				if(misCeldas[Fx][Fy].obtenerPared() == null){
					misEnemigos[i] = new Altair (Fx,Fy,this);
					misCeldas[Fx][Fy].añadirEnemigo(misEnemigos[i]);
					miGui.add(misEnemigos[i].obtenerGrafico().obtenerImagenActual());
					miGui.getContentPane().setComponentZOrder(misEnemigos[i].obtenerGrafico().obtenerImagenActual(), 0);//PARA PONER EL LABEL DE LOS ENEMIGOS POR ENCIMA DEL PISO
					misEnemigos[i].start();
					i++;					
				}
			}
			/*
			// SIRIUS
			misEnemigos[5] = new Sirius (29,11);
			}*/
			 
		    //INICIALIZO EL FATALITY
		    
					/**
		   	this.misPowerUps[1] = new Fatality(1,5,this.misCeldas[1][5]);
		    misCeldas[1][5].establecerPowerUp(misPowerUps[1]);
			miManejador.añadirPowerUp(misPowerUps[1]);
			**/
	}
	
	//Operaciones
	
	//Método auxiliar para explotar la bomba
	
	/**
	 * Método auxiliar para explotar una bomba
	 * @param b de tipo Bomba que representa la bomba a explotar
	 * @param direccion de tipo int que representa la direccion a explotar
	 * @param s de tipo String que representa el nombre de la direccion a explotar
	 */
	
	private void explosionAuxiliar(Bomba b, int direccion, String s){
		boolean cortar=false;
		Icon DireccionExplosion= b.obtenerGraficos().obtenerIconoActual(direccion);
		int posX = b.obtenerPosicion().obtenerX();
		int posY = b.obtenerPosicion().obtenerY();
		Celda celdaActual=misCeldas[posX][posY];
		
		if(celdaActual.obtenerBomberman()!=null){
			celdaActual.obtenerBomberman().morir();
		}
		
		for(int i = 1; i< b.obtenerAlcance() + 1 && !cortar; i++){ //EL MAS 1 ES PARA QUE NO EMPIECE EN EL CENTRO DE LA EXPLOSION
			
			switch(s){
				case "derecha":{
					celdaActual = this.obtenerCelda(posX+i,posY);
				}
				break;
				case "izquierda":{
					celdaActual = this.obtenerCelda(posX-i,posY);
				}
				break;
				case "abajo":{
					celdaActual = this.obtenerCelda(posX,posY+i);
				}
				break;
				case "arriba":{
					celdaActual = this.obtenerCelda(posX,posY-i);
				}
				break;
			}
				
			cortar = celdaActual.obtenerPared() != null;
			celdaActual.obtenerGraficos().obtenerImagenActual().setIcon(DireccionExplosion);
			if(cortar){
				//EN LA PARTE LOGICA AQUI DEBERA ACCEDER A LAS CELDAS Y VER QUE MATAR..
				celdaActual.obtenerPared().destruirPared();
			}
			else{
				if(celdaActual.obtenerEnemigos()!= null){
					this.matarEnemigo(celdaActual.obtenerEnemigos(), celdaActual);
				}
			}
		}
	}
	
	/**
	 * Método que explota una bomba
	 * @param bomba de tipo Bomba que representa la Bomba a explotar
	 */
	
	public void explosion (Bomba bomba) {
		bomba.obtenerGraficos().establecerimagenActual(3);
		this.explosionAuxiliar(bomba,2,"derecha");
		this.explosionAuxiliar(bomba,2,"izquierda");
		this.explosionAuxiliar(bomba,1,"arriba");
		this.explosionAuxiliar(bomba,1,"abajo");
	}
	
	/**
	 * Método que incrementa la puntuacion del jugador
	 * @param x de tipo int que representa la cantidad de puntos a sumar
	 */
	
	public void incrementarPuntuacion (int x) {
		marcadorPuntos += x;
		miManejador.establecerPuntaje(marcadorPuntos);
	}

	/**
	 * Método que devuelve el Bomberman asociado al nivel
	 * @return Bomberman que representa el bomberman a devolver
	 */
	
	public Bomberman obtenerBomberman () {
		return miBomberman;
	}
	
	/**
	 * Método que mueve al bomberman en la dirección deseada
	 * @param dir de tipo int que representa la direccion deseada
	 */
	
	
	public void moverBomberman (int dir){
		int x = miBomberman.obtenerPosicion().obtenerX();
		int y = miBomberman.obtenerPosicion().obtenerY();
		
		switch(dir){
			case 0:{
				misCeldas[x-1][y].recibirBomberman(miBomberman,0);
			}
			break;
			case 1:{
				misCeldas[x+1][y].recibirBomberman(miBomberman,1);
			}
			break;
			case 2:{
				misCeldas[x][y-1].recibirBomberman(miBomberman,2);
			}
			break;
			case 3:{
				misCeldas[x][y+1].recibirBomberman(miBomberman,3);
			}
			break;
		}
//		return pude;
	}
		/**
		 * Método que mueve al enemigo
		 * @param e de tipo Enemigo que representa el enemigo a mover
		 * @param dir de tipo int que representa la direccion a mover del enemigo
		 */
	
	public void moverEnemigo (Enemigo e, int dir) {
		int x = e.obtenerPosicion().obtenerX();
		int y = e.obtenerPosicion().obtenerY();
		switch(dir){
			case 0:{
				misCeldas[x-1][y].recibirEnemigo(e,dir);
			}
			break;
			case 1:{
				misCeldas[x+1][y].recibirEnemigo(e,dir);
			}
			break;
			case 2:{
				misCeldas[x][y-1].recibirEnemigo(e,dir);
			}
			break;
			case 3:{
				misCeldas[x][y+1].recibirEnemigo(e,dir);
			}
			break;
		}
	}
	/** Método que se utiliza para matar al Bomberman :(
	 */
	
	public void matarBomberman() {
		miBomberman.detener();
		miBomberman.obtenerGrafico().eliminarImagen();	
	}
	
	/**
	 * Método que se utiliza para matar todos los enemigos que estén en una celda
	 * @param e un arreglo Enemigo que representa los enemigos a matar 
	 */

	public void matarEnemigo(Enemigo[] e, Celda celdaActual) { //VERIFICAR ESTO
		e= celdaActual.obtenerEnemigos();
		for(int j=0; j<e.length; j++){
			if(e[j]!=null){
				celdaActual.matarEnemigo(e[j]);
			}
		}
	}
	
	/**
	 * Método que devuelve la celda asociada a una posicion
	 * @param i de tipo int que representa la posicion en el eje x
	 * @param j de tipo int que representa la posicion en el eje y
	 * @return
	 */
	
	public Celda obtenerCelda(int i, int j){
		return misCeldas[i][j];
	}
	
	/**
	 * Método que devuelve el marcador de tiempo
	 * @return String que representa el tiempo
	 */
	
	public String obtenerMarcadorTiempo(){
		return marcadorTiempo;		
	}
	/**
	 * Establece el valor del marcador de tiempo
	 * @param s Tiempo actual
	 */
	
	public void establecerMarcadorTiempo(String s){
		this.marcadorTiempo = s;
	}
	
	/**
	 * Método que elimina un determinado PowerUp
	 * @param miPowerUp de tipo PowerUp que representa el powerUp a eliminar
	 */

	public void eliminarPowerUp(PowerUp miPowerUp) {
		boolean cortar = false;
		for(int i = 0; i < this.misPowerUps.length && !cortar ; i++){
			cortar = miPowerUp == this.misPowerUps[i];
			if(cortar){
				this.misPowerUps[i] = null; //BUSCO EL POWERUP EN EL ARREGLO Y LO QUITO				
			}
		}		
	}
	
	/**
	 * Método retorna el manejador de la GUI
	 * @return ManejadorGUI que representa un manejador de GUI
	 */
	
	public ManejadorGUI obtenerManejadorGUI(){
		return miManejador;
	}
	
	/**
	 * Método utilizado para restaurar el gráfico de una celda luego de algun evento
	 * @param bomba de tipo Bomba
	 */
	
	private synchronized void restaurarAux(Bomba b, String s){
		int posX = b.obtenerPosicion().obtenerX();
		int posY = b.obtenerPosicion().obtenerY();
		Celda celdaActual=null;

		Icon explosionHorizontal = b.obtenerGraficos().obtenerIconoActual(2);
		Icon explosionVertical = b.obtenerGraficos().obtenerIconoActual(1);
		boolean horizontal=false,vertical=false;
		/*
		if(celdaActual.obtenerBomberman()!=null){
			celdaActual.obtenerBomberman().morir();
		}
		*/
		
		for(int i = 1; i< b.obtenerAlcance() + 1 && (!horizontal || !vertical); i++){ //EL MAS 1 ES PARA QUE NO EMPIECE EN EL CENTRO DE LA EXPLOSION	
			switch(s){
				case "derecha":{
					celdaActual = this.obtenerCelda(posX+i,posY);
				}
				break;
				case "izquierda":{
					celdaActual = this.obtenerCelda(posX-i,posY);
				}
				break;
				case "abajo":{
					celdaActual = this.obtenerCelda(posX,posY+i);
				}
				break;
				case "arriba":{
					celdaActual = this.obtenerCelda(posX,posY-i);
				}
				break;
			}
			horizontal = celdaActual.obtenerGraficos().obtenerImagenActual().getIcon() == explosionHorizontal;
			vertical   = celdaActual.obtenerGraficos().obtenerImagenActual().getIcon() == explosionVertical;
			
			if(horizontal || vertical){
				celdaActual.obtenerGraficos().establecerimagenActual(0);//LE PONE LA IMAGEN DEL PISO
				if(celdaActual.obtenerPowerUp()!=null){
					miManejador.visiblePowerUp(celdaActual.obtenerPowerUp());
				}
			}
		}
	}
	
	

	public void restaurarPiso(Bomba bomba) {
		//QUITA EL LABEL CENTRAL
		bomba.obtenerGraficos().obtenerImagenActual().setVisible(false);
		this.restaurarAux(bomba, "abajo");
		this.restaurarAux(bomba, "arriba");
		this.restaurarAux(bomba, "izquierda");
		this.restaurarAux(bomba, "derecha");
	}
	
	public int obtenerPuntuacion(){
		return marcadorPuntos;
	}
	
}
