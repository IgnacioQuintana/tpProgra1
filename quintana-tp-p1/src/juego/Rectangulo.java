package juego;



public class Rectangulo {
	
	private int x, y ,alto,ancho;
	

	public Rectangulo(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;

	}	
	
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x =x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
