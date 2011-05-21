package tp2.modelo;

import tp2.auxiliares.Point;

// Una nave civil es tal que al destruirse, disminuye la puntuaci�n del escenario 
// seg�n la penalizaci�n que tenga.
public class NaveCivil extends Nave {

	// Cu�nto disminuye la puntuaci�n del escenario al destruir la nave.
	private int penalizacion;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado y penalizaci�n nula, con la 
	// posici�n, tama�o, escenario, velocidad y energ�a recibidos. La agrega al 
	// escenario.
	public NaveCivil(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
	}
	
	@Override
	// Ordena a la nave civil actuar en el escenario durante el tiempo espec�ficado.
	public void actuarDurante(double unTiempo) {
		
	}
	
	@Override
	// Hace sufrir al objeto recibido los efectos de chocar una nave civil, seg�n su 
	// comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	// Devuelve la penalizaci�n de puntos asociada a esta nave.
	public int getPenalizacion() {
		return this.penalizacion;
	}
	
	// Recibe la penalizaci�n por destruir la nave, que debe ser mayor o igual a 
	// cero (sino se levanta una excepci�n).
	public void setPenalizacion(int unaPenalizacion) {
		
	}
}
