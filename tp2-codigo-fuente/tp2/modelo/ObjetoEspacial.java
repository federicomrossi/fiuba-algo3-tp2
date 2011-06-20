package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ComposicionIncompleta;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;
import tp2.vista.ventanas.Proyeccion;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

public abstract class ObjetoEspacial implements Visible, ObjetoVivo, IGuardable{

	private Point posicion;
	private double tamanio;
	private Escenario escenario;
	private boolean destruido;
	private ChoqueDeObjetoEspacial comportamientoAlChocar;
	private String identificacion;
	private Proyeccion proyeccion;

	// Constructor
	// Inicializa el objeto con la posici�n, tama�o y escenario recibidos.
	// Lo agrega al escenario.
	public ObjetoEspacial(Point posicion, double tamanio, Escenario escenario) {

		this.posicion = posicion;
		this.tamanio = tamanio;
		this.escenario = escenario;
		this.destruido = false;
		this.comportamientoAlChocar = new ChoqueDeObjetoEspacial(this);
		if (this.escenario != null) {
			this.escenario.agregarObjeto(this);
		}
	}

	// Devuelve true si el objeto recibido est� superpuesto con el receptor
	// del mensaje. Sino false.
	// Devuelve true si el objeto recibido est� superpuesto con el receptor
	// del mensaje. Sino false.
	public boolean estaSuperpuestoCon(ObjetoEspacial objetoEspacial) {

		double distanciaMaxima, distancia;
		distanciaMaxima = this.getTamanio() + objetoEspacial.getTamanio();
		distancia = this.getPosicion().distance(objetoEspacial.getPosicion());
		return distancia < distanciaMaxima;
	}

	// Hace actuar al objeto especial durante el tiempo especificado (si es
	// negativo, se debe ignorar el mensaje). En la implementaci�n, no se
	// deber�a permitir actuar a objetos que no tengan un escenario, y adem�s,
	// si alguno est� destruido, deber�a desaparecer de su escenario y no
	// realizar nada m�s.
	public abstract void actuarDurante(double unTiempo);

	@Override
	public void vivir() {}

	// Hace chocar al objeto recibido con el receptor del mensaje. Ambos sufren
	// el efecto del mismo seg�n c�mo est� definido su comportamiento ante el
	// mismo.
	public void chocarCon(ObjetoEspacial unObjetoEspacial) {
		this.responderChoqueDe(unObjetoEspacial);
		unObjetoEspacial.responderChoqueDe(this);
	}

	// Este m�todo tiene car�cter de 'protegido de clase' (s�lo deben llamarlo
	// objetos de esta dentro de esta jerarqu�a). El objeto que recibe el
	// mensaje responde el choque y le hace sufrir al objeto recibido sus efectos,
	// de acuerdo al comportamiento frente al choque que este �ltimo tenga.
	// El receptor le pide al objeto recibido que le diga c�mo tiene que ser
	// afectado al chocar con los dem�s objetos existentes. Luego es el receptor
	// el que selecciona de entre todo el comportamiento el correspondiente a �l
	// mismo.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		unObjetoEspacial.sufrirChoqueDeObjetoEspacial(this);
	}

	// Hace que el objeto receptor del mensaje sea afectado por el bono
	// recibido.
	public void sufrirChoqueDeBono(Bono unBono) {
		this.comportamientoAlChocar.sufrirChoqueDeBono(unBono);
	}

	// Hace que el objeto receptor del mensaje sea afectado por la nave
	// recibida.
	public void sufrirChoqueDeNave(Nave unaNave) {
		this.comportamientoAlChocar.sufrirChoqueDeNave(unaNave);
	}

	// Hace que el objeto receptor del mensaje sea afectado por por la nave
	// civil recibida.
	public void sufrirChoqueDeNaveCivil(NaveCivil unaNaveCivil) {
		this.comportamientoAlChocar.sufrirChoqueDeNaveCivil(unaNaveCivil);
	}

	// Hace que el objeto receptor del mensaje sea afectado por la nave militar
	// recibida.
	public void sufrirChoqueDeNaveMilitar(NaveMilitar unaNaveMilitar) {
		this.comportamientoAlChocar.sufrirChoqueDeNaveMilitar(unaNaveMilitar);
	}

	// Hace que el objeto receptor del mensaje sea afectado por el objeto
	// espacial recibido.
	public void sufrirChoqueDeObjetoEspacial(ObjetoEspacial unObjetoEspacial) {
		this.comportamientoAlChocar
				.sufrirChoqueDeObjetoEspacial(unObjetoEspacial);
	}

	// Hace que el objeto receptor del mensaje sea afectado por el proyectil
	// recibido.
	public void sufrirChoqueDeProyectil(Proyectil unProyectil) {
		this.comportamientoAlChocar.sufrirChoqueDeProyectil(unProyectil);
	}

	// El objeto se borra del escenario. Si no pertenece a ninguno, se levanta
	// una excepci�n.
	public void desaparecerDelEscenario() {

		if (this.escenario == null) {
			throw new ComposicionIncompleta(
					"El objeto no est� en ning�n escenario.");
		}

		this.escenario.borrarObjeto(this);
	}

	// Destruye al objeto y le impide realizar acciones en el futuro.
	public void destruir() {
		this.destruido = true;
	}

	public boolean estaDestruido() {
		return this.destruido;
	}

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	@Override
	public int getX() {
		return (int) this.proyeccion.proyectarPunto(this.posicion).getX();
	}

	@Override
	public int getY() {
		return (int) this.proyeccion.proyectarPunto(this.posicion).getY();
	}
	
	@Override
	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}

	public double getTamanio() {
		return this.tamanio;
	}

	public void setTamanio(double nuevoTamanio) {
		this.tamanio = nuevoTamanio;
	}

	public Escenario getEscenario() {
		return this.escenario;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	// Asigna una identificaci�n comparable al objeto. Si dos objetos tienen la
	// misma
	// identificaci�n, son del mismo tipo.
	public void setIdentificacion(String nuevaIdentificacion) {
		this.identificacion = nuevaIdentificacion;
	}

	// Cambia el escenario en donde se encuentra el objeto y agrega al mismo
	// en el nuevo.
	public void setEscenario(Escenario nuevoEscenario) {
		this.escenario = nuevoEscenario;
		this.escenario.agregarObjeto(this);
	}

	public ChoqueDeObjetoEspacial getComportamiento() {
		return this.comportamientoAlChocar;
	}

	protected void setComportamiento(
			ChoqueDeObjetoEspacial comportamientoAlChocar) {
		this.comportamientoAlChocar = comportamientoAlChocar;
	}

	@Override
	public Element guardar(Element contenedor) {
		
		contenedor.appendChild(GeneradorXml.generarElementoDe(posicion, "posicion"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(tamanio, "tamanio"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(escenario, "escenario"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(destruido, "destruido"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(identificacion, "identificacion"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
				
		this.posicion = (Point) ReconstructorDesdeXml.generarObjeto(atributos.get("posicion"));
		this.tamanio = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("tamanio"));
		this.escenario = (Escenario) ReconstructorDesdeXml.generarObjeto(atributos.get("escenario"));
		this.destruido = (Boolean) ReconstructorDesdeXml.generarObjeto(atributos.get("destruido"));
		this.comportamientoAlChocar = (ChoqueDeObjetoEspacial) ReconstructorDesdeXml.generarObjeto(atributos.get("comportamientoAlChocar"));
		this.identificacion = (String) ReconstructorDesdeXml.generarObjeto(atributos.get("identificacion"));
		
		return this;
	}
	
}
