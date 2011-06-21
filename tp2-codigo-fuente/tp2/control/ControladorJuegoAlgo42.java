package tp2.control;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tp2.modelo.Escenario;
import tp2.modelo.Mision;
import tp2.modelo.NaveMilitarControlada;
import tp2.modelo.Partida;
import tp2.modelo.Visible;
import tp2.modelo.ObjetoEspacial;
import tp2.modelo.extras.Agua;
import tp2.modelo.extras.Explosion;
import tp2.modelo.extras.Nube;
import tp2.modelo.extras.ObjetosExplosivos;
import tp2.vista.modelo.ParserObjetoIdAVista;
import tp2.vista.modelo.extras.VistaNubeTipo1;
import tp2.vista.modelo.extras.VistaNubeTipo2;
import tp2.vista.modelo.extras.VistaNubeTipo3;
import tp2.vista.modelo.mision.VistaBarraDeEstado;
import tp2.vista.modelo.mision.VistaInicioMision;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Circulo;

public class ControladorJuegoAlgo42 extends ControladorJuego {

	private Map<Visible, Dibujable> vistas = new HashMap<Visible, Dibujable>();
	private ProyeccionSobreSuperficieDeDibujo proyeccion;
	private HashMap<Visible, Dibujable> auxiliar; // BORRAR despu�s
	private VistaBarraDeEstado vistaBarraDeEstado;
	private VistaInicioMision vistaInicioMision;
	private Partida partida;
	private Mision mision;
	private Escenario escenario;
	
	public ControladorJuegoAlgo42(boolean activarReproductor) {
		super(activarReproductor);
	}

	@Override
	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		super.setSuperficieDeDibujo(superficieDeDibujo);
	}

	@Override
	public void comenzarJuego() {
		this.auxiliar = new HashMap<Visible, Dibujable>();
		do {
			if(this.mision != null){
				this.simularJuego();
			}
			super.comenzarJuego(1);
		} while (this.estaEnEjecucion());
	}
	
	private synchronized void simularJuego() {
		
		Collection<ObjetoEspacial> objetosCreados = this.escenario.getObjetosCreados();
		Collection<ObjetoEspacial> objetosMuertos = this.escenario.getObjetosMuertos();
		
		for(ObjetoEspacial objetoCreado: objetosCreados){
			
			this.agregarObjetoVivo(objetoCreado);
			
			// Creamos c�rculo para observar la forma del modelo (borrar despu�s)
			Dibujable circulo = new Circulo((int)(objetoCreado.getTamanio() * proyeccion.getEscalaX()));
			circulo.setPosicionable(objetoCreado);
			this.agregarDibujable(circulo);
			auxiliar.put(objetoCreado, circulo);
			// Fin Creamos c�rculo para observar la forma del modelo (borrar despu�s)
			
			this.agregarNuevaVista(objetoCreado);
			
		}
		
		for(ObjetoEspacial objetoMuerto: objetosMuertos){
			
			this.removerObjetoVivo(objetoMuerto);
			
			// Creamos c�rculo para observar la forma del modelo (borrar despu�s)
			this.removerDibujable(auxiliar.get(objetoMuerto));
			// Fin Creamos c�rculo para observar la forma del modelo (borrar despu�s)
			
			this.removerVista(objetoMuerto);
		}
		
		this.vistaBarraDeEstado.setPuntaje(this.mision.getEscenario().getPuntuacion());
		NaveMilitarControlada algo42 = this.mision.getNaveDelJugador();
		this.vistaBarraDeEstado.setPorcentajeDeEnergia((int)(100 * algo42.getEnergia() / algo42.getMaxEnergia()));
		this.mision.simularDurante(this.getIntervaloSimulacion() / 1000.0);
		
		if ((! this.vistaInicioMision.enEscena()) && (! this.vistaInicioMision.salioDeEscena())) {
			this.removerDibujable(vistaInicioMision);
			this.vistaInicioMision.salirDeEscena();
		}
		else if ((this.vistaInicioMision.enEscena()) && (! this.vistaInicioMision.salioDeEscena()))
			this.vistaInicioMision.correrCiclo();
	}

	private void construirVistasDeFondo() {
		Agua agua = new Agua(this.escenario);
		this.agregarNuevaVista(agua, -1);
				
		VistaNubeTipo1 vistaNube1 = new VistaNubeTipo1();
		Nube nube1 = new Nube(70, -100, 600, 5);
		vistaNube1.setPosicionable(nube1);
		this.agregarDibujable(vistaNube1, 1);
		this.agregarObjetoVivo(nube1);
		
		VistaNubeTipo2 vistaNube2 = new VistaNubeTipo2();
		Nube nube2 = new Nube(470, -300, 700, 6);
		vistaNube2.setPosicionable(nube2);
		this.agregarDibujable(vistaNube2, 1);
		this.agregarObjetoVivo(nube2);	
		
		VistaNubeTipo3 vistaNube3 = new VistaNubeTipo3();
		Nube nube3 = new Nube(280, -600, 700, 6);
		vistaNube3.setPosicionable(nube3);
		this.agregarDibujable(vistaNube3, 1);
		this.agregarObjetoVivo(nube3);	
		
		this.vistaBarraDeEstado = new VistaBarraDeEstado();
		this.agregarDibujable(vistaBarraDeEstado, 1);
		
		for(Dibujable objetoDibujable: vistaBarraDeEstado.getObjetosDibujablesDeLaVista()){
			this.agregarDibujable(objetoDibujable, 1);
		}
		
		this.vistaInicioMision = new VistaInicioMision();
		this.agregarDibujable(vistaInicioMision);
	}
	
	public void agregarNuevaVista(Visible objeto){
		this.agregarNuevaVista(objeto, 0);
	}

	public void agregarNuevaVista(Visible objeto, double prioridad){
		objeto.setProyeccion(proyeccion);
		Dibujable vista = ParserObjetoIdAVista.getVista(objeto, proyeccion);
		// Borrar despu�s:
		if (vista == null) {
			vista = new Circulo(
					(int) (objeto.getTamanio() * proyeccion.getEscalaX()));
		}
		// Fin borrar despu�s.
		vista.setPosicionable(objeto);
		this.agregarDibujable(vista);
		this.vistas.put(objeto, vista);
	}
	
	public void removerVista(Visible objeto){
		this.removerDibujable(this.vistas.get(objeto));
		this.vistas.remove(objeto);
		if(ObjetosExplosivos.esExplosivo(objeto)){
			Explosion explosion = new Explosion(objeto, 10, objeto.getTamanio());
			this.agregarObjetoVivo(explosion);
			this.agregarNuevaVista(explosion);
		}
	}

	public Partida getPartida() {
		return partida;
	}

	public synchronized void setPartida(Partida partida) {
		this.partida = partida;
		this.mision = partida.getMisionActual();
		this.escenario = mision.getEscenario();
		this.proyeccion = new ProyeccionSobreSuperficieDeDibujo(this.escenario.getAreaDeCombate(), new Rectangle(DimensionesDeVentana.ancho, DimensionesDeVentana.alto));
		this.construirVistasDeFondo();
		this.vistaInicioMision.setNumeroDeMision(1);
	}
	
}
