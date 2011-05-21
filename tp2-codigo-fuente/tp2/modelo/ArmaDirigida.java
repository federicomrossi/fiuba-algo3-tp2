package tp2.modelo;

import tp2.auxiliares.Point;

// Es un arma limitada, que puede configurarse para disparar contra una flota 
// enemiga. Al momento de disparar (si la flota enemiga est� definida) se dispara 
// contra una nave al azar de dicha flota. Si no hay ninguna nave que atacar, el 
// proyectil sale en la direcci�n en la cual apunta el arma.
public class ArmaDirigida extends ArmaLimitada {

	private Flota flotaObjetivo;
	
	// Constructor
	// Inicializa el arma con la posici�n, escenario, velocidad de disparo, 
	// frecuencia de disparo, direcci�n de disparo y la identificaci�n recibidos. La 
	// carga inicial es cero y no hay objetivo asignado
	public ArmaDirigida(Point posicion, Escenario escenario, int velocidad, int frecuencia, Point direccion, String id) {
		super(posicion, escenario, velocidad, frecuencia, direccion, id);
	}
	
	public Flota getFlotaObjetivo() {
		return this.flotaObjetivo;
	}
	
	// Cambia la flota objetivo a la que va a disparar el arma.
	public void setFlotaObjetivo(Flota nuevaFlotaObjetivo) {
		
	}
	
	@Override
	// "Dispara el arma en la direcci�n hacia la cual apunta, o hacia alguna nave de
	// la flota objetivo (si es que queda alguna sin destruir) y agrega el proyectil
	// al escenario en el cual se encuentra. Devuelve el proyectil disparado.
	public Proyectil disparar() {
		return null;
	}
}
