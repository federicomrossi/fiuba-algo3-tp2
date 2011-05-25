package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;

public class Nave extends ObjetoVolador {

	private double energia;
	private double maxEnergia;

	// Inicializa la nave sin un vuelo asignado, con la posici�n, tama�o,
	// escenario, velocidad y energ�a recibidos. La agrega al escenario.
	public Nave(Point posicion, double tamanio, Escenario escenario,
			double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad);
		this.setEnergia(energia);
	}

	@Override
	// Ordena a la nave actuar durante el tiempo espec�ficado. La nave debe
	// tener un vuelo y un escenario especificados, o de lo contrario se
	// levanta una excepci�n.
	public void actuarDurante(double unTiempo) {
		if (this.estaDestruido()) {
			this.desaparecerDelEscenario();
			return;
		}
		if (unTiempo <= 0) {
			return;
		}
		Iterable<ObjetoEspacial> objetosChocados = this.getEscenario()
				.getObjetosEnColisionCon(this);
		for(ObjetoEspacial objetoChocado: objetosChocados){
			this.chocarCon(objetoChocado);			
		}
		this.moverDurante(unTiempo);
	}

	// Disminuye la energ�a de la nave seg�n el da�o recibido. Si la energ�a
	// llega a cero, la nave se destruye.
	public void recibirDanio(double unDanio) {
		this.energia -= unDanio;
		if (this.energia <= 0) {
			this.destruir();
		}
	}

	// Aumenta la energia de la nave en la cantidad recibida (limit�ndola por
	// la m�xima energ�a que tiene). Dicha cantidad debe ser mayor a cero.
	public void recuperarEnergiaEn(double unaCantidad) {
		if(unaCantidad <= 0) {
			throw new ValorInvalido("El valor de recuperaci�n de energ�a no puede ser negativo.");
		}
		this.energia += unaCantidad;
		if(this.energia > this.maxEnergia){
			this.energia = this.maxEnergia;
		}
	}

	@Override
	// Hace sufrir al objeto recibido los efectos de chocar una nave, seg�n su
	// comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		unObjetoEspacial.sufrirChoqueDeNave(this);
	}

	// Cambia el valor de la energ�a y m�xima energ�a de la nave al valor
	// recibido. La energ�a debe ser mayor a cero.
	public void setEnergia(double energia) {
		this.energia = energia;
		this.maxEnergia = energia;
	}

	public double getEnergia() {
		return energia;
	}

	public double getMaxEnergia() {
		return maxEnergia;
	}
	
}
