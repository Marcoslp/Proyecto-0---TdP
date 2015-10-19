package Lógica;

import Personajes.Bomberman;
import java.util.Random;
import Personajes.Enemigo;
import PowerUps.PowerUp;


public class Nivel {
	
	private static final int largo=31;
	private static final int ancho=13;
	
	//Atributos
	
	protected int marcadorTiempo;
	protected int marcadorPuntos;
	protected Bomberman miBomberman;
	protected Enemigo[] misEnemigos;
	protected Celda [][] misCeldas;
	protected PowerUp [] misPowerUps;
	
	//Constructor
	
	public Nivel (Enemigo[] e, PowerUp [] p) {
		miBomberman = new Bomberman(1,1,this);
		misEnemigos = e;
		misPowerUps = p;
		marcadorPuntos=0;
		
		//Ver como modelar el marcador de tiempo
		
		
		//Creo el arreglo de celdas vacío
		misCeldas= new Celda[largo][ancho];
		for(int i=0; i<largo; i++){
			for(int j=0; j<ancho; j++){
				misCeldas[i][j]= new Celda();
			}
		}
		
		//Inicializo los bordes con paredes indestructibles
		Pared miPared;
		for(int i=0; i<largo; i++){
			miPared= new ParedIndestructible();
			misCeldas[0][i].establecerPared(miPared);
			miPared= new ParedIndestructible();
			misCeldas[12][i].establecerPared(miPared);
		}
		
		for(int j=1; j<ancho-1; j++){
			miPared= new ParedIndestructible();
			misCeldas[j][0].establecerPared(miPared);
			miPared= new ParedIndestructible();
			misCeldas[j][30].establecerPared(miPared);
		}
		
		//Seteo al Bomberman en la posición inicial
		misCeldas[1][1].setBomberman(miBomberman);
		
		//Creo las paredes indestructibles dentro de la grilla
		int cantParedes=0;
		int largoAux=2;
		int anchoAux=2;
			while(largoAux<largo-1){
				while(anchoAux<ancho-1){
				miPared= new ParedIndestructible();
				misCeldas[largoAux][anchoAux].establecerPared(miPared);
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
				if(misCeldas[Px][Py].obtenerPared() == null){
					paredAux= new ParedDestructible();
					misCeldas[Px][Py].establecerPared(paredAux);
					aux++;
				}
				if(aux == (cantParedes/2))
					termine=true;
			}
	}
	
	//Operaciones
	
	public void explosion (Posicion e, int alcance) {
		
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
			case 1:{
				misCeldas[x-1][y].recibirBomberman(miBomberman);
			}
			break;
			case 2:{
				misCeldas[x+1][y].recibirBomberman(miBomberman);
			}
			break;
			case 3:{
				misCeldas[x][y-1].recibirBomberman(miBomberman);
			}
			break;
			case 4:{
				misCeldas[x][y+1].recibirBomberman(miBomberman);
			}
			break;
		}
		//Preguntar :D
		misCeldas[x][y].setBomberman(null);
	}
	
	public void moverEnemigo (Enemigo e) {
		
	}

	public void matarBomberman() {
		
		miBomberman.morir();
		
	}

	public void matarEnemigo() {
		
	}
}
