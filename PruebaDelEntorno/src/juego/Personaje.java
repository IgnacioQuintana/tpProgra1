package juego;
import java.awt.Image;
import java.awt.Rectangle;
import entorno.*;

public class Personaje {
	private int vidas = 1;
	private Rectangulo cuerpo;
	private int velocidadX;
	private int velocidadY;
	private int anchoDisparo;
	private int altoDisparo;
	private int velocidadDisparo;
	private boolean ultimoMovimientoDerecha;
	private boolean ultimoMovimientoArriba;
	private Image LaykaDer;
	private Image LaykaIzq;
	private Image LaykaDerCo;
	private Image LaykaIzqCo;
	private Image ganaste;
	private Image derrota;
	public int posicionPisoPj;


	
	
	public Personaje( int x, int y,int ancho, int alto, int velocidadX, int velocidadY, int anchoDisparo, int altoDisparo, int velocidadDisparo) {
			this.cuerpo = new Rectangulo(x,y,ancho, alto);
			this.velocidadX = velocidadX;
			this.velocidadY = velocidadY;
			this.anchoDisparo = anchoDisparo;
			this.altoDisparo = altoDisparo;
			this.velocidadDisparo = velocidadDisparo;
			this.ultimoMovimientoDerecha = true;
			this.ultimoMovimientoArriba = true;
			this.posicionPisoPj=500;
		    this.LaykaDer = Herramientas.cargarImagen("media/3.png");
		    this.LaykaIzq = Herramientas.cargarImagen("media/4.png");
		    this.LaykaDerCo = Herramientas.cargarImagen("media/1.png");
		    this.LaykaIzqCo = Herramientas.cargarImagen("media/2.png");
		    this.ganaste = Herramientas.cargarImagen("media/ganaste.png");
		    this.derrota = Herramientas.cargarImagen("media/perdiste.png");	    
	}
	
	public boolean isUltimoMovimientoDerecha() {
		return ultimoMovimientoDerecha;
	}

	public void setUltimoMovimientoDerecha(boolean ultimoMovimientoDerecha) {
		this.ultimoMovimientoDerecha = ultimoMovimientoDerecha;
	}


	
	public int getVidas() {
		return vidas;
	}



	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	


	public Rectangulo getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(Rectangulo cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Image getLaykaDer() {
		return LaykaDer;
	}



	public void setLaykaDer(Image laykaDer) {
		LaykaDer = laykaDer;
	}



	public Image getLaykaIzq() {
		return LaykaIzq;
	}



	public void setLaykaIzq(Image laykaIzq) {
		LaykaIzq = laykaIzq;
	}



	public Image getLaykaDerCo() {
		return LaykaDerCo;
	}



	public void setLaykaDerCo(Image laykaDerCo) {
		LaykaDerCo = laykaDerCo;
	}



	public Image getLaykaIzqCo() {
		return LaykaIzqCo;
	}



	public void setLaykaIzqCo(Image laykaIzqCo) {
		LaykaIzqCo = laykaIzqCo;
	}



	public Image getGanaste() {
		return ganaste;
	}



	public void setGanaste(Image ganaste) {
		this.ganaste = ganaste;
	}



	public Image getDerrota() {
		return derrota;
	}



	public void setDerrota(Image derrota) {
		this.derrota = derrota;
	}

	
	
	
	

}
