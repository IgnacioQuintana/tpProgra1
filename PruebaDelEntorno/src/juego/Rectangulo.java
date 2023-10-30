package juego;

public class Rectangulo {
	
	private int x, y ,alto,ancho;

	public Rectangulo(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	}
	
	
	
	public void moverDerecha(){
		if (this.x>=900) {
			this.x=900;
			
		}	
		this.x+= 2;
		
	}
	
	public void moverArriba() {
		if (this.y<=0) {
			this.y=0;
		}
		this.y-= 2;
		
	}
	
	public void moverAbajo() {
		
		if(this.y>=600) {
			this.y=600;
			
	}
		this.y+= 2;
		
	}
	
	public void moverIzquierda() {
		if(this.x<=0) {		
			this.x=0;

		}
		this.x -=2;

	}
	
	
	
	public void trasladar(int dx, int dy)
	{
		x += dx;
		y += dy;
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	


	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	public void subirpiso(int rx,int ry) {
	    this.x = rx;
	    this.y = ry;
	}
	public void tamaño(int a) {
		this.alto = a;
				
	}
	
	
	
	

}
