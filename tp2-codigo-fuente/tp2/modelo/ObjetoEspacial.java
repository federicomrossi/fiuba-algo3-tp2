package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class ObjetoEspacial {

	protected Point posicion;
	protected double tamanio;
	protected Escenario escenario;
	protected boolean destruido;
	protected ChoqueDeObjetoEspacial comportamientoAlChocar;


	// Constructor
	// Inicializa el objeto con la posici�n, tama�o y escenario recibidos.
	// Lo agrega al escenario.
	public ObjetoEspacial(Point posicion, double tamanio, Escenario escenario) {

		this.posicion = posicion;
		this.tamanio = tamanio;
		this.escenario = escenario;
		this.destruido = false;
		// Falta agregarlo al escenario
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

	// Hace chocar al objeto recibido con el receptor del mensaje. Ambos sufren el 
	// efecto del mismo seg�n c�mo est� definido su comportamiento ante el mismo.
	public void chocarCon(ObjetoEspacial unObjetoEspacial) {
		
	}
		
	// Este m�todo tiene car�cter de 'protegido de clase' (s�lo deben llamarlo 
	// objetos de esta dentro de esta jerarqu�a). El objeto que recibe el mensaje 
	// responde el choque y le hace sufrir al objeto recibido sus efectos, de 
	// acuerdo al comportamiento frente al choque que este �ltimo tenga.
	// El receptor le pide al objeto recibido que le diga c�mo tiene que ser 
	// afectado al chocar con los dem�s objetos existentes. Luego es el receptor el 
	// que selecciona de entre todo el comportamiento el correspondiente a �l mismo.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		
	}
		
	// Hace que el objeto receptor del mensaje sea afectado por el bono recibido.
	public void sufrirChoqueDeBono(Bono unBono) {
		
	}
	
	// Hace que el objeto receptor del mensaje sea afectado por la nave recibida.
	public void sufrirChoqueDeNave(Nave unaNave) {
		
	}
	
	// Hace que el objeto receptor del mensaje sea afectado por  por la nave civil 
	// recibida.
	public void sufrirChoqueDeNaveCivil(NaveCivil unaNaveCivil) {
		
	}
	
	// Hace que el objeto receptor del mensaje sea afectado por la nave militar 
	// recibida.
	public void sufrirChoqueDeNaveMilitar(NaveMilitar unaNaveMilitar) {
		
	}
	
	// Hace que el objeto receptor del mensaje sea afectado por el objeto espacial 
	// recibido.
	public void sufrirChoqueDeObjetoEspacial(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	// Hace que el objeto receptor del mensaje sea afectado por el proyectil 
	// recibido.
	public void sufrirChoqueDeProyectil(Proyectil unProyectil) {
		
	}
	
	// El objeto se borra del escenario. Si no pertenece a ninguno, se levanta una 
	// excepci�n.
	public void desaparecerDelEscenario() {
		
	}
	
	// Destruye al objeto y le impide realizar acciones en el futuro.
	public void destruir() {
		destruido = true;
	}

	public boolean estaDestruido() {
		return destruido;
	}
		
	public Point getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}

	public double getTamanio() {
		return tamanio;
	}
	
	public void setTamanio(double nuevoTamanio) {
		
	}

	public Escenario getEscenario() {
		return escenario;
	}
	
	public void setEscenario(Escenario nuevoEscenario) {
		
	}
	
	public ChoqueDeObjetoEspacial getComportamiento() {
		return comportamientoAlChocar;
	}
}
