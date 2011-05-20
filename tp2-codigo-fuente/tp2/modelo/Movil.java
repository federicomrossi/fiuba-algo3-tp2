package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class Movil extends ObjetoEspacial {

	private double velocidad;
	private String equipo;

	// Inicializa el m�vil con la posici�n, tama�o, escenario y velocidad
	// recibidos. Lo agrega al escenario.
	public Movil(Point posicion, double tamanio, Escenario escenario, double velocidad) {
		super(posicion, tamanio, escenario);
		this.velocidad = velocidad;
		this.equipo = null;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	// Devuelve si el m�vil pertenece al mismo equipo del recibido.
	public Boolean esAliadoDe(Movil movil) {
		if (this.getEquipo() == null)
			return false;
		return this.getEquipo() == movil.getEquipo();
	}

	// Mueve al m�vil de acuerdo al tiempo recibido.
	public abstract void moverDurante(double tiempo);

	// Recibe el desplazamiento y mueve al m�vil de acuerdo al mismo,
	// respecto a su posici�n actual.
	public void desplazarEn(Point desplazamiento) {
		this.setPosicion(this.getPosicion().sumarCon(desplazamiento));
	}

}
