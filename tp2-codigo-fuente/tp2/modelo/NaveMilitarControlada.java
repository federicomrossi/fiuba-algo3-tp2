package tp2.modelo;

import java.util.Iterator;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ObjetoDesconocido;
import tp2.persistencia.IGuardable;

/** Es una nave militar la cual permite ser controlada externamente. Se le puede 
* ordenar que se empiece a mover en una direcci�n o que se detenga, que accione 
* un arma o detenga sus disparos. */
public class NaveMilitarControlada extends NaveMilitar {

	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posici�n,
	// tama�o, escenario, velocidad y energ�a recibidos. La agrega al escenario.
	public NaveMilitarControlada(Point posicion, double tamanio,
			Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
		super.setVuelo(new VueloDireccionable(this, new Point(0, 0)));
		this.setComportamiento(new ChoqueDeNaveMilitarControlada(this));
	}
	
	public NaveMilitarControlada() {
		super();
	}

	// Recibe la identificaci�n del arma que se desea disparar. Si no existe
	// dicha arma, se levanta una excepci�n.
	public void iniciarFuegoConArmaDeId(String unaIdentificacion) {

		Iterator<Arma> iter = this.getArmas().iterator();
		while (iter.hasNext()) {
			Arma arma = iter.next();
			if (arma.getIdentificacion() == unaIdentificacion) {
				arma.comenzarDisparos();
				return;
			}
		}
		
		throw new ObjetoDesconocido("No se conoce el tipo del arma (no tiene identificaci�n)");
	}

	// Recibe la identificaci�n del arma que se desea dejar de disparar. Si no
	// existe dicha arma, se levanta una excepci�n.
	public void detenerFuegoConArmaDeId(String unaIdentificacion) {

		Iterator<Arma> iter = this.getArmas().iterator();
		while (iter.hasNext()) {
			Arma arma = iter.next();
			if (arma.getIdentificacion() == unaIdentificacion) {
				arma.frenarDisparos();
				return;
			}
		}
		throw new ObjetoDesconocido(
				"No se conoce el tipo del arma (no tiene identificaci�n)");
	}

	// Cambia la direcci�n de la nave a la especificada. Si se desea que la nave
	// se quede quieta, debe recibirse la direcci�n (0,0).
	public void setDireccionDeVuelo(Point nuevaDireccion) {
		VueloDireccionable vuelo = (VueloDireccionable)this.getVuelo();
		vuelo.setDireccion(nuevaDireccion);
	}

	@Override
	// El vuelo de una nave controlada no puede cambiarse.
	public void setVuelo(Vuelo nuevoVuelo) {
		throw new UnsupportedOperationException("No se puede cambiar el vuelo.");
	}
	
	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		super.cargar(atributos);
		return this;
	}
}
