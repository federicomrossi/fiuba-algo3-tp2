package tp2.modelo;

import java.util.*;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;


// Un proyectil es capaz de da�ar naves no aliadas al impactar con ellas en el escenario.
public class Proyectil extends ObjetoVolador implements Cloneable {

	// El da�o por impacto del proyectil.
	private double danio;
	
	
	// Constructor
	// Inicializa el proyectil sin un vuelo asignado, con la posici�n, tama�o, 
	// velocidad y da�o recibidos.
	public Proyectil(Point posicion, double tamanio, double velocidad, double danio) {
		super(posicion, tamanio, null, velocidad);
		
		this.danio = danio;
		this.comportamientoAlChocar = new ChoqueDeProyectil(this);
	}
	
	@Override
	// Deep Cloning parcial del objeto.
	public Proyectil clone() {
		
		Proyectil clone = null;

		try {
	      clone = (Proyectil) super.clone();
	    }
	    catch(CloneNotSupportedException e) { }
	    
	    // FALTA CLONAR TIPOS NO PRIMITIVOS!!!!!!!!!!!!!!!!!!!!
	    /*((Proyectil)clone).getPosicion();
	    ((Proyectil)clone).setPosicion((Point)posicion.clone());
	    ((Proyectil)clone).getEscenario();
	    ((Proyectil)clone).setEscenario((Escenario)escenario.clone());
	    ((Proyectil)clone).getIdentificacion();
	    ((Proyectil)clone).setIdentificacion((String)identificacion.clone());*/
	      
		return clone;
	}
	
	@Override
	// Hace actuar al objeto volador en el escenario durante el tiempo espec�ficado,
	// haciendo que el mismo vuele durante ese tiempo. Si no tiene escenario o 
	// vuelo, se levanta una excepci�n.
	public void actuarDurante(double unTiempo) {
		
		if (this.estaDestruido()) {
			this.desaparecerDelEscenario();
			return;
		}
	
		if (unTiempo <= 0) return;
		
		Set<ObjetoEspacial> objetosChocados;
		
		objetosChocados = (this.getEscenario()).getObjetosEnColisionCon(this);
		Iterator<ObjetoEspacial> objetosChocadosIterator = objetosChocados.iterator();
		
		while (objetosChocadosIterator.hasNext())
			this.chocarCon(objetosChocadosIterator.next());
		
		this.moverDurante(unTiempo);
	}
	
	@Override
	// Hace sufrir al objeto recibido los efectos de chocar un proyectil, seg�n su 
	// comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		
		unObjetoEspacial.getComportamiento().sufrirChoqueDeProyectil(this);
	}
	
	public double getDanio() {
		return this.danio;
	}
	
	// Cambia el da�o del proyectil a un nuevo valor mayor o igual a cero. Si se 
	// recibe un da�o negativo, entonces se levanta una excepci�n.
	public void setDanio(double nuevoDanio) {

		if (nuevoDanio < 0)
			throw new ValorInvalido("No se puede asignar un da�o negativo.");
		
		this.danio = nuevoDanio;
	}
	
}
