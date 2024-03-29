package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Define un arma, la cual puede disparar proyectiles en el escenario en donde est�.
public class Arma extends Movil {

	private Nave naveDuenia;
	private Proyectil modeloDeProyectil;
	private double frecuenciaDeDisparo;
	private double tiempoRestante;
	private boolean disparando;
	private int velocidadDeDisparo;
	private Point direccionDeDisparo;	
	
	// Constructor
	// Inicializa el arma con la posici�n, escenario, velocidad de disparo, 
	// frecuencia de disparo, direcci�n de disparo y la identificaci�n recibidos.
	public Arma(Point posicion, Escenario escenario, int velocidad, double frecuencia, Point direccion, String id) {	
		super(posicion, 0, escenario, velocidad);
		this.frecuenciaDeDisparo = frecuencia;
		this.direccionDeDisparo = direccion;
		this.setIdentificacion(id);
		this.velocidadDeDisparo = velocidad;
	}
	
	public Arma(){
		super();
	}
	
	@Override
	// Ordena al arma actuar en el escenario durante el tiempo espec�ficado. Si no 
	// tiene, se levanta una excepci�n.
	public void actuarDurante(double unTiempo) {

		if (this.getEscenario() == null)
			throw new ComposicionIncompleta("No se ha definido un escenario al objeto.");
		
		if (! (unTiempo <= 0)) {
			this.moverDurante(unTiempo);
			this.tiempoRestante -= unTiempo;
			
			if (this.disparando && (this.tiempoRestante <= 0)){
				this.disparar();
			} else if(this.tiempoRestante <= 0){
				this.tiempoRestante = 0;
			}
		}
	}
	
	// No hace nada. El arma tiene una carga infinita.
	public void cargarCon(int unaCarga) {}
	
	// Acciona el arma para que esta empiece a disparar.
	public void comenzarDisparos() {
		this.disparando = true;
	}
	
	// Dispara el arma en la direcci�n hacia la cual apunta, y agrega el proyectil 
	// al escenario en el cual se encuentra. Devuelve el proyectil disparado.
	public Proyectil disparar() {
		
		Proyectil proyectilDisparado;
		Vuelo vuelo;

		proyectilDisparado = this.modeloDeProyectil.clone();
		proyectilDisparado.setIdentificacion(this.modeloDeProyectil.getIdentificacion());
		proyectilDisparado.setPosicion(this.getPosicion());
		proyectilDisparado.setVelocidad(this.velocidadDeDisparo);
		
		vuelo = new VueloEnLineaRecta(proyectilDisparado, this.direccionDeDisparo);
		proyectilDisparado.setVuelo(vuelo);
		proyectilDisparado.setEscenario(this.getEscenario());
		
		this.tiempoRestante += 1 / this.frecuenciaDeDisparo;
		
		return proyectilDisparado;
	}
	
	public boolean estaDisparando() {
		return this.disparando;
	}
	
	// Acciona el arma para que esta empiece a disparar.
	public void frenarDisparos() {
		this.disparando = false;
	}
	
	// Mueve el arma dependiendo de la posici�n de la nave due�a, sin importar el 
	// tiempo que haya transcurrido. Si el arma no pertenece a ninguna nave, entonces 
	// se queda quieta.
	public void moverDurante(double unTiempo) {
		if (this.naveDuenia != null)
			this.setPosicion(this.naveDuenia.getPosicion());
	}
	
	// Cambia el equipo del arma.
	public void setEquipo(String nuevoEquipo) {

		super.setEquipo(nuevoEquipo);
		if (this.modeloDeProyectil != null)
			this.modeloDeProyectil.setEquipo(nuevoEquipo);
	}

	public Point getDireccionDeDisparo() {
		return this.direccionDeDisparo;
	}
	
	// Cambia la direcci�n de disparo, que no debe ser nula.
	public void setDireccionDeDisparo(Point nuevaDireccion) {
		
		if (nuevaDireccion.radio() == 0) 
			throw new ValorInvalido("La direcci�n de disparo no puede ser nula.");
		
		this.direccionDeDisparo = nuevaDireccion;
	}
	
	public double getFrecuenciaDeDisparo() {
		return this.frecuenciaDeDisparo;
	}
	
	// Cambia la frecuencia de disparo, que debe ser mayor a cero.
	public void setFrecuenciaDeDisparo(int nuevaFrecuencia) {
		
		if (nuevaFrecuencia <= 0) 
			throw new ValorInvalido("La frecuencia de disparo debe ser mayor a cero.");
		
		this.frecuenciaDeDisparo = nuevaFrecuencia;
	}
	
	public Proyectil getModeloDeProyectil() {
		return this.modeloDeProyectil;
	}
	
	// Asigna una copia del modelo de proyectil al arma. Dicho modelo no debe tener 
	// un vuelo asignado, o sino se levantar� una excepci�n.
	public void setModeloDeProyectil(Proyectil unProyectil) {
		
		if (unProyectil.getVuelo() != null)
			throw new VueloAsignado("El modelo de proyectil no puede tener un vuelo asignado.");
		
		this.modeloDeProyectil = unProyectil.clone();
		this.modeloDeProyectil.setEquipo(this.getEquipo());
	}
	
	public Nave getNaveDuenia() {
		return this.naveDuenia;
	}
	
	// Asigna la nave due�a al arma. Cada vez que act�e, la misma ser� puesta en la 
	// posici�n de dicha nave.
	public void setNaveDuenia(Nave nuevaNaveDuenia) {
		this.naveDuenia = nuevaNaveDuenia;
	}
	
	public int getVelocidadDeDisparo() {
		return this.velocidadDeDisparo;
	}
	
	// Cambia la velocidad de disparo, que debe ser mayor a cero.
	public void setVelocidadDeDisparo(int nuevaVelocidad) {
		
		if (nuevaVelocidad <= 0) 
			throw new ValorInvalido("La velocidad de disparo debe ser mayor a cero.");
		
		this.velocidadDeDisparo = nuevaVelocidad;
	}
	
	public Number getCarga() {
		return Float.POSITIVE_INFINITY;
	}

	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(naveDuenia, "naveDuenia"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(modeloDeProyectil, "modeloDeProyectil"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(frecuenciaDeDisparo, "frecuenciaDeDisparo"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(tiempoRestante, "tiempoRestante"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(disparando, "disparando"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(velocidadDeDisparo, "velocidadDeDisparo"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(direccionDeDisparo, "direccionDeDisparo"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.naveDuenia = (Nave) ReconstructorDesdeXml.generarObjeto(atributos.get("naveDuenia"));
		this.modeloDeProyectil = (Proyectil) ReconstructorDesdeXml.generarObjeto(atributos.get("modeloDeProyectil"));
		this.frecuenciaDeDisparo = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("frecuenciaDeDisparo"));
		this.tiempoRestante = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("tiempoRestante"));
		this.disparando = (Boolean) ReconstructorDesdeXml.generarObjeto(atributos.get("disparando"));
		this.velocidadDeDisparo = (Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("velocidadDeDisparo"));
		this.direccionDeDisparo = (Point) ReconstructorDesdeXml.generarObjeto(atributos.get("direccionDeDisparo"));
		return this;
	}
}
