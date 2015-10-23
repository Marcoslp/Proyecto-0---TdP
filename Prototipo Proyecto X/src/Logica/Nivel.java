package Logica;

import Grafica.GUI;
import Grafica.ManejadorGUI;
import Personajes.*;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.JLabel;

import PowerUps.Fatality;
import PowerUps.PowerUp;
import PowerUps.SpeedUp;
import Threads.ContadorBomba;


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
			Pared paredAux;
			int total= contadorCelda - cantParedes;
			int aux=0;
			// INICIALIZACION PAREDES DESTRUCTIBLES
			while(!termine){
				int Px= rnd.nextInt(31);
				int Py= rnd.nextInt(13);
				if(misCeldas[Px][Py].obtenerPared() == null){ //EVITA QUE SE PONGA ARRIBA DEL BOMBERMAN Y LOS POWERUPS, PROVISORIO. SE HARIA UN PRIVADO QUE CONTROLE MAS POSICIONES PROHIBIDAS
					if(misCeldas[Px][Py] != misCeldas[1][1]){
						paredAux= new ParedDestructible(misCeldas[Px][Py]);
						misCeldas[Px][Py].establecerPared(paredAux);
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
			
			//SE INICIALIZAN LOS POWERUPS
			//POR SER UN PROTOTIPO DE PRUEBA SOLAMENTE CREO 2 Y LOS AGREGO A POSICIONES ARBITRARIAS
			//SINO SERIA NECESARIO PODER DESTRUIR LAS PAREDES DESTRUCTIBLES
			//INICIALIZO EL SPEED UP PROVISORIO
			this.misPowerUps = new PowerUp[11]; 
			
			this.misPowerUps[0] = new SpeedUp(1,2,this.misCeldas[1][2]);
		    misCeldas[1][2].establecerPowerUp(misPowerUps[0]);
		    miManejador.añadirPowerUp(misPowerUps[0]);
			 
		    //INICIALIZO EL FATALITY
		    
		   	this.misPowerUps[1] = new Fatality(1,5,this.misCeldas[1][5]);
		    misCeldas[1][5].establecerPowerUp(misPowerUps[1]);
			miManejador.añadirPowerUp(misPowerUps[1]);
	}
	
	//Operaciones
	
	//Método auxiliar para explotar la bomba
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
					Enemigo[] enem= celdaActual.obtenerEnemigos();
					for(int j=0; j<enem.length; j++){
						if(enem[j]!=null){
							celdaActual.matarEnemigo(enem[j]);
							celdaActual.eliminarEnemigo(enem[j]);
						}
					}
				}
			}
		}
	}
	
	public void explosion (Bomba bomba) {
		bomba.obtenerGraficos().establecerimagenActual(3);
		this.explosionAuxiliar(bomba,2,"derecha");
		this.explosionAuxiliar(bomba,2,"izquierda");
		this.explosionAuxiliar(bomba,1,"arriba");
		this.explosionAuxiliar(bomba,1,"abajo");
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
		miBomberman.detener();
		miBomberman.obtenerGrafico().eliminarImagen();	
	}

	public void matarEnemigo(Enemigo e) {
		
	}
	
	public Celda obtenerCelda(int i, int j){
		return misCeldas[i][j];
	}
	
	public int obtenerMarcadorTiempo(){
		return marcadorTiempo;		
	}

	public void eliminarPowerUp(PowerUp miPowerUp) {
		boolean cortar = false;
		for(int i = 0; i < this.misPowerUps.length && !cortar ; i++){
			cortar = miPowerUp == this.misPowerUps[i];
			if(cortar){
				this.misPowerUps[i] = null; //BUSCO EL POWERUP EN EL ARREGLO Y LO QUITO				
			}
		}		
	}
	
	public ManejadorGUI obtenerManejadorGUI(){
		return miManejador;
	}

	public void restaurarPiso(Bomba bomba) {
		boolean cortar;
		//QUITA EL LABEL CENTRAL
		bomba.obtenerGraficos().obtenerImagenActual().setVisible(false);
		//CICLO QUE LIMPIA A LA DERECHA
		cortar = false;
		Icon explosionHorizontal = bomba.obtenerGraficos().obtenerIconoActual(2);
		Icon explosionVertical = bomba.obtenerGraficos().obtenerIconoActual(1);
		int posX = bomba.obtenerPosicion().obtenerX();
		int posY = bomba.obtenerPosicion().obtenerY();
		for(int i = 1; i< bomba.obtenerAlcance() + 1 && !cortar; i++){ //EL MAS 1 ES PARA QUE NO EMPIECE EN EL CENTRO DE LA EXPLOSION
			Celda celdaActual = this.obtenerCelda(posX+i,posY);
			cortar = celdaActual.obtenerGraficos().obtenerImagenActual().getIcon() != explosionHorizontal; //SE FIJA QUE HAYA SIDO UN LUGAR EN EL QUE EXPLOTO LA BOMBA
			if(!cortar){	//SI EXPLOTO EN ESA PARTE, RESTAURA LA IMAGEN PRINCIPAL
				celdaActual.obtenerGraficos().establecerimagenActual(0); //LE PONE LA IMAGEN DEL PISO
			}			
		}
		//CICLO QUE LIMPIA A LA IZQ
		cortar = false;
		for(int i = 1; i< bomba.obtenerAlcance() + 1 && !cortar; i++){ //EL MAS 1 ES PARA QUE NO EMPIECE EN EL CENTRO DE LA EXPLOSION
			Celda celdaActual = this.obtenerCelda(posX-i,posY);
			cortar = celdaActual.obtenerGraficos().obtenerImagenActual().getIcon() != explosionHorizontal; //SE FIJA QUE HAYA SIDO UN LUGAR EN EL QUE EXPLOTO LA BOMBA
			if(!cortar){	//SI EXPLOTO EN ESA PARTE, RESTAURA LA IMAGEN PRINCIPAL
				celdaActual.obtenerGraficos().establecerimagenActual(0); //LE PONE LA IMAGEN DEL PISO
			}			
		}
		//CICLO QUE LIMPIA ARRIBA
		cortar = false;
		for(int i = 1; i< bomba.obtenerAlcance() + 1 && !cortar; i++){ //EL MAS 1 ES PARA QUE NO EMPIECE EN EL CENTRO DE LA EXPLOSION
			Celda celdaActual = this.obtenerCelda(posX,posY-i);
			cortar = celdaActual.obtenerGraficos().obtenerImagenActual().getIcon() != explosionVertical; //SE FIJA QUE HAYA SIDO UN LUGAR EN EL QUE EXPLOTO LA BOMBA
			if(!cortar){	//SI EXPLOTO EN ESA PARTE, RESTAURA LA IMAGEN PRINCIPAL
				celdaActual.obtenerGraficos().establecerimagenActual(0); //LE PONE LA IMAGEN DEL PISO
			}			
		}
		//CICLO QUE LIMPIA ABAJO
		cortar = false;
		for(int i = 1; i< bomba.obtenerAlcance() + 1 && !cortar; i++){ //EL MAS 1 ES PARA QUE NO EMPIECE EN EL CENTRO DE LA EXPLOSION
			Celda celdaActual = this.obtenerCelda(posX,posY+i);
			cortar = celdaActual.obtenerGraficos().obtenerImagenActual().getIcon() != explosionVertical; //SE FIJA QUE HAYA SIDO UN LUGAR EN EL QUE EXPLOTO LA BOMBA
			if(!cortar){	//SI EXPLOTO EN ESA PARTE, RESTAURA LA IMAGEN PRINCIPAL
				celdaActual.obtenerGraficos().establecerimagenActual(0); //LE PONE LA IMAGEN DEL PISO
			}			
		}
		
	}

}
