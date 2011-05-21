package tp2.modelo;

import tp2.auxiliares.Point;

// Es una nave militar que adem�s, al ser destru�da, aumenta la puntuaci�n del 
// escenario y opcionalmente tira un bono en el mismo.
public class NaveEnemiga extends NaveMilitar {

	// La puntuaci�n por destrucci�n de la nave.
	private double puntuacion;
	// El bono que brinda al ser destru�da (si tiene).
	private Bono bono;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado, armas ni bono y puntuaci�n nula, 
	// con la posici�n, tama�o, escenario, velocidad y energ�a recibidos. La agrega 
	// al escenario.
	public NaveEnemiga(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
	}
	
	@Override
	// Ordena a la nave enemiga actuar en el escenario durante el tiempo 
	// espec�ficado.
	public void actuarDurante(double unTiempo) {
		
	}
	
	// Destruye la nave y le impide realizar acciones en el futuro. Adem�s, 
	// posiciona al bono en el escenario, en el lugar donde la nave acaba de ser 
	// destru�da.
	public void destruir() {

	}
	
	// Cambia el bono de la nave.
	public void setBono(Bono unBono) {
		
	}
	
	// Devuelve la puntuaci�n por destrucci�n de esta nave.
	public double getPuntuacion() {
		return this.puntuacion;
	}
	
	// Recibe la penalizaci�n por destruir la nave, que debe ser mayor o igual a 
	// cero (sino se levanta una excepci�n).
	public void setPuntuacion(double unaPuntuacion) {
		
	}
}
