package juego;


import java.awt.Color;



import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;


public class Juego extends InterfaceJuego {
	private Personaje Layka;
	private Manzana manzana,manzana1,manzana2,manzana3,manzana4,manzana5,manzana6,manzana7;
	

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Plantas Invasoras - Grupo 13 - Quintana - V0.01", 900, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		Layka = new Personaje(450, 300, 40, 60, 2, 2, 10, 10, 5);
		crearManzanas();
		
		
		//No funciona nose porq.   Herramientas.cargarSonido("media/musicaFondo.wav");
		
		
		// Inicia el juego!
		this.entorno.iniciar();	
		
	}	
	/**
	 * Durante el juego, el m√©todo tick() ser√° ejecutado en cada instante y 
	 * por lo tanto es el m√©todo m√°s importante de esta clase. Aqu√≠ se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...
		Mapa();
		
				//genera las manzanas en rectangulos
		
		
		if (colisiona(Layka.getCuerpo(), manzana.getCuerpo())) {
			System.out.println("No funciona");
		}
		
		
		
		
		
		//Imagen de Layka
		imprimirLayka();
		movimientoLayka();

	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	
	//DIBUJA A LAYKA
	public void imprimirLayka() {
		if (Layka.isUltimoMovimientoDerecha() == true) {
			entorno.dibujarImagen(Layka.getLaykaDer(), Layka.getCuerpo().getX(), Layka.getCuerpo().getY(), 0, 0.2);	
			}
		if (Layka.isUltimoMovimientoDerecha() == true && (entorno.estaPresionada('d') || entorno.estaPresionada('D') || entorno.estaPresionada(entorno.TECLA_DERECHA)) ) {
			entorno.dibujarImagen(Layka.getLaykaDerCo(),Layka.getCuerpo().getX(), Layka.getCuerpo().getY(), 0, 0.2);	
			}
		if (Layka.isUltimoMovimientoDerecha() == false) {
		entorno.dibujarImagen(Layka.getLaykaIzq(), Layka.getCuerpo().getX(), Layka.getCuerpo().getY(), 0, 0.2);	
	}
		
		if (Layka.isUltimoMovimientoDerecha() == true && (entorno.estaPresionada('a') || entorno.estaPresionada('A') || entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) ) {
			entorno.dibujarImagen(Layka.getLaykaIzqCo(),Layka.getCuerpo().getX(), Layka.getCuerpo().getY(), 0, 0.2);	
			}
	}
	//VERIFICA EL MOVIMIENTO DE LAYKA
	public void movimientoLayka () {
		
		if (entorno.estaPresionada('w') || entorno.estaPresionada(entorno.TECLA_ARRIBA) || entorno.estaPresionada('W')) {
			Layka.getCuerpo().moverArriba();
		}
		if (entorno.estaPresionada('d') || entorno.estaPresionada(entorno.TECLA_DERECHA) || entorno.estaPresionada('D') ) {
			Layka.getCuerpo().moverDerecha();
		}
		if (entorno.estaPresionada('s') || entorno.estaPresionada(entorno.TECLA_ABAJO) || entorno.estaPresionada('S') ) {
			Layka.getCuerpo().moverAbajo();
		}
		if (entorno.estaPresionada('a') || entorno.estaPresionada(entorno.TECLA_IZQUIERDA) || entorno.estaPresionada('A') ) {
			Layka.getCuerpo().moverIzquierda();
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	
	//VERIFICA LAS COLISIONES
	
	public static boolean colisiona(Rectangulo rectangulo1, Rectangulo rectangulo2) {
	    if (rectangulo1.getX() + rectangulo1.getAncho()< rectangulo2.getX() || rectangulo1.getX() > rectangulo2.getX() + rectangulo2.getAncho()) {
	        return false; // No hay colisiÛn en el eje X
	    }
	    if (rectangulo1.getY() + rectangulo1.getAlto() < rectangulo2.getY() || rectangulo1.getY() > rectangulo2.getY() + rectangulo2.getAlto()) {
	        return false; // No hay colisiÛn en el eje Y
	    }
	    return true; // Hay colisiÛn en ambos ejes
	}
	
	public boolean funcionColision(int posXelemento1, int posXelemento2, int posYelemento1, int posYelemento2, int rangoDerecha,  int rangoIzq){
		if (posXelemento1 <= posXelemento2 + rangoDerecha  && posYelemento1 == posYelemento2 && posXelemento1 >= posXelemento2 - rangoIzq) {  
			return true;
		 }
		else{
			return false;
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	
	//INICIALIZA LAS MANZANAS
	
	public void crearManzanas() {
		this.manzana = new Manzana (150,180,100,160,"media/ManzanaSuperiorIzquierda.JPG");		
		this.manzana1= new Manzana (350,180,100,160,"media/ManzanaSuperiorCentral.JPG");		
		this.manzana2=new Manzana (550,180,100,160,"media/ManzanaSuperiorCentral.JPG");		
		this.manzana3=new Manzana (750,180,100,160,"media/ManzanaSuperiorIzquierda.JPG");
		
		
		this.manzana4=new Manzana (150,440,100,160,"media/ManzanaInferiorIzquierda.JPG");
		this.manzana5=new Manzana (350,440,100,160,"media/ManzanaInferiorIzquierda.JPG");
		this.manzana6=new Manzana (550,440,100,160,"media/ManzanaSuperiorCentral.JPG");
		this.manzana7=new Manzana (750,440,100,160,"media/ManzanaSuperiorIzquierda.JPG");

	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	
	//DIBUJA LAS MANZANAS
	
	public void Mapa () {
		//Manzanas de arriba
		entorno.dibujarImagen(manzana.getManzana(), manzana.getCuerpo().getX(), manzana.getCuerpo().getY(), 0);
		entorno.dibujarImagen(manzana1.getManzana(), manzana1.getCuerpo().getX(), manzana1.getCuerpo().getY(), 0);
		entorno.dibujarImagen(manzana2.getManzana(), manzana2.getCuerpo().getX(), manzana2.getCuerpo().getY(), 0);
		entorno.dibujarImagen(manzana3.getManzana(), manzana3.getCuerpo().getX(), manzana3.getCuerpo().getY(), 0);
		//Manzanas de Abajo
		entorno.dibujarImagen(manzana4.getManzana(), manzana4.getCuerpo().getX(), manzana4.getCuerpo().getY(), 0);
		entorno.dibujarImagen(manzana5.getManzana(), manzana5.getCuerpo().getX(), manzana5.getCuerpo().getY(), 0);
		entorno.dibujarImagen(manzana6.getManzana(), manzana6.getCuerpo().getX(), manzana6.getCuerpo().getY(), 0);
		entorno.dibujarImagen(manzana7.getManzana(), manzana7.getCuerpo().getX(), manzana7.getCuerpo().getY(), 0);
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------------------------------------------------------------------//
	
	//pruebas de rectangulos
	
	public void Mapa2 () {
		//Manzanas de arriba
		entorno.dibujarRectangulo(150, 180, 100, 160, 0, Color.white);
		entorno.dibujarRectangulo(350, 180, 100, 160, 0, Color.white);
		entorno.dibujarRectangulo(550, 180, 100, 160, 0, Color.white);
		entorno.dibujarRectangulo(750, 180, 100, 160, 0, Color.white);

		//Manzanas de Abajo
		entorno.dibujarRectangulo(150, 440, 100, 160, 0, Color.white);
		entorno.dibujarRectangulo(350, 440, 100, 160, 0, Color.white);
		entorno.dibujarRectangulo(550, 440, 100, 160, 0, Color.white);
		entorno.dibujarRectangulo(750, 440, 100, 160, 0, Color.white);	
	}

}
