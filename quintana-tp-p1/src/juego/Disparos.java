package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Disparos {
	private int x;
	private int y;	
	private int movimiento;
	Image imgenDisparo;

	public Disparos(int x, int y,int movimiento) {
		this.x=x;
		this.y=y;
		this.movimiento=movimiento;
		
		if(movimiento == 1 || movimiento == 3)
		imgenDisparo = Herramientas.cargarImagen("media/DisparoV.png");
		
		if(movimiento == 4 || movimiento == 2)
		imgenDisparo = Herramientas.cargarImagen("media/DisparoH.png");

	}
	
	public void mover() {
		if (movimiento == 1) {
			y = y -=6;
			return; 			
		}
		if (movimiento == 3) {
			y = y +=6;
			return; 			
		}
		if (movimiento == 4) {
			x = x -=6;
			return; 			
		}
		if (movimiento == 2) {
			x = x +=6;
			return; 			
		}
	}	


	public int impactastePlanta(Planta[] planta) {	
		for(int i = 0; i < planta.length;i++) {
			if(!planta[i].getMuerto()) {
				if (planta[i].getX()+15>=this.x && planta[i].getY()+15>=this.y&&planta[i].getX()-15<=this.x && planta[i].getY()-15<=this.y) {	
					return i;
				}
			}
		}
		return -1;
	}
	
	public int impactasteAuto(Auto[] auto) {	
		for(int i =0;i < auto.length;i++) {
			if(!auto[i].getMuerto()) {
				if (auto[i].getX()+15>=this.x && auto[i].getY()+15>=this.y&&auto[i].getX()-15<=this.x && auto[i].getY()-15<=this.y) {	
					return i;
				}
			}
		}
		return -1;
	}

	public boolean chocoConEntorno(Entorno e) {

		if(this.x < 0 || this.x > e.ancho() || this.y < 0 || this.y > e.alto()) {

			return true;
		}
		return false;

	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imgenDisparo, x, y, 0, 0.1);
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;

	}

}
