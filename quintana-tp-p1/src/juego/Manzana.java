package juego;



public class Manzana {
	private Rectangulo cuerpo;

	
	
	public Manzana (int x, int y, int ancho, int alto) {
		this.cuerpo = new Rectangulo (x,y,ancho,alto);;
	}


	public Rectangulo getCuerpo() {
		return cuerpo;
	}


	public void setCuerpo(Rectangulo cuerpo) {
		this.cuerpo = cuerpo;
	}
	
}
