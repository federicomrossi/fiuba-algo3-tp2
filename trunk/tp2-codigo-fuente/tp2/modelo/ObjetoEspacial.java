package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class ObjetoEspacial {

	private Point posicion;
	private double tamano;
	private Escenario escenario;
	private boolean destruido;

	public ObjetoEspacial(Point posicion, double tamano, Escenario escenario) {
		// Inicializa el objeto con la posici�n, tama�o y escenario recibidos.
		// Lo agrega al escenario.
		this.posicion = posicion;
		this.tamano = tamano;
		this.escenario = escenario;
		this.destruido = false;
		// Falta agregarlo al escenario
	}

	public Point getPosicion() {
		return posicion;
	}

	public double getTamano() {
		return tamano;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public boolean estaSuperpuesto(ObjetoEspacial objetoEspacial) {
		// Devuelve true si el objeto recibido est� superpuesto con el receptor
		// del mensaje. Sino false.

		double distanciaMaxima, distancia;
		distanciaMaxima = this.getTamano() + objetoEspacial.getTamano();
		distancia = this.getPosicion().distance(objetoEspacial.getPosicion());
		return distancia < distanciaMaxima;
	}

	// Hace actuar al objeto especial durante el tiempo especificado (si es
	// negativo, se debe ignorar el mensaje). En la implementaci�n, no se
	// deber�a permitir actuar a objetos que no tengan un escenario, y adem�s,
	// si alguno est� destruido, deber�a desaparecer de su escenario y no
	// realizar nada m�s.
	public abstract void actuar(double tiempo);

	public void destruir() {
		// Destruye al objeto y le impide realizar acciones en el futuro.
		destruido = true;
	}

	public boolean estaDestruido() {
		return destruido;
	}

}