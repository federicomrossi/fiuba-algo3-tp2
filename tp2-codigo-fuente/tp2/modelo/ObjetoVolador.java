package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class ObjetoVolador extends Movil {

	public ObjetoVolador(Point posicion, double tamano, Escenario escenario,
			double velocidad) {
		super(posicion, tamano, escenario, velocidad);
		// Inicializa el objeto volador sin un vuelo asignado, con la posici�n,
		// tama�o, escenario y velocidad recibidos. Lo agrega al escenario.
	}

}
