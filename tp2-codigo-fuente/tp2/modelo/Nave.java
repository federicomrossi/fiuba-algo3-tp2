package tp2.modelo;

import tp2.auxiliares.Point;

public class Nave extends ObjetoVolador {

	private double energia;

	public Nave(Point posicion, double tamano, Escenario escenario,
			double velocidad, double energia) {
		super(posicion, tamano, escenario, velocidad);
		// Inicializa la nave sin un vuelo asignado, con la posici�n, tama�o,
		// escenario, velocidad y energ�a recibidos. La agrega al escenario.
		this.energia = energia;
	}

}
