package Lógica;

import Personajes.Bomberman;
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
		miBomberman = new Bomberman(1,1);
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
			misCeldas[0][i]= new Celda(miPared);
		}
		
		for(int j=0; j<ancho; j++){
			miPared= new ParedIndestructible();
			misCeldas[j][0]= new Celda(miPared);
		}
		
		//Seteo la posición del Bomberman
		misCeldas[1][1].setBomberman(miBomberman);
		
		//Creo las paredes indestructibles dentro de la grilla
		int largoAux=2;
		int anchoAux=2;
			while(largoAux<largo-1){
				while(anchoAux<ancho-1){
				miPared= new ParedIndestructible();
				misCeldas[largoAux][anchoAux]= new Celda(miPared);
				anchoAux+=2;
				}
				largoAux+=2;
				anchoAux=2;
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
	
	public void moverBomberman (int Direccion) {
		
	}
	
	public void MoverEnemigo (Enemigo e) {
		
	}
}
