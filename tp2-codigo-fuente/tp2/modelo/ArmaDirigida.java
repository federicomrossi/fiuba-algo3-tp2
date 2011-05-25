package tp2.modelo;

import java.util.Iterator;

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
	public ArmaDirigida(Point posicion, Escenario escenario, int velocidad, double frecuencia, Point direccion, String id) {
		super(posicion, escenario, velocidad, frecuencia, direccion, id);
		
		flotaObjetivo = null;
	}
	
	public Flota getFlotaObjetivo() {
		return this.flotaObjetivo;
	}
	
	// Cambia la flota objetivo a la que va a disparar el arma.
	public void setFlotaObjetivo(Flota nuevaFlotaObjetivo) {
		this.flotaObjetivo = nuevaFlotaObjetivo;
	}
	
	@Override
	// "Dispara el arma en la direcci�n hacia la cual apunta, o hacia alguna nave de
	// la flota objetivo (si es que queda alguna sin destruir) y agrega el proyectil
	// al escenario en el cual se encuentra. Devuelve el proyectil disparado.
	public Proyectil disparar() {	
		
		Vuelo vuelo;
		Proyectil proyectilDisparado;
		NaveMilitar potencialObjetivo;
		
		proyectilDisparado = super.disparar();
		
		
		// Ahora tenemos un proyectil sin objetivo. Hay que ver si podemos 
		// encontrar alguna nave sin destruir en la flota y dirigirle el 
		// proyectil.
		
		if (this.flotaObjetivo != null) {
			
			Iterator<NaveMilitar> navesFlotaObjetivoIterator = this.flotaObjetivo.getNaves().iterator();
			
			while (navesFlotaObjetivoIterator.hasNext()) {
				
				potencialObjetivo = navesFlotaObjetivoIterator.next();
				
				if(! potencialObjetivo.estaDestruido()){
					vuelo = new VueloDirigido(proyectilDisparado, potencialObjetivo);
					proyectilDisparado.setVuelo(vuelo);
					return proyectilDisparado;
				}
			}
		}
		
		return proyectilDisparado;
	}
}
