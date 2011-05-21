package tp2.modelo;

import tp2.auxiliares.Point;
import java.util.*;

// Una flota es un grupo de naves militares. La misma puede dar �rdenes a todos 
// sus miembros cuando sea necesario.
public class Flota {

	private NaveGuia naveGuia;
	private List<NaveMilitar> navesMilitares;
	
	// Constructor
	// Inicializa una flota con la nave gu�a recibida.
	public Flota(NaveMilitar naveGuia){
		
	}
		
	// Agrega la nave a la flota (si ya se encontraba, se ignora el mensaje). Si la 
	// nave no pertencece al mismo equipo que la gu�a, se levanta una excepci�n.
	public void agregarNave(NaveMilitar unaNaveMilitar){
		
	}
	
	// Ordena a los aviones de la flota detener sus disparos y huir en la direccion 
	// recibida.
	public void iniciarRetiradaEnDireccion(Point unaDireccion){
		
	}
	
	protected void setNaveGuia(NaveGuia nuevaNaveGuia){
		
	}
	
	public NaveGuia getNaveGuia(){
		return this.naveGuia;
	}
	
	public List<NaveMilitar> getNaves(){
		return this.navesMilitares;
	}
	
}
