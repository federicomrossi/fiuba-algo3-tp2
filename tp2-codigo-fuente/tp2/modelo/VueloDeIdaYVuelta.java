package tp2.modelo;

import tp2.auxiliares.Point;

// Es un tipo particular de vuelo compuesto, en el cual el objeto volador vuela
// en l�nea recta hacia un destino relativo a la posici�n inicial, y luego 
// vuelve en sentido opuesto.
public class VueloDeIdaYVuelta extends VueloCompuesto {

	// Hacia d�nde vuela (relativamente) el objeto.
	private Point destino;
	
	
	// Constructor
	//Inicializa un vuelo de ida vuelta del objeto volador recibido con destino 
	// relativo no nulo.
	public VueloDeIdaYVuelta(ObjetoVolador unObjetoVolador, Point destinoRelativo) {
		super(unObjetoVolador);
		this.destino = destinoRelativo;
	}	
	
	@Override
	// Iniciar el vuelo.
	public void iniciar() {
	
	}
	
	public Point getDestino() {
		return this.destino;
	}
	
	// Cambia el destino a una nueva posici�n relativa al objeto. Si el vuelo 
	// ya comenz� o la posici�n relativa es nula, se levanta una excepci�n.
	public void setDestino(Point posicionRelativa) {
		
	}
	
	@Override
	public void agregarVuelo(Vuelo vuelo, double longitudTrayectoria) {
		throw new UnsupportedOperationException("No se pueden agregar vuelos.");
	}
}
