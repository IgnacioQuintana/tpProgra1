package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Personaje Layka;
	private Disparos disparoLayka;
	private int timer;
	private Image fondo;
	private Image plantas_Muertas;
	private int contPlantasMuertas = 0;
	private int puntos = 0;
	private Manzana[] manzanas;
	private Auto[] autos;
	private Planta[] plantas;
	private int mov;

	
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Plantas Invasoras - Grupo 13 - Quintana - V0.01", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		crearAutos();
		crearManzanas();
		crearPlantas();
		fondo = Herramientas.cargarImagen("media/fondo1.jpg");
		Layka = new Personaje(415, 570, 10, 5);
		plantas_Muertas = Herramientas.cargarImagen("media/PlantaCarnivora.png");
		// Herramientas.loop("media/musicaFondo.wav");
		
		
		// Inicia el juego!
		this.entorno.iniciar();
		
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar
	 * el estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		
		// cuenta los tick del juego
		timer += 1;
		
		// dibuja la imagen de fondo
		entorno.dibujarImagen(fondo, entorno.ancho() / 3.2, entorno.alto() / 2, 0, 1.1);
		entorno.dibujarImagen(fondo, entorno.ancho(), entorno.alto() / 2, 0, 1.1);
		
		// dibuja los objetos en el juego
		Layka.dibujar(entorno);
		dibujarAutos();
		dibujarPlantas();
		
		// movimiento de layka
		movimientoLayka();
		
		//Crea y verifica colisiones del disparo
		veDisparoPlantas();
		colisionConAuto();
		colisionConPlanta();
		
		//dibuja la puntuacion
		entorno.cambiarFont("Arial Black", 14, Color.BLACK);
		entorno.escribirTexto("Puntos: "+puntos, 720, 30);
		entorno.dibujarImagen(plantas_Muertas, 20, 30, 0, 0.08);
		entorno.escribirTexto(" X"+contPlantasMuertas, 30, 40);

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//

	
	
	
	
	// VERIFICA EL MOVIMIENTO DE LAYKA
	public void movimientoLayka() {

		if (entorno.estaPresionada('w') || entorno.estaPresionada(entorno.TECLA_ARRIBA)
				|| entorno.estaPresionada('W')) {
			if (hayColision(Layka)) {
				ajustarPosicion(Layka);
			}
			Layka.moverArriba();
			mov=1;
		}
		if (entorno.estaPresionada('d') || entorno.estaPresionada(entorno.TECLA_DERECHA)
				|| entorno.estaPresionada('D')) {
			if (hayColision(Layka)) {
				ajustarPosicion(Layka);
			}
			Layka.moverDerecha();
			mov=2;
		}
		if (entorno.estaPresionada('s') || entorno.estaPresionada(entorno.TECLA_ABAJO) || entorno.estaPresionada('S')) {
			if (hayColision(Layka)) {
				ajustarPosicion(Layka);
			}
			Layka.moverAbajo();
			mov=3;
		}
		if (entorno.estaPresionada('a') || entorno.estaPresionada(entorno.TECLA_IZQUIERDA)
				|| entorno.estaPresionada('A')) {
			if (hayColision(Layka)) {
				ajustarPosicion(Layka);
			}
			Layka.moverIzquierda();
			mov=4;
		}
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			if(disparoLayka == null) {
				disparoLayka= new Disparos(Layka.getCuerpo().getX(),Layka.getCuerpo().getY(),mov);
				//cantR=cantR+1;
			}			
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//

	// CREA A LAS PLANTAS Y LAS DIBUJA
	public void crearPlantas() {
		plantas = new Planta[5];
		plantas[0] = new Planta(80, 500, 2);// superior izquierda, baja
		plantas[1] = new Planta(635, 400, 1);// inferior derecha, sube
		plantas[2] = new Planta(800, 110, 3); // superior derecha, izquierda
		plantas[3] = new Planta(780, 445, 3);// inferior derecha, izquierda
		plantas[4] = new Planta(420, 40, 2);// medio arriba, baja

	}

	public void dibujarPlantas() {
		// recorre el array de plantas y las dibuja
		for (int i = 0; i < plantas.length; i++) {

			if (!plantas[i].getMuerto()) {
				plantas[i].dibujar(entorno);
				plantas[i].mover();
			}
			// si estan muertos los hace reaparecer en las cordenadas asignadas
			// cuando el timer(contador de ticks) es multiplo de 300
			else {
				if (timer % 300 == 0) {
					if (i == 0) {
						plantas[i].setMuerto(false);
						plantas[i].setX(80);
						plantas[i].setY(500);
					}
					if (i == 1) {
						plantas[i].setMuerto(false);
						plantas[i].setX(635);
						plantas[i].setY(400);
					}
					if (i == 2) {
						plantas[i].setMuerto(false);
						plantas[i].setX(800);
						plantas[i].setY(110);
					}
					if (i == 3) {
						plantas[i].setMuerto(false);
						plantas[i].setX(780);
						plantas[i].setY(445);
					}
					if (i == 4) {
						plantas[i].setMuerto(false);
						plantas[i].setX(420);
						plantas[i].setY(40);
					}

				}

			}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// CREA A LOS AUTOS Y LOS DIBUJA
	public void crearAutos() {
		autos = new Auto[5];
		autos[0] = new Auto(100, 50, 2);// superior izquierda, baja
		autos[1] = new Auto(620, 580, 1);// inferior derecha, sube
		autos[2] = new Auto(600, 90, 3); // superior derecha, izquierda
		autos[3] = new Auto(500, 430, 4);// inferior izquierda, derecha
		autos[4] = new Auto(780, 455, 3);// inferior derecha, izquierda
	}

	public void dibujarAutos() {
		// Recorre el array de autos y los dibuja.
		for (int i = 0; i < autos.length; i++) {

			if (!autos[i].getMuerto()) {
				autos[i].dibujar(entorno);
				autos[i].mover();
			}
			// si estan destruidos los hace reaparecer en las cordenadas asignadas
			// cuando el timer(contador de ticks) es multiplo de 300.
			else {
				if (timer % 300 == 0) {
					if (i == 0) {
						autos[i].setMuerto(false);
						autos[i].setX(100);
						autos[i].setY(0);
					}
					if (i == 1) {
						autos[i].setMuerto(false);
						autos[i].setX(634);
						autos[i].setY(600);
					}
					if (i == 2) {
						autos[i].setMuerto(false);
						autos[i].setX(800);
						autos[i].setY(99);
					}
					if (i == 3) {
						autos[i].setMuerto(false);
						autos[i].setX(0);
						autos[i].setY(367);
					}
					if (i == 4) {
						autos[i].setMuerto(false);
						autos[i].setX(800);
						autos[i].setY(501);
					}

				}

			}
		}
	}

//---------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------//

	// INICIALIZA LAS MANZANAS

	public void crearManzanas() {
		// inicializa el Arreglo  y lo llena.
		manzanas = new Manzana[12];
		manzanas[0] = new Manzana(27, 40, 54, 80);
		manzanas[1] = new Manzana(250, 40, 276, 80);
		manzanas[2] = new Manzana(525, 40, 155, 80);
		manzanas[3] = new Manzana(740, 40, 155, 80);

		manzanas[4] = new Manzana(27, 275, 54, 275);
		manzanas[5] = new Manzana(250, 275, 276, 275);
		manzanas[6] = new Manzana(525, 275, 155, 275);
		manzanas[7] = new Manzana(740, 275, 155, 275);

		manzanas[8] = new Manzana(27, 540, 50, 130);
		manzanas[9] = new Manzana(250, 540, 276, 130);
		manzanas[10] = new Manzana(525, 540, 155, 130);
		manzanas[11] = new Manzana(740, 540, 155, 130);

	}
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//
	// ---------------------------------------------------------------------------------------------------------------------------------------------------//

	// Colisiones
	//DisparoLayka
	public void veDisparoPlantas() {
		if(disparoLayka != null) {
			disparoLayka.dibujar(entorno);
			disparoLayka.mover();			
			int plantasMuertas=disparoLayka.impactastePlanta(plantas);
			
			if(plantasMuertas !=-1) {	
				plantas[plantasMuertas].setMuerto(true);
				contPlantasMuertas=contPlantasMuertas+1;				
				disparoLayka=null;	
				puntos += 5;
			}
			if(this.disparoLayka!=null) {
			if(disparoLayka.impactasteAuto(autos) != -1) {
				disparoLayka = null;
			}
			else {
				if(disparoLayka.chocoConEntorno(entorno)){					
					disparoLayka = null;
				}				
			}	}
		}
	}
	public void colisionConPlanta() {
		if(Layka.chocasteConPlantaEnX(plantas)){

			entorno.dispose();
		}
		if(Layka.chocasteConPlantaEnY(plantas)) {
			
			entorno.dispose();
		}
	}
	
	public void colisionConAuto() {
		if(Layka.chocasteConAutoEnX(autos)){
			
			entorno.dispose();
		}
		if(Layka.chocasteConAutoEnY(autos)) {
			entorno.dispose();
		}
	}
	
	// Layka con las manzanas
	public static boolean hayColision(Personaje layka) {
		return // Casas Superiores
		layka.getCuerpo().getX() - 10 < 57 && layka.getCuerpo().getX() > 0 && layka.getCuerpo().getY() - 15 < 80
				|| layka.getCuerpo().getX() - 10 < 388 && layka.getCuerpo().getX() > 100
						&& layka.getCuerpo().getY() - 15 < 80
				|| layka.getCuerpo().getX() - 10 < 602 && layka.getCuerpo().getX() > 435
						&& layka.getCuerpo().getY() - 15 < 80
				|| layka.getCuerpo().getX() - 10 < 800 && layka.getCuerpo().getX() > 650
						&& layka.getCuerpo().getY() - 15 < 80
				||
				// Casas Medio
				layka.getCuerpo().getX() - 10 < 57 && layka.getCuerpo().getX() > 0
						&& layka.getCuerpo().getY() - 15 < 415 && layka.getCuerpo().getY() > 120
				|| layka.getCuerpo().getX() - 10 < 388 && layka.getCuerpo().getX() > 100
						&& layka.getCuerpo().getY() - 15 < 415 && layka.getCuerpo().getY() > 120
				|| layka.getCuerpo().getX() - 10 < 602 && layka.getCuerpo().getX() > 435
						&& layka.getCuerpo().getY() - 15 < 415 && layka.getCuerpo().getY() > 120
				|| layka.getCuerpo().getX() - 10 < 800 && layka.getCuerpo().getX() > 650
						&& layka.getCuerpo().getY() - 15 < 415 && layka.getCuerpo().getY() > 120
				||
				// Casas Inferiores
				layka.getCuerpo().getX() - 10 < 57 && layka.getCuerpo().getX() > 0
						&& layka.getCuerpo().getY() - 15 < 600 && layka.getCuerpo().getY() > 460
				|| layka.getCuerpo().getX() - 10 < 388 && layka.getCuerpo().getX() > 100
						&& layka.getCuerpo().getY() - 15 < 600 && layka.getCuerpo().getY() > 460
				|| layka.getCuerpo().getX() - 10 < 602 && layka.getCuerpo().getX() > 435
						&& layka.getCuerpo().getY() - 15 < 600 && layka.getCuerpo().getY() > 460
				|| layka.getCuerpo().getX() - 10 < 800 && layka.getCuerpo().getX() > 650
						&& layka.getCuerpo().getY() - 15 < 600 && layka.getCuerpo().getY() > 460;
	}

	public static void ajustarPosicion(Personaje layka) {
		layka.getCuerpo().setX(layka.getXAnterior());
		layka.getCuerpo().setY(layka.getYAnterior());
	}
	//

	public void Mapa2() {
		// Manzanas de arriba
		entorno.dibujarRectangulo(27, 40, 54, 80, 0, Color.BLUE);
		entorno.dibujarRectangulo(250, 40, 276, 80, 0, Color.BLUE);
		entorno.dibujarRectangulo(525, 40, 155, 80, 0, Color.BLUE);
		entorno.dibujarRectangulo(740, 40, 155, 80, 0, Color.BLUE);

		// Manzanas del medio
		entorno.dibujarRectangulo(27, 275, 54, 275, 0, Color.red);
		entorno.dibujarRectangulo(250, 275, 276, 275, 0, Color.red);
		entorno.dibujarRectangulo(525, 275, 155, 275, 0, Color.red);
		entorno.dibujarRectangulo(740, 275, 155, 275, 0, Color.red);

		// Manzanas de abajo
		entorno.dibujarRectangulo(27, 540, 50, 130, 0, Color.MAGENTA);
		entorno.dibujarRectangulo(250, 540, 276, 130, 0, Color.MAGENTA);
		entorno.dibujarRectangulo(525, 540, 155, 130, 0, Color.MAGENTA);
		entorno.dibujarRectangulo(740, 540, 155, 130, 0, Color.MAGENTA);
	}

}
