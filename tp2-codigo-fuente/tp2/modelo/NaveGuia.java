package tp2.modelo;

import tp2.auxiliares.Point;

// Es una nave gu�a que sabe controlar una flota, y comunicarse directamente con 
// ella.
public class NaveGuia extends NaveMilitar {
	
	// La flota controlada por la nave.
	private Flota flota;
	// Hacia d�nde van a huir las naves de la flota cuando �sta sea destru�da.
	private Point direccionDeRetirada;
	
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posici�n, tama�o, 
	// escenario, velocidad, energ�a y equipo recibidos. La agrega al escenario y 
	// le asigna una nueva flota.
	public NaveGuia(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
	}
	
	@Override
	// Ordena a la nave civil actuar en el escenario durante el tiempo espec�ficado.
	public void actuarDurante(double unTiempo) {
		
	}
	
	public Point getDireccionDeRetirada() {
		return this.direccionDeRetirada;
	}
	
	// Cambia la direcci�n de retirada. La direcci�n debe ser no nula.
	public void setDireccionDeRetirada(Point nuevaDireccionDeRetirada) {
		
	}
	
	public Flota getFlota() {
		return this.flota;
	}
	
	// Le asigna una flota a la nave.
	public void setFlota(Flota flota) {
		
	}
}
