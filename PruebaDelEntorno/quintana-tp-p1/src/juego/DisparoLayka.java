package juego;
import java.awt.Rectangle;

public class DisparoLayka {
	private Rectangle cuerpo;
	private int velocidadX;
	
	public DisparoLayka(int x, int y, int ancho, int alto, int velocidadX)
	{
		this.cuerpo = new Rectangle(x,y,ancho,alto);
		this.velocidadX = velocidadX;
	}
	
	public void avanzar()
	{
		this.cuerpo.x += velocidadX;
	}
	
	public Rectangle cuerpo()
	{
		return this.cuerpo;
	}
	
}


