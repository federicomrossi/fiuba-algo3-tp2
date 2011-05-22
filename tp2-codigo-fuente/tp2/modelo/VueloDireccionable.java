package tp2.modelo;

import tp2.auxiliares.Point;

// Es un vuelo que puede cambiar la direcci�n cuando se desee.
public class VueloDireccionable extends Vuelo {
	
	// La direcci�n actual de vuelo.
	private Point direccion;
	
	// Constructor
	// Inicializa un vuelo direccionable del objeto volador recibido, con la 
	// direcci�n dada.
	public VueloDireccionable(ObjetoVolador unObjetoVolador, Point direccion) {
		super(unObjetoVolador);
		this.direccion = direccion;
	}
	
	@Override
	// Avanza el vuelo durante el tiempo indicado. Si la direcci�n es la nula, 
	// entonces el vuelo permanece en el mismo lugar. Devuelve el desplazamiento
	// del vuelo. Si el vuelo no fue iniciado, se levanta.
	public Point avanzarDurante(double tiempo) {
		return null;
	}
	
	public Point getDireccion() {
		return this.direccion;
	}
	
	// Permite cambiar la direcci�n de vuelo. El vuelo reaccionar� inmediamente 
	// a la nueva direcci�n la pr�xima vez que avance.
	public void setDireccion(Point nuevaDireccion) {
		
	}
}
