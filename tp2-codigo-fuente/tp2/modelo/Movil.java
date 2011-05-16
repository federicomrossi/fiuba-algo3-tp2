package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class Movil extends ObjetoEspacial {
	
	private double velocidad;

	public Movil(Point posicion, double tamano, Escenario escenario, double velocidad) {
		super(posicion, tamano, escenario);
		// Inicializa el m�vil con la posici�n, tama�o, escenario y velocidad
		// recibidos. Lo agrega al escenario.
		this.velocidad = velocidad;
	}

}
