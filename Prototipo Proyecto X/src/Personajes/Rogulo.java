package Personajes;

import Grafica.ComponenteGrafico;
import Grafica.RoguloGrafico;
import Logica.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;

/**
 * Clase que modela la logica de los enemigos Rogulos
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public class Rogulo extends Enemigo {
	
	//Atributos
	
	protected static final  int puntuacion = 15;
	
	//Constructor
	
	public Rogulo(int x, int y, Nivel miNivel) {
		super(x,y,miNivel);
		this.mDetener = false;
		velocidad=4;
		Graficos = new RoguloGrafico(4,x,y);
		Graficos.establecerVelocidad(velocidad);
	}
	
	//Operaciones
	
	/**
	 * Método que se utiliza cuando muere un Rogulo
	 */
	
	public void morir () {
		miNivel.incrementarPuntuacion(puntuacion);	
		this.destruir();
	}
	
	/**
	 * Método que se utiliza para mover un Rogulo
	 */
			
	public void moverse (){
		Vector<Celda> camino = this.PathFinder(this.obtenerPosicion().obtenerX(), this.obtenerPosicion().obtenerY(), miNivel.obtenerBomberman().obtenerPosicion().obtenerX(), miNivel.obtenerBomberman().obtenerPosicion().obtenerY());
		int direccion;
		if(camino == null){ // SI NO ENCUENTRA UN CAMINO, SE MUEVE ALEATORIAMENTE
			Random r = new Random();
			direccion = r.nextInt(4);
		}
		else{
			int x = this.obtenerPosicion().obtenerX();
			int y = this.obtenerPosicion().obtenerY();
			Celda proximaCelda = camino.get(0);
			if(proximaCelda == this.miNivel.obtenerCelda(x-1, y)){
				direccion = 0; // SE MUEVE A LA IZQUIERA
			}
			else{
				if(proximaCelda == this.miNivel.obtenerCelda(x+1-1, y)){
					direccion = 1; // SE MUEVE A LA DERECHA
				}
				else{
					if(proximaCelda == this.miNivel.obtenerCelda(x, y-1)){
						direccion = 2; // SE MUEVE HACIA ARRIBA
					}
					else{
						direccion = 3; //SE MUEVE HACIA ABAJO
					}
				}
			}
		}
		miNivel.moverEnemigo(this,direccion);

	}
	
	private Vector<Celda> PathFinder(int Sx, int Sy, int Fx, int Fy){
		
		Map<Celda,Celda> Padre = new LinkedHashMap<Celda,Celda>(); //MAPEO QUE SERVIRA PARA HACER BACKTRACKING DEL CAMINO <HIJO,PADRE>
		Vector<Celda> listaAbierta= new Vector<Celda>();
		Vector<Celda> listaCerrada= new Vector<Celda>();
		Celda inicio = miNivel.obtenerCelda(Sx, Sy);
		listaAbierta.add(inicio);
		while(listaAbierta.isEmpty() == false){
		     Celda actual = obtenerNodoMenorCosto(listaAbierta, Fx, Fy);
			 listaAbierta.remove(actual); //ELIMINA EL NODO ACTUAL
			 listaCerrada.add(actual);
			 
			 if(actual.obtenerBomberman() != null){//ENCONTRO EL CAMINO MAS CORTO
				 return this.reconstruirCamino(Padre,inicio, actual);								   //DEVUELVE EL CAMINO
			 }
			 //PROBABLEMENTE NECESITE SER REFACTORIZADO EL CODIGO :)
			 //LAS PROXIMAS SENTENCIAS HACEN LO SIGUIENTE: PARA CARA CELDA VECINA DE ACTUAL 
			 //SE FIJA SI LA CELDA ES ATRAVESABLE O SI ESTA EN LA LISTA CERRADA (SI ES ASI LA IGNORA)
			 //SINO, SINO ESTA EN LA ABIERTA, SETEA COMO CELDA "HIJA DE LA ACTUAL" (PARA PODER BACKTRACKEAR)
			 //Y LA AGREGA A LA LISTA ABIERTA
			 int posXActual = actual.obtenerPosicion().obtenerX(); 
			 int posYActual = actual.obtenerPosicion().obtenerY(); 
			 
			 this.realizarControl(posXActual+1, posYActual, actual, Padre, listaAbierta, listaCerrada);
			 this.realizarControl(posXActual-1, posYActual, actual, Padre, listaAbierta, listaCerrada);
			 this.realizarControl(posXActual, posYActual+1, actual, Padre, listaAbierta, listaCerrada);
			 this.realizarControl(posXActual, posYActual-1, actual, Padre, listaAbierta, listaCerrada);
			
		}
		return null; //NO ENCONTRO CAMINO
		
	}
	
	private Vector<Celda> reconstruirCamino(Map<Celda, Celda> Padre, Celda inicio, Celda fin) {
		Vector<Celda> devolver = new Vector<Celda>();
		while(fin != inicio){  //REALIZA UN BACKTRACKING
			devolver.add(0, fin); //AÑADE LAS CELDA AL PRINCIPIO PARA QUE QUEDE ORDENADO
			fin = Padre.get(fin); //CON EL MAPEO VA CONSIGUIENDO LAS CELDAS PADRE
		}
		return devolver;
	}

	private boolean estaEnLista(Celda c, Vector<Celda> lista) { //VERIFICA QUE ESTE EN LA LISTA
		boolean esta = false;
		for(Celda celda : lista){
			if(celda == c)
				return true;
		}
		return esta;
	}

	private Celda obtenerNodoMenorCosto(Vector<Celda> listaAbierta, int Fx, int Fy) {
		Celda devolver = listaAbierta.firstElement();
		int menorCosto = this.manhattan(devolver.obtenerPosicion().obtenerX(), devolver.obtenerPosicion().obtenerY(), Fx, Fy);
		int costoActual;
		for(Celda c : listaAbierta){ //REVISA CUAL ES LA CELDA CON MENOR COSTO Y LA DEVUELVE
			costoActual = this.manhattan(c.obtenerPosicion().obtenerX() , c.obtenerPosicion().obtenerY(), Fx, Fy);
			if(costoActual < menorCosto){
				menorCosto = costoActual;
				devolver = c;
			}
		}
		return devolver;
	}
	
	private int manhattan(int Sx, int Sy, int Fx, int Fy){ //RETORNA LA HEURISTICA DE MANHATAN
		int dx = Math.abs(Fx - Sx);
		int dy = Math.abs(Fy - Sy);
		return  dx + dy;
	}
	
	
	 //SE FIJA SI LA CELDA ES ATRAVESABLE O SI ESTA EN LA LISTA CERRADA (SI ES ASI LA IGNORA)
	 //SINO, SINO ESTA EN LA ABIERTA, SETEA COMO CELDA "HIJA DE LA ACTUAL" (PARA PODER BACKTRACKEAR)
	 //Y LA AGREGA A LA LISTA ABIERTA
	private void realizarControl(int posX, int posY, Celda actual, Map<Celda,Celda> padre, Vector<Celda> abierta, Vector<Celda> cerrada){
		System.out.println("POSICION " +posX+" " + posY);
		if(miNivel.obtenerCelda(posX, posY).obtenerPared() == null && !estaEnLista(miNivel.obtenerCelda(posX, posY),cerrada)){
			 if(!estaEnLista(miNivel.obtenerCelda(posX, posY),abierta))
					 abierta.add(miNivel.obtenerCelda(posX, posY));
			 padre.put(miNivel.obtenerCelda(posX, posY), actual);
		 }
	}
}