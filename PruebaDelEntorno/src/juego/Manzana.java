package juego;

import java.awt.Image;

import entorno.Herramientas;


public class Manzana {
	private Rectangulo cuerpo;
	private Image imagenManzana;
	
	
	public Manzana (int x, int y, int ancho, int alto, String imagen) {
		this.cuerpo = new Rectangulo (x,y,ancho,alto);
		this.imagenManzana = Herramientas.cargarImagen(imagen);
	}


	public Rectangulo getCuerpo() {
		return cuerpo;
	}


	public void setCuerpo(Rectangulo cuerpo) {
		this.cuerpo = cuerpo;
	}


	public Image getManzana() {
		return imagenManzana;
	}


	public void setManzana(Image manzana) {
		imagenManzana = manzana;
	}



	
	
	
}
