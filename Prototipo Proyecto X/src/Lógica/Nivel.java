package L�gica;

import Grafica.GUI;
import InteligenciaEnemigos.EnemigoThread;
import Personajes.*;

import java.util.Random;

import PowerUps.PowerUp;


public class Nivel {
	
	private static final int largo=31;
	private static final int ancho=13;
	
	//Atributos
	
	protected int marcadorTiempo;
	protected int marcadorPuntos;
	protected Bomberman miBomberman;
	protected EnemigoThread[] misEnemigos;
	protected Celda [][] misCeldas;
	protected PowerUp [] misPowerUps;
	
	//Constructor
	
	public Nivel (GUI miGui) {
		miBomberman = new Bomberman(1,1,this);
		miGui.add(miBomberman.obtenerGrafico().obtenerImagenActual());
		//misPowerUps = p;
		marcadorPuntos=0;
		
		//Ver como modelar el marcador de tiempo
		
		
		//Creo el arreglo de celdas vac�o
		misCeldas= new Celda[largo][ancho];
		for(int i=0; i<largo; i++){
			for(int j=0; j<ancho; j++){
				misCeldas[i][j]= new Celda(i,j,this);
				miGui.add(misCeldas[i][j].obtenerGraficos().obtenerImagenActual());
				
			}
		}
		
		//Inicializo los bordes con paredes indestructibles
		
		for(int i=0; i<largo; i++){ //hasta 31
			
			misCeldas[i][0].establecerPared(new ParedIndestructible(misCeldas[i][0]));
			
			misCeldas[i][12].establecerPared(new ParedIndestructible(misCeldas[i][12]));
		}
		
		for(int j=0; j<ancho; j++){
			
			misCeldas[0][j].establecerPared(new ParedIndestructible(misCeldas[0][j]));
			
			misCeldas[30][j].establecerPared(new ParedIndestructible(misCeldas[30][j]));
		}
		
		
		//Seteo al Bomberman en la posici�n inicial
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
			Pared paredAux;
			int aux=0;
			
			while(!termine){
				int Px= rnd.nextInt(30);
				int Py= rnd.nextInt(12);
				if(misCeldas[Px][Py].obtenerPared() == null && (Px!= 0 && Py!=0)){
					paredAux= new ParedDestructible(misCeldas[Px][Py]);
					misCeldas[Px][Py].establecerPared(paredAux);
					aux++;
				}
				if(aux == (cantParedes/2))
					termine=true;
			}
			
			/*
			 * 	this.mMalos = new MaloThread[3];
		for(int i = 0; i < this.mMalos.length; i++){
			Random r = new Random();
			
			Malo malo = new Malo(10, r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32));
			this.mMalos[i] = new MaloThread(malo);
			gui.add(malo.getGrafico());
			
			this.mMalos[i].start();
		}
		**/
			misEnemigos = new EnemigoThread [6];
			termine = false;
			int i = 0;
			while (i < 6){
				int Ex= rnd.nextInt(30);
				int Ey= rnd.nextInt(12);
				if(misCeldas[Ex][Ey].obtenerPared() == null){
					misEnemigos[i] = new EnemigoThread(new Rogulo (Ex,Ey));
					misEnemigos[i].run();
					miGui.add(misEnemigos[i].obtenerLogica().obtenerGrafico().obtenerImagenActual());
					i++;					
					}
				}
			/*
				while (i<5) {
					int Fx= rnd.nextInt(30);
					int Fy= rnd.nextInt(12);
					if(misCeldas[Fx][Fy].obtenerPared() == null){
						misEnemigos[i] = new Altair (Fx,Fy);
						i++;
						}
				}
				misEnemigos[5] = new Sirius (29,11);
				}*/
			
	}
	
	//Operaciones
	
	public void explosion (Posicion e, Bomba bomb) {
		
		
		
	}
	
	public void incrementarPuntuacion (int x) {
		marcadorPuntos += x;
	}
	
	public void bombermanPisoPowerUp () {
		
	}
	
	public Bomberman obtenerBomberman () {
		return miBomberman;
	}
	
	public void moverBomberman (int dir){
		int x = miBomberman.obtenerPosicion().obtenerX();
		int y = miBomberman.obtenerPosicion().obtenerY();
		switch(dir){
			case 0:{
				misCeldas[x-1][y].recibirBomberman(miBomberman);
			}
			break;
			case 1:{
				misCeldas[x+1][y].recibirBomberman(miBomberman);
			}
			break;
			case 2:{
				misCeldas[x][y-1].recibirBomberman(miBomberman);
			}
			break;
			case 3:{
				misCeldas[x][y+1].recibirBomberman(miBomberman);
			}
			break;
		}
	}
		
	
	public void moverEnemigo (Enemigo e, int dir) {
		int x = e.obtenerPosicion().obtenerX();
		int y = e.obtenerPosicion().obtenerY();
		switch(dir){
			case 0:{
				misCeldas[x-1][y].recibirEnemigo(e);
			}
			break;
			case 1:{
				misCeldas[x+1][y].recibirEnemigo(e);
			}
			break;
			case 2:{
				misCeldas[x][y-1].recibirEnemigo(e);
			}
			break;
			case 3:{
				misCeldas[x][y+1].recibirEnemigo(e);
			}
			break;
		}
	}

	public void matarBomberman() {
		miBomberman.morir();	
	}

	public void matarEnemigo(Enemigo e) {
		
	}
	
	public Celda obtenerCelda(int i, int j){
		return misCeldas[i][j];
	}
	
	public int obtenerMarcadorTiempo(){
		return marcadorTiempo;		
	}
}
