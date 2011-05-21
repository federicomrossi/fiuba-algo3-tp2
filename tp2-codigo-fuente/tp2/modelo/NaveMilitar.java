package tp2.modelo;
import java.util.*;

import tp2.auxiliares.Point;

// Una nave militar es una nave que tiene un cierto n�mero de armas (pero una sola 
// del mismo tipo).
public class NaveMilitar extends Nave {

	// las armas de la nave, la cual puede activarlas para que disparen o 
	// desactivarlas cuando desee.
	private List<Arma> armas;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posici�n, tama�o, 
	// escenario, velocidad y energ�a recibidos. La agrega al escenario.
	public NaveMilitar(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);		
	}
	
	@Override
	// Ordena a la nave civil actuar en el escenario durante el tiempo espec�ficado.
	public void actuarDurante(double unTiempo) {
		
	}
	
	// Agrega el arma a la nave. Si la misma ya tiene un arma del mismo tipo (igual 
	// identificaci�n), solamente carga la ya existente con los proyectiles que la 
	// otra tenga. Si el arma no tiene identificaci�n, entonces se levanta una 
	// excepci�n.
	public void agregarArma(Arma unArma) {
		
	}
	
	// La nave ordena a sus armas que frenen sus disparos.
	public void detenerFuego() {
		
	}
	
	// La nave acciona sus armas para que estas comiencen sus disparos.
	public void iniciarFuego() {
		
	}
	
	// Devuelve un hash de las armas de la nave, con su identificaci�n como clave 
	// y el arma en s� como valor.
	public List<Arma> getArmas() {
		return this.armas;
	}
	
	@Override
	// Hace sufrir al objeto recibido los efectos de chocar una nave militar, 
	// seg�n su comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		
	}
}
