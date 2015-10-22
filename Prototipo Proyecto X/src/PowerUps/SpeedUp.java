package PowerUps;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Lógica.Celda;
import Personajes.Bomberman;


public class SpeedUp extends PowerUp  {
	
	//Atributos
	
	//Constructor
	
	public SpeedUp (int x, int y, Celda miCelda) {
		super(x,y,miCelda);
		this.miImagen = new JLabel (new ImageIcon(this.getClass().getResource("/Imagenes/SpeedUp.png")));
		this.miImagen.setBounds(12*32, 13*32, 32, 32);
	}
	
	//Operaciones
	
	public void empower (Bomberman b) {
		b.DuplicarVelocidad();
		
	}

}
