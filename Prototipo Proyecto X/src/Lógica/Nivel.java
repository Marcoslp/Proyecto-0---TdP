package Lógica;

import Grafica.GUI;
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
	protected Enemigo[] misEnemigos;
	protected Celda [][] misCeldas;
	protected PowerUp [] misPowerUps;
	
	//Constructor
	
	public Nivel (GUI miGui) {
		//miBomberman = new Bomberman(1,1,this);
		//misPowerUps = p;
		marcadorPuntos=0;
		
		//Ver como modelar el marcador de tiempo
		
		
		//Creo el arreglo de celdas vacío
		misCeldas= new Celda[largo][ancho];
		for(int i=0; i<largo; i++){
			for(int j=0; j<ancho; j++){
				misCeldas[i][j]= new Celda(i,j,this);
				miGui.add(misCeldas[i][j].obtenerGraficos().obtenerImagenActual());
			}
		}
		
		//Inicializo los bordes con paredes indestructibles
		/*Pared miPared;
		for(int i=1; i<largo; i++){ //hasta 31
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
		*/
		/*
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
			
			misEnemigos = new Enemigo [6];
			termine = false;
			int i = 0;
			while (i < 3){
				int Ex= rnd.nextInt(30);
				int Ey= rnd.nextInt(12);
				if(misCeldas[Ex][Ey].obtenerPared() == null){
					misEnemigos[i] = new Rogulo (Ex,Ey);
					i++;
					}
				}
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
	}
		
	
	public void moverEnemigo (Enemigo e, int dir) {
		int x = e.obtenerPosicion().obtenerX();
		int y = e.obtenerPosicion().obtenerY();
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
