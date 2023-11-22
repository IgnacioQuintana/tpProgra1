package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.*;

public class Personaje {
	private Rectangulo cuerpo;
	private double velocidad;
	private Image LaykaDer;
	private int xAnterior, yAnterior;

	public Personaje(int x, int y,int ancho, int alto) {
		this.cuerpo = new Rectangulo (x,y,ancho,alto);
		this.velocidad = 2;
		this.xAnterior=x;
		this.yAnterior=y ;
		this.LaykaDer = Herramientas.cargarImagen("media/3.png");
	}



	public void dibujar(Entorno e) {
		e.dibujarImagen(LaykaDer, this.cuerpo.getX(), this.cuerpo.getY(), 0, 0.1);
	}
	

	public void moverIzquierda() {
		int a = this.cuerpo.getX();
		xAnterior = this.cuerpo.getX();
		this.cuerpo.setX(a-=velocidad);
		if (this.cuerpo.getX()<=10) {
			this.cuerpo.setX(10);
		}
	}

	public void moverDerecha() {
		int a = this.cuerpo.getX();
		xAnterior = this.cuerpo.getX();
		this.cuerpo.setX(a+=velocidad);
		if (this.cuerpo.getX()>=790) {
			this.cuerpo.setX(790);
		}
	}

	public void moverArriba() {
		int a = this.cuerpo.getY();
		yAnterior = this.cuerpo.getY();
		this.cuerpo.setY(a-=velocidad);
		if (this.cuerpo.getY()<=15) {
			this.cuerpo.setY(15);
		}
	}

	public void moverAbajo() {
		int a = this.cuerpo.getY();
		yAnterior = this.cuerpo.getY();
		this.cuerpo.setY(a+=velocidad);
		if (this.cuerpo.getY()>=570) {
			this.cuerpo.setY(570);
		}

	}
/*
	public boolean colisionVertical() {
		System.out.println("es la x: " + this.x + " es la Y: "+ this.y);
		//Manzanas de arriba
		if(this.y-15 < 80 && this.y > 0 && (this.y-15 < 80 && this.y > 0)&&
				(this.y-15 < 80 && this.y > 0) && (this.y-15 < 80 && this.y > 0)) 
			return true;
			//Manzanas del medio
		if(this.y-15 < 415 && this.y > 120)
			return true;
		if(this.y-15 < 415 && this.y > 120)
			return true;
		if(this.y-15 < 415 && this.y > 120)
			return true;
		if(this.y-15 < 415 && this.y > 120)
			//Manzanas De Abajo
		if(this.y-15 < 600 && this.y > 430)
			return true;
		if(this.y-15 < 600 && this.y > 120)
			return true;
		if(this.y-15 < 600 && this.y > 120)
			return true;
		if(this.y-15 < 600 && this.y > 120)
			return true;
		return false;
	}
	public boolean colisionHorizontal() {
		//las 4 manzanas superiores
		if(this.x > 0 && this.x-10 <57)
			return true;
		if(this.x > 100 && this.x-10 <388)
			return true;
		if(this.x > 435 && this.x-10 <602)
			return true;
		if(this.x > 650 && this.x-10 <800)
			return true;
		
		//las 4 manzanas del medio
		if(this.x > 0 && this.x-10 <57)
			return true;
		if(this.x > 100 && this.x-10 <388)
			return true;
		if(this.x > 435 && this.x-10 <602)
			return true;
		if(this.x > 650 && this.x-10 <800)
			return true;
		
		//las 4 manzanas inferiores
		if(this.x > 0 && this.x-10 <57)
			return true;
		if(this.x > 100 && this.x-10 <388)
			return true;
		if(this.x > 435 && this.x-10 <602)
			return true;
		if(this.x > 650 && this.x-10 <800)
			return true;
		return false;
	}
*/

	public boolean chocasteConAutoEnX(Auto[] auto) {
		for (int i = 0; i < auto.length; i++) {
			if (!auto[i].getMuerto()) {
				if (auto[i].getX() + 10 >= this.cuerpo.getX() - 10 && auto[i].getY() <= this.cuerpo.getY() + 15
						&& auto[i].getX() - 10 <= this.cuerpo.getX() + 10 && auto[i].getY() >= this.cuerpo.getY() - 15) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean chocasteConAutoEnY(Auto[] auto) {
		for(int i =0;i < auto.length;i++) {
			if(!auto[i].getMuerto()) {
				if (auto[i].getY()+5>=this.cuerpo.getY()-5 && auto[i].getX()<=this.cuerpo.getX()+5&&auto[i].getY()-5<=this.cuerpo.getY()+5 && auto[i].getX()>=this.cuerpo.getX()-5) {
					return true;
				}
			}					
		}
		return false;
	}
	
	public boolean chocasteConPlantaEnX(Planta[] planta) {
		for (int i = 0; i < planta.length; i++) {
			if (!planta[i].getMuerto()) {
				if (planta[i].getX() + 10 >= this.cuerpo.getX() - 10 && planta[i].getY() <= this.cuerpo.getY() + 15
						&& planta[i].getX() - 10 <= this.cuerpo.getX() + 10 && planta[i].getY() >= this.cuerpo.getY() - 15) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean chocasteConPlantaEnY(Planta[] planta) {
		for(int i =0;i < planta.length;i++) {
			if(!planta[i].getMuerto()) {
				if (planta[i].getY()+15>=this.cuerpo.getY()-15 && planta[i].getX()<=this.cuerpo.getX()+10&&planta[i].getY()-15<=this.cuerpo.getY()+15 && planta[i].getX()>=this.cuerpo.getX()-10) {
					return true;
				}
			}					
		}
		return false;
	}
	
	public int getX() {
		return this.cuerpo.getX();
	}
	public void setX(int x) {
		this.cuerpo.setX(x);
	}

	public int getY() {
		return this.cuerpo.getY();
	}
	public void setY(int y) {
		this.cuerpo.setY(y);
	}
	
	public double getVelocidad(){
		return velocidad;
	}
	
	public double setVelocidad(double velocidad) {
		 return this.velocidad=velocidad;
	}
	
    public int getXAnterior() {
        return xAnterior;
    }

    public int getYAnterior() {
        return yAnterior;
    }
	
	/*
	public boolean evaluarCondi(Manzana manzana) {
		System.out.println("el x: " + manzana.getCuerpo().getX() +" es el y: " + manzana.getCuerpo().getY());
		if(manzana.getCuerpo().getY()==this.y || manzana.getCuerpo().getX()==this.x) {
			System.out.println("hola");
			return true;}
		return false;
	}*/


	public Rectangulo getCuerpo() {
		return cuerpo;
	}
	
	
	

}
