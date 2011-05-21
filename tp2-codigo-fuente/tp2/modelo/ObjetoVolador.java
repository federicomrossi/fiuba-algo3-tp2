package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class ObjetoVolador extends Movil {

	private Vuelo vuelo;
	
	// Constructor
	// Inicializa el objeto volador sin un vuelo asignado, con la posici�n,
	// tama�o, escenario y velocidad recibidos. Lo agrega al escenario.
	public ObjetoVolador(Point posicion, double tamanio, Escenario escenario, double velocidad) {
		super(posicion, tamanio, escenario, velocidad);
	}

	@Override
	// Mueve al objeto volador de acuerdo al tiempo recibido y el vuelo que
	// tenga. Si no tiene un vuelo definido o un escenario asignado, se
	// levanta una excepci�n.
	public void moverDurante(double unTiempo) {
	
	}
	
	public Vuelo getVuelo() {
		return this.vuelo;
	}

}
