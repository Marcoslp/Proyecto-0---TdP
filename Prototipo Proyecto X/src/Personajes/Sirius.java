package Personajes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import Logica.*;
import Grafica.*;

/**
 * Clase que modela la lógica de los enemigos Sirius
 * @author Hernán Pocchiola, Marcos Leguizamón, José Ochoa
 */

public class Sirius extends Enemigo {
	
	/*Sirius accede al Bomberman, pide su posición y calcula el camino más
	 *cercano a él, simulando que lo "persigue"
	 */
	
	//Atributos
	
	protected static final  int puntuacion = 50;
	
	//Constructor
	
	public Sirius (int x, int y,Nivel miNivel) {
		super(x,y, miNivel);
		velocidad=6;
		Graficos = new SiriusGrafico(8,x,y);	
		Graficos.establecerVelocidad(velocidad);
	}
	
	//Operaciones
	
	/**
	 * Método utilizado para cuando muere un Sirius
	 */ 
	
	public void morir () {
		miNivel.incrementarPuntuacion(puntuacion);
	}
	
	/**
	 *Método utilizado para cuando se mueve un Sirius
	 */
	
	public void moverse (){
		Vector<Celda> camino;
		camino = this.PathFinder(this.obtenerPosicion().obtenerX(), this.obtenerPosicion().obtenerY(), miNivel.obtenerBomberman().obtenerPosicion().obtenerX(), miNivel.obtenerBomberman().obtenerPosicion().obtenerY());
		int direccion;
		if(camino == null){ // SI NO ENCUENTRA UN CAMINO, SE MUEVE ALEATORIAMENTE
			Random r = new Random();
			direccion = r.nextInt(4);
		}
		else{
			int x = this.obtenerPosicion().obtenerX();
			int y = this.obtenerPosicion().obtenerY();
			Celda proximaCelda = camino.get(0); // ver excepcion
			if(proximaCelda == this.miNivel.obtenerCelda(x-1, y)){
				direccion = 0; // SE MUEVE A LA IZQUIERA
			}
			else{
				if(proximaCelda == this.miNivel.obtenerCelda(x+1, y)){
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
		/*
		 * At initialization add the starting location to the open list and empty the closed list
			While there are still more possible next steps in the open list and we haven’t found the target:
			1 Select the most likely next step (based on both the heuristic and path costs)
			2Remove it from the open list and add it to the closed
			3 Consider each neighbor of the step. For each neighbor:
				Calculate the path cost of reaching the neighbor
				If the cost is less than the cost known for this location then remove it from the open or closed lists (since we’ve now found a better route)
				If the location isn’t in either the open or closed list then record the costs for the location and add it to the open list (this means it’ll be considered in the next search). Record how we got to this location
			The loop ends when we either find a route to the destination or we run out of steps. If a route is found we back track up the records of how we reached each location to determine the path.
		 */
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
		if(miNivel.obtenerCelda(posX, posY).obtenerPared() == null && !estaEnLista(miNivel.obtenerCelda(posX, posY),cerrada)){
			 if(!estaEnLista(miNivel.obtenerCelda(posX, posY),abierta))
					 abierta.add(miNivel.obtenerCelda(posX, posY));
			 padre.put(miNivel.obtenerCelda(posX, posY), actual);
		 }
	}

}
