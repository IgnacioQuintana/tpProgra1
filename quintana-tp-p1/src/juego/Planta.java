package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
	private int x;
	private int y;
	private int direccion;
	private boolean muerto;
	private int velocidad=1;
	Image imagenVertical;
	
	public Planta(int x, int y, int direccion) {
		this.x=x;
		this.y=y;
		this.direccion=direccion;
		this.muerto=false;
		if(direccion == 1)
			imagenVertical= Herramientas.cargarImagen("media/PlantaCarnivoraS.png");
		if(direccion == 2)
			imagenVertical= Herramientas.cargarImagen("media/PlantaCarnivoraB.png");
		if(direccion == 3)
			imagenVertical= Herramientas.cargarImagen("media/PlantaCarnivora (1).png");
		if(direccion == 4)
			imagenVertical= Herramientas.cargarImagen("media/PlantaCarnivora.png");
	}
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(imagenVertical, x, y, 0, 0.1);
	}
	
	public void mover() {
		if (direccion == 1) {
			y  -=velocidad;
			if (y < 0) {
				y= 600;
			}		
			return; 			
		}
		if (direccion == 2) {
			y  +=velocidad;
			if (y > 600) {
				y= 0;
			}		
			return; 			
		}
		if (direccion == 3) {
			x  -=velocidad;
			if (x < 0) {
				x= 800;
			}			
			return; 			
		}
		if (direccion == 4) {
			x  +=velocidad;
			if (x > 800) {
				x= 0;
			}		
			return; 			
		}
	
	}
	
	public boolean chocoConEntorno(Entorno e) {
		
		if(this.x < 0 || this.x > e.ancho() || this.y < 0 || this.y > e.alto()) {
			
			return true;
		}
		return false;

	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public double getDireccion() {
		return direccion;
	}
	
	public void setMuerto(boolean muerto) {
		this.muerto=muerto;
	}
	
	public boolean getMuerto() {
		return muerto;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}	
	
	public void setN(int velocidad) {
		this.velocidad=velocidad;
	}
}