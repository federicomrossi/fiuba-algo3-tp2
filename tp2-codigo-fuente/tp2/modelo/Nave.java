package tp2.modelo;

import tp2.auxiliares.Point;

public class Nave extends ObjetoVolador {

	protected double energia;

<<<<<<< .mine
	// Inicializa la nave sin un vuelo asignado, con la posici�n, tama�o,
	// escenario, velocidad y energ�a recibidos. La agrega al escenario.
	public Nave(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad);
		
=======
	// Inicializa la nave sin un vuelo asignado, con la posici�n, tama�o,
	// escenario, velocidad y energ�a recibidos. La agrega al escenario.
	public Nave(Point posicion, double tamano, Escenario escenario,
			double velocidad, double energia) {
		super(posicion, tamano, escenario, velocidad);
>>>>>>> .r49
		this.energia = energia;
	}

	// Ordena a la nave actuar durante el tiempo espec�ficado. La nave debe
	// tener un vuelo y un escenario especificados, o de lo contrario se
	// levanta una excepci�n.
	@Override
<<<<<<< .mine
	// Ordena a la nave actuar durante el tiempo espec�ficado. La nave debe
	// tener un vuelo y un escenario especificados, o de lo contrario se
	// levanta una excepci�n.
	public void actuarDurante(double unTiempo) {
		
=======
	public void actuarDurante(double tiempo) {
>>>>>>> .r49
	}

}
