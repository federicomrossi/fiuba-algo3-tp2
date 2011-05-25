package tp2.modelo;

// La f�brica de armas puede crear las armas particulares del juego.
public class FabricaDeArmas {

	private Escenario escenarioActual;
		
	// Constructor
	public FabricaDeArmas(Escenario unEscenario) {
		
	}
	
	private void cambiarEscenarioA(Escenario otroEscenario) {
		
	}
	
	// Crea un ca��n l�ser (identificaci�n: CanonLaser) que tiene carga 
	// infinita, velocidad de disparo 100, da�o de proyectil 10 y frecuencia 
	// de disparo 5. Devuelve el ca��n, apuntando por defecto hacia abajo y 
	// posicionado en el origen.
	public Arma crearCanionLaser() {
		return null;
	}
	
	// Crea un lanzacohetes (identificaci�n: LanzaCohetes) que tiene carga 
	// inicial igual a 10, velocidad de disparo 50, frecuencia 2 y da�o de 
	// proyectil 50. Devuelve el lanzacohetes, apuntando por defecto hacia 
	// abajo y posicionada en el origen.
	public ArmaLimitada crearLanzaCohetes() {
		return null;
	}
	
	// Crea un lanzatorpedos (identificaci�n: LanzaTorpedos) que tiene carga 
	// inicial igual a 5, velocidad de disparo 20, frecuencia 0,5 y da�o de 
	// proyectil 150. Esta arma es opcionalmente dirigida, y se le puede 
	// asignar una flota objetivo para que cada vez que dispare un torpedo 
	// el mismo persiga a una nave de esa flota. Devuelve el lanzatorpedos, 
	// apuntando por defecto hacia abajo.
	public ArmaDirigida crearLanzaTorpedos() {
		return null;
	}

	public void setEscenario(Escenario nuevoEscenario) {
		escenarioActual = nuevoEscenario;
	}
}
