package tp2.modelo;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;
import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Cada misi�n tendr� configurado las preferencias del nivel (aeronaves en sus
// respectivas flotas, el jugador, el escenario en donde interactuan). 	r
public class Mision implements IGuardable {

	private Escenario escenario;
	private NaveMilitarControlada naveDelJugador;
	private FabricaDeNaves fabricaJugador, fabricaEnemiga;
	private Flota flotaEnemiga, flotaAliada;
	private Jugador jugador;
	private Map<Double, Collection<ParCadenaPosicion>> navesPorTiempoDeSpawn;
	private PriorityQueue<Double> tiemposDeSpawn;
	private double tiempoActual;

	// Constructor
	public Mision(Escenario escenario) {
		this.escenario = escenario;
		this.fabricaJugador = new FabricaDeNaves(this.escenario,
				"EquipoJugador", null);
		this.naveDelJugador = this.nuevaNaveDelJugador();
		this.flotaAliada = new Flota(this.naveDelJugador);
		this.fabricaEnemiga = new FabricaDeNaves(this.escenario,
				"EquipoEnemigo", this.flotaAliada);
		this.flotaEnemiga = this.nuevaFlotaEnemiga();
		this.getEscenario().agregarObjeto(this.flotaEnemiga.getNaveGuia());
		this.tiempoActual = 0;
	}

	private NaveMilitarControlada nuevaNaveDelJugador() {
		Point posicion = new Point(this.escenario.getAreaDeCombate()
				.getCenterX(), ValoresDeNaves.algo42Tamanio * 2);
		NaveMilitarControlada naveDelJugador = this.fabricaJugador
				.crearAlgo42En(posicion);
		return naveDelJugador;
	}

	private Flota nuevaFlotaEnemiga() {
		Point posicion = new Point(this.escenario.getAreaDeCombate()
				.getCenterX(), this.escenario.getAreaDeCombate().getHeight()
				+ ValoresDeNaves.guiaEnemigoVueloLineaRectaLongitudTrayectoria
				- ValoresDeNaves.guiaEnemigoTamanio * 3);
		NaveGuia naveGuia = this.fabricaEnemiga.crearGuiaEnemigoEn(posicion);
		return naveGuia.getFlota();
	}

	// Genera una misi�n a partir de la colecci�n de datos recibida. La clave es
	// el tiempo en que se pretende crear una nave, y el valor es una colecci�n
	// de pares cadena-posici�n, cuya cadena indica cu�l es la nave a ser creada
	public void generar(Map<Double, Collection<ParCadenaPosicion>> datos) {
		this.navesPorTiempoDeSpawn = datos;
		this.tiemposDeSpawn = new PriorityQueue<Double>(datos.keySet());
	}

	// Hace avanzar el tiempo en el escenario del juego. Si se lleg� a los 1000
	// puntos, se avanza al siguiente nivel. Si se destruy� al gu�a enemigo, se
	// inicia una nueva ronda, mientras las naves de la flota anterior viajan
	// abandonando elescenario.
	public void simularDurante(double unTiempo) {
		this.tiempoActual += unTiempo;
		Double proximoTiempoDeSpawn = this.tiemposDeSpawn.peek();
		while((proximoTiempoDeSpawn != null) && (this.tiempoActual >= proximoTiempoDeSpawn)){
			double tiempo = this.tiemposDeSpawn.poll();
			for(ParCadenaPosicion datoDeLaNave: navesPorTiempoDeSpawn.get(tiempo)){
				Nave nave = ParserDeNaves.fabricarNave(datoDeLaNave, fabricaEnemiga, flotaEnemiga);
				this.escenario.agregarObjeto(nave);
			}
			proximoTiempoDeSpawn = this.tiemposDeSpawn.peek();
		}
		this.escenario.avanzarTiempoEn(unTiempo);
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador nuevoJugador) {
		this.jugador = nuevoJugador;
	}

	@Override
	public Element guardar(Element contenedor) {
		contenedor.appendChild(GeneradorXml.generarElementoDe(escenario,"escenario"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(escenario,"flotaEnemiga"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(flotaAliada,"flotaAliada"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(jugador,"jugador"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		this.jugador = (Jugador) ReconstructorDesdeXml.generarObjeto(atributos
				.get("jugador"));
		this.flotaEnemiga = (Flota) ReconstructorDesdeXml
				.generarObjeto(atributos.get("flotaEnemiga"));
		this.flotaAliada = (Flota) ReconstructorDesdeXml
				.generarObjeto(atributos.get("flotaAliada"));
		this.escenario = (Escenario) ReconstructorDesdeXml
				.generarObjeto(atributos.get("escenario"));
		return this;
	}
}
