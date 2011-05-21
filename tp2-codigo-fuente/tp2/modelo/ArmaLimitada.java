package tp2.modelo;

import tp2.auxiliares.Point;

// Es un arma, con la diferencia que tiene una carga limitada. Cuando se le acaba, 
// el arma se desactiva autom�ticamente y deja de disparar.
public class ArmaLimitada extends Arma {

	private int carga;
	
	
	// Constructor
	// Inicializa el arma con la posici�n, escenario, velocidad de disparo, 
	// frecuencia de disparo, direcci�n de disparo y la identificaci�n recibidos. 
	// La carga inicial es cero.
	public ArmaLimitada (Point posicion, Escenario escenario, int velocidad, int frecuencia, Point direccion, String id) {
		
		super(posicion, escenario, velocidad, frecuencia, direccion, id);
	}
	
	@Override
	// Ordena al arma actuar en el escenario durante el tiempo espec�ficado. Si no  
	// tiene, se levanta una excepci�n.
	public void actuarDurante(double tiempo) {
		
	}
	
	// Recibe el n�mero de proyectiles con los cuales se va a cargar el arma, y se 
	// los suma al n�mero actual.
	public void cargarCon(int unaCarga) {
		
	}
	
	// Recibe el n�mero de proyectiles que se van a descargar del arma, y se los  
	// resta al n�mero actual.
	public void descargarEn(int unaCarga) {
		
	}
	
	// "Dispara el arma en la direcci�n hacia la cual apunta, y agrega el proyectil
	// al escenario en el cual se encuentra. La carga disminuye en una unidad.
	// Se supone que este m�todo protegido no se llama si la carga es cero.
	public Proyectil disparar() {
		return null;
	}
	
	public int getCarga() {
		return this.carga;
	}
}
