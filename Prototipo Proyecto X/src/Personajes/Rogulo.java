package Personajes;

import Grafica.ComponenteGrafico;
import Lógica.*;

import java.util.Random;

import javax.swing.ImageIcon;

public class Rogulo extends Enemigo {
	
	//Atributos
	
	protected static final  int puntuacion = 15;
	
	//Constructor
	
	public Rogulo(int x, int y, Nivel miNivel) {
		super(x,y,miNivel);
		this.mDetener = false;
		Graficos = new ComponenteGrafico(4);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ricky.jpg")), 0);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ricky.jpg")), 1);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ricky.jpg")), 2);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/ricky.jpg")), 3);
		Graficos.establecerimagenActual(3);
		Graficos.obtenerImagenActual().setBounds(x*32, y*32, Graficos.obtenerAncho(), Graficos.obtenerAlto());
	}
	
	//Operaciones
	
	public void morir () {
		miNivel.matarEnemigo(this);
		miNivel.incrementarPuntuacion(puntuacion);	
	}
	
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.mDetener){
			try {
				Thread.sleep(1000);
				this.moverse();
			} catch (InterruptedException e) { }
		}
	}
	public void detener() {
		this.interrupt(); 
		this.mDetener = true;
	}
	
	public void destruir() {
		this.detener();
		this.morir();
	}
	
	public void moverse (){
		Random r = new Random ();
		int i = r.nextInt(4);
		Graficos.establecerimagenActual(i);
		miNivel.moverEnemigo(this,i);
	}
}