package tp2.control;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import tp2.modelo.Escenario;
import tp2.modelo.Mision;
import tp2.modelo.NaveMilitarControlada;
import tp2.modelo.ObjetoEspacial;
import tp2.modelo.Partida;
import tp2.modelo.Visible;
import tp2.modelo.extras.Agua;
import tp2.modelo.extras.Explosion;
import tp2.modelo.extras.Nube;
import tp2.modelo.extras.ObjetosExplosivos;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.menuPrincipal.MenuPrincipal;
import tp2.vista.modelo.ParserObjetoIdAVista;
import tp2.vista.modelo.extras.VistaAgua;
import tp2.vista.modelo.extras.VistaNubeTipo1;
import tp2.vista.modelo.extras.VistaNubeTipo2;
import tp2.vista.modelo.extras.VistaNubeTipo3;
import tp2.vista.modelo.mision.VistaBarraDeEstado;
import tp2.vista.modelo.mision.VistaInicioMision;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Circulo;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class ControladorJuegoAlgo42 extends ControladorJuego {

	private Map<Visible, Dibujable> vistas = new HashMap<Visible, Dibujable>();
	private ProyeccionSobreSuperficieDeDibujo proyeccion;
	private VistaBarraDeEstado vistaBarraDeEstado;
	private VistaInicioMision vistaInicioMision;
	private Partida partida;
	private Mision mision;
	private Escenario escenario;
	private Boolean corriendoElJuego;
	private Collection<Dibujable> dibujosDeFondo;
	private ControladorDelJugador controladorDelJugador;
	private VentanaPrincipal ventana;
	
	public ControladorJuegoAlgo42(boolean activarReproductor) {
		super(activarReproductor);
		this.corriendoElJuego = false;
	}

	@Override
	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		super.setSuperficieDeDibujo(superficieDeDibujo);
	}

	@Override
	public void comenzarJuego() {
		do {
			if(!this.corriendoElJuego){
				if(partida != null){
					this.borrarObjetosDelJuego();
					this.borrarObjetosDelFondo();
				}
				this.partida = null;
			}
			else if(this.partida != null){
				this.corriendoElJuego = true;
				if(this.partida.estaEnCurso()){
					this.simularJuego();
					this.controlarPartida();
				}
			}
			super.comenzarJuego(1);
		} while (this.estaEnEjecucion());
	}
	
	private void borrarObjetosDelJuego() {
		
		Set<Visible> aux = new HashSet<Visible>(this.vistas.keySet());
		for(Visible visible: aux){
			this.removerVista(visible);
		}
	}
	
	private void borrarObjetosDelFondo() {
		for(Dibujable dibujable: this.dibujosDeFondo){
			this.removerDibujable(dibujable);
		}
	}

	private void controlarPartida() {
		if(this.escenario.getPuntuacion() > 50){
			this.borrarObjetosDelJuego();
			this.partida.avanzarNivel();
			if(this.partida.estaGanada()){
				// Se gan�
				this.corriendoElJuego = false;
				this.abrirMenuPrincipal();
				return;
			}
			this.setMision(this.partida.getMisionActual());
		}
		else if(this.mision.getNaveDelJugador().estaDestruido()){
			this.borrarObjetosDelJuego();
			this.partida.perderVida();
			if(partida.getVidas() == 0){
				// Game Over
				this.corriendoElJuego = false;
				this.abrirMenuPrincipal();
				return;
			}
			this.setMision(this.partida.getMisionActual());
		}
	}
	
	private void abrirMenuPrincipal(){
		this.finalizarJuego();
		MenuPrincipal menuPrincipal = new MenuPrincipal(ventana);
		menuPrincipal.mostrar();
		menuPrincipal.activarControl();
		menuPrincipal.getAudio().play();
	}

	private synchronized void simularJuego() {
		
		Collection<ObjetoEspacial> objetosCreados = this.escenario.getObjetosCreados();
		Collection<ObjetoEspacial> objetosMuertos = this.escenario.getObjetosMuertos();
		
		for(ObjetoEspacial objetoCreado: objetosCreados){
			
			this.agregarObjetoVivo(objetoCreado);
			this.agregarNuevaVista(objetoCreado);
			
		}
		
		for(ObjetoEspacial objetoMuerto: objetosMuertos){
			
			this.removerObjetoVivo(objetoMuerto);
			this.removerVista(objetoMuerto);
		}
		
		this.vistaBarraDeEstado.setPuntaje(this.mision.getEscenario().getPuntuacion());
		NaveMilitarControlada algo42 = this.mision.getNaveDelJugador();
		this.vistaBarraDeEstado.setPorcentajeDeEnergia((int)(100 * algo42.getEnergia() / algo42.getMaxEnergia()));
		this.vistaBarraDeEstado.setVidas(this.partida.getVidas());
		this.mision.simularDurante(this.getIntervaloSimulacion() / 1000.0);
		
		if ((! this.vistaInicioMision.enEscena()) && (! this.vistaInicioMision.salioDeEscena())) {
			this.removerDibujable(vistaInicioMision);
			this.vistaInicioMision.salirDeEscena();
		}
		else if ((this.vistaInicioMision.enEscena()) && (! this.vistaInicioMision.salioDeEscena()))
			this.vistaInicioMision.correrCiclo();
	}

	private void construirVistasDeFondo() {
		
		this.dibujosDeFondo = new HashSet<Dibujable>();
		
		Agua agua = new Agua(this.escenario);
		agua.setProyeccion(proyeccion);
		Dibujable vistaAgua = new VistaAgua(agua);
		vistaAgua.setPosicionable(agua);
		this.agregarDibujable(vistaAgua, -1);
		this.dibujosDeFondo.add(vistaAgua);
				
		VistaNubeTipo1 vistaNube1 = new VistaNubeTipo1();
		Nube nube1 = new Nube(70, -100, 600, 5);
		vistaNube1.setPosicionable(nube1);
		this.agregarDibujable(vistaNube1, 1);
		this.agregarObjetoVivo(nube1);
		this.dibujosDeFondo.add(vistaNube1);
		
		VistaNubeTipo2 vistaNube2 = new VistaNubeTipo2();
		Nube nube2 = new Nube(470, -300, 700, 6);
		vistaNube2.setPosicionable(nube2);
		this.agregarDibujable(vistaNube2, 1);
		this.agregarObjetoVivo(nube2);
		this.dibujosDeFondo.add(vistaNube2);
		
		VistaNubeTipo3 vistaNube3 = new VistaNubeTipo3();
		Nube nube3 = new Nube(280, -600, 700, 6);
		vistaNube3.setPosicionable(nube3);
		this.agregarDibujable(vistaNube3, 1);
		this.agregarObjetoVivo(nube3);
		this.dibujosDeFondo.add(vistaNube3);
		
		this.vistaBarraDeEstado = new VistaBarraDeEstado();
		this.agregarDibujable(vistaBarraDeEstado, 1);
		this.dibujosDeFondo.add(vistaBarraDeEstado);
		
		for(Dibujable objetoDibujable: vistaBarraDeEstado.getObjetosDibujablesDeLaVista()){
			this.agregarDibujable(objetoDibujable, 1);
			this.dibujosDeFondo.add(objetoDibujable);
		}

	}
	
	public Dibujable agregarNuevaVista(Visible objeto){
		return this.agregarNuevaVista(objeto, 0);
	}

	public Dibujable agregarNuevaVista(Visible objeto, double prioridad){
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
		return vista;
	}
	
	public void removerVista(Visible objeto){
		this.removerDibujable(this.vistas.get(objeto));
		this.vistas.remove(objeto);
		if((ObjetosExplosivos.esExplosivo(objeto)) && (this.corriendoElJuego)){
			Explosion explosion = new Explosion(objeto, 10, objeto.getTamanio());
			this.agregarObjetoVivo(explosion);
			this.agregarNuevaVista(explosion);
		}
	}

	public Partida getPartida() {
		return partida;
	}

	public synchronized void iniciarJuego(Partida partida) {
		this.corriendoElJuego = true;
		this.partida = partida;
		this.setMision(partida.getMisionActual());
		this.construirVistasDeFondo();
	}
	
	public synchronized void finalizarJuego(){
		this.corriendoElJuego = false;
	}

	private void setMision(Mision mision) {
		this.mision = mision;
		this.escenario = mision.getEscenario();
		this.proyeccion = new ProyeccionSobreSuperficieDeDibujo(this.escenario.getAreaDeCombate(), new Rectangle(DimensionesDeVentana.ancho, DimensionesDeVentana.alto));
		if(this.controladorDelJugador != null){
			this.controladorDelJugador.setNaveDelJugador(this.mision.getNaveDelJugador());
		}
		this.construirVistaDeInicioDeMision();
	}

	private void construirVistaDeInicioDeMision() {
		this.vistaInicioMision = new VistaInicioMision();
		this.agregarDibujable(vistaInicioMision, 1);
		this.vistaInicioMision.setNumeroDeMision(this.partida.getNivelActual());
	}

	public void setControladorDelJugador(
			ControladorDelJugador controladorDelJugador) {
		this.controladorDelJugador = controladorDelJugador;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
}
