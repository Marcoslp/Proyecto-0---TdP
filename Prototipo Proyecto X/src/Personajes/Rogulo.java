package Personajes;

import Grafica.ComponenteGrafico;
import Lógica.*;

import java.util.Random;

import javax.swing.ImageIcon;

public class Rogulo extends Enemigo {
	
	//Atributos
	
	protected static final  int puntuacion = 15;
	
	//Constructor
	
	public Rogulo(int x, int y) {
		super(x,y);
		Graficos = new ComponenteGrafico(4);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/RoguloI.png")), 0);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/RoguloD.png")), 1);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/RoguloAR.png")), 2);
		Graficos.establecerImagen(new ImageIcon(this.getClass().getResource("/Imagenes/RoguloA.png")), 3);
		Graficos.establecerimagenActual(3);
		Graficos.obtenerImagenActual().setBounds(x*32, y*32, Graficos.obtenerAncho(), Graficos.obtenerAlto());
	}
	
	//Operaciones
	
	public void morir () {
		miNivel.matarEnemigo(this);
		miNivel.incrementarPuntuacion(puntuacion);	
	}
	
	public void moverse (){
		Random r = new Random ();
		int i = r.nextInt(4);
		System.out.println(i);
		miNivel.moverEnemigo(this,i);
	}
}