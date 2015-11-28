package Grafica;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.BufferedInputStream;
import java.io.File;
import java.util.ArrayList;

public class Sonido extends Thread {
	String miDireccion;
	Boolean continuo;
	Clip sonido;
	public Sonido(String direccion, boolean continuidad){
		miDireccion = "/Sonidos/"+direccion;
		continuo = continuidad;
	}
	
	public void run (){
		try {
            // Se obtiene un Clip de sonido
            sonido = AudioSystem.getClip();
            
            // Se carga con un fichero wav
            BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream(miDireccion));
            sonido.open(AudioSystem.getAudioInputStream(bis));
            
            // Comienza la reproducción
            
            if(continuo){
            	sonido.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else 
            {
            	sonido.start();
            	
            	// Espera mientras se esté reproduciendo.
            	while (sonido.isRunning())
            		Thread.sleep(100);
            	// Se cierra el clip.
            	sonido.close();
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
	}
	
	public void parar(){
		sonido.close();
	}
}
