package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;

public abstract class ObjetoVolador extends Movil {

	private Vuelo vuelo;
	
	// Constructor
	// Inicializa el objeto volador sin un vuelo asignado, con la posici�n,
	// tama�o, escenario y velocidad recibidos. Lo agrega al escenario.
	public ObjetoVolador(Point posicion, double tamanio, Escenario escenario, double velocidad) {
		super(posicion, tamanio, escenario, velocidad);
		this.vuelo = null;
	}

	@Override
	// Mueve al objeto volador de acuerdo al tiempo recibido y el vuelo que
	// tenga. Si no tiene un vuelo definido o un escenario asignado, se
	// levanta una excepci�n.
	public void moverDurante(double unTiempo) throws ComposicionIncompleta {
				
		if(vuelo == null)
			throw new ComposicionIncompleta("No se ha definido un vuelo para el objeto.");
		
		if(this.getEscenario() == null)
			throw new ComposicionIncompleta("No se ha asignado un escenario al objeto.");
		
		if(! this.vuelo.estaIniciado()) 
			this.vuelo.iniciar();
		
		this.desplazarEn(this.vuelo.avanzarDurante(unTiempo));
	}
	
	public Vuelo getVuelo() {
		return this.vuelo;
	}

	// Asigna un nuevo Vuelo al objeto volador. De ahora en m�s, el objeto va a 
	// volar de acuerdo a dicho vuelo en cada acci�n que realice.
	public void setVuelo(Vuelo nuevoVuelo) {
		this.vuelo = nuevoVuelo;
	}
}
