package tp2.modelo;

import java.util.*;

import tp2.auxiliares.Point;

// La f�brica de armas puede crear las naves particulares del juego.
public class FabricaDeNaves {

	private Escenario escenarioActual;
	private String equipoDeLaNave;
	private Flota flotaEnemiga;
	private FabricaDeArmas fabricaDeArmas;
	
	// Constructor
	public FabricaDeNaves(Escenario unEscenario,String unEquipo, Flota unaFlotaEnemiga){
		escenarioActual = unEscenario;
		equipoDeLaNave = unEquipo;
		flotaEnemiga = unaFlotaEnemiga;
		fabricaDeArmas = new FabricaDeArmas(unEscenario);
	}
	
	// Crea un Algo42 en el escenario de la f�brica y con el equipo de la 
	// misma, en la posici�n recibida. El mismo tiene una energ�a de 500, 
	// un tama�o de 7, velocidad igual a 25 y un ca��n l�ser. Su vuelo es en 
	// zig zag hacia abajo. Su vuelo (inicialmente quieto) y disparos pueden 
	// controlarse y puede adquirir bonos de otras naves.
	public NaveMilitarControlada crearAlgo42En(Point unaPosicion){
		
		NaveMilitarControlada algo42 = new NaveMilitarControlada(unaPosicion,7,escenarioActual,25,500);
		algo42.setEquipo(equipoDeLaNave);
		Arma canionLaser = fabricaDeArmas.crearCanionLaser();
		canionLaser.setDireccionDeDisparo(new Point(1,0));
		algo42.agregarArma(canionLaser);
		
		return algo42;
	}
	
	// Crea un avi�n civil en el escenario de la f�brica y con el equipo de la 
	// misma, en la posici�n recibida. El mismo tiene una energ�a de 1, un tama�o 
	// de 5 y velocidad igual a 5. Su vuelo es en l�nea recta hacia abajo. Su 
	// penalizaci�n por destrucci�n es de 300.
	public NaveCivil crearAvionCivilEn(Point unaPosicion){
		
		NaveCivil avionCivil = new NaveCivil(unaPosicion,5,escenarioActual,5,1);
		avionCivil.setEquipo(equipoDeLaNave);
		avionCivil.setVuelo(new VueloEnLineaRecta(avionCivil,new Point(0,-1)));
		avionCivil.setPenalizacion(300);
		
		return avionCivil;
	}
	
	// Crea una avioneta en el escenario de la f�brica y con el equipo de la misma, 
	// en la posici�n recibida. La misma tiene una energ�a de 10, un tama�o de 3, 
	// velocidad igual a 15 y un ca��n l�ser. Su vuelo es de ida 80 unidades hacia 
	// abajo, y luego de vuelta hacia arriba. Su puntuaci�n por destrucci�n es de 20.
	public NaveEnemiga crearAvionetaEn(Point unaPosicion){
		
		NaveEnemiga avioneta = new NaveEnemiga(unaPosicion,3,escenarioActual,15,10);
		avioneta.setEquipo(equipoDeLaNave);
		avioneta.agregarArma(fabricaDeArmas.crearCanionLaser());
		avioneta.setVuelo(new VueloDeIdaYVuelta(avioneta,new Point(0,-80)));
		avioneta.setPuntuacion(20);
		
		return avioneta;
	}
	
	// Crea un bombardero en el escenario de la f�brica y con el equipo de la misma, 
	// en la posici�n recibida. El mismo tiene una energ�a de 100, un tama�o de 7, 
	// velocidad igual a 7 y un ca��n l�ser, un lanzacohetes y un lanzatorpedos 
	// dirigido. Su vuelo es en zig zag hacia abajo. Su puntuaci�n por destrucci�n 
	// es de 30.
	public NaveEnemiga crearBombarderoEn(Point unaPosicion){

		NaveEnemiga bombardero = new NaveEnemiga(unaPosicion,7,escenarioActual,7,100);
		bombardero.setEquipo(equipoDeLaNave);
		bombardero.agregarArma(fabricaDeArmas.crearCanionLaser());
		bombardero.agregarArma(fabricaDeArmas.crearLanzaCohetes());
		ArmaDirigida lanzaTorpedos = fabricaDeArmas.crearLanzaTorpedos();
		lanzaTorpedos.setFlotaObjetivo(flotaEnemiga);
		bombardero.agregarArma(lanzaTorpedos);
		bombardero.setVuelo(new VueloEnZigZag(bombardero,10,new Point(0,-1)));
		bombardero.setPuntuacion(30);
		bombardero.setBono(new BonoDeArmas(5));
		
		return bombardero;
	}
	
	// Crea un explorador en el escenario de la f�brica y con el equipo de la misma, 
	// en la posici�n recibida. El mismo tiene una energ�a de 1, un tama�o de 5, 
	// velocidad igual a 12 y ninguna arma. Su vuelo es 40 unidades hacia la derecha, 
	// luego dos c�rculos horarios con centro 20 unidades m�s abajo, y finalmente salida
	// hacia la derecha. Su puntuaci�n por destrucci�n es de 50.
	public NaveEnemiga crearExploradorEn(Point unaPosicion){
		
		NaveEnemiga explorador = new NaveEnemiga(unaPosicion,5,escenarioActual,12,1);
		explorador.setEquipo(equipoDeLaNave);
		VueloCompuesto vuelo = new VueloCompuesto(explorador);
		vuelo.agregarVuelo(new VueloEnLineaRecta(explorador,new Point(1,0)),40);
		VueloEnCirculos _vuelo = new VueloEnCirculos(explorador,new Point(0,-20),false);
		vuelo.agregarVuelo(_vuelo,2 * (_vuelo.trayectoriaPorPeriodo()));
		vuelo.agregarVuelo(new VueloEnLineaRecta(explorador,new Point(1,0)),40);
		explorador.setVuelo(vuelo);
		explorador.setPuntuacion(50);
		
		return explorador;
	}
	
	// Crea un grupo de tres cazas en el escenario de la f�brica y con el equipo de 
	// la misma, en la posici�n recibida. El mismo tiene una energ�a de 30, un tama�o
	// de 6, velocidad igual a 10 y un lanzatorpedos no dirigido. Su vuelo es en V 
	// hacia abajo. Su puntuaci�n por destrucci�n es de 30. Devuelve la colecci�n de 
	// los cazas.
	public List<NaveEnemiga> crearGrupoCazaEn(Point unaPosicion){
		
		ArrayList<NaveEnemiga> cazas = new ArrayList<NaveEnemiga>();
		for(int i=0 ; i < 3 ; i++){
			//Calculamos la posici�n para formar una V
			Point posicion = unaPosicion.sumarCon((new Point(0,10).multiplicar(i%2)).sumarCon(new Point(10,0).multiplicar(i - 2)));
			NaveEnemiga caza = new NaveEnemiga(posicion,6,escenarioActual,10,30);
			caza.setEquipo(equipoDeLaNave);
			caza.agregarArma(fabricaDeArmas.crearLanzaTorpedos());
			caza.setVuelo(new VueloEnLineaRecta(caza,new Point(0,-1)));
			caza.setPuntuacion(30);
			caza.setBono(new BonoDeEnergia(5));
			cazas.add(caza);
		}
		
		return cazas;
	}
	
	// Crea un gu�a enemigo en el escenario de la f�brica y con el equipo de la misma,
	// en la posici�n recibida. El mismo tiene una energ�a de 1000, un tama�o de 15, 
	// velocidad igual a 5 y ninguna arma. Su vuelo es: entra 50 unidades hacia abajo 
	// y luego se mueve en peque�os c�rculos de centro: 5 unidades a la derecha y 
	// antihorario.
	public NaveGuia crearGuiaEnemigoEn(Point unaPosicion){
		
		NaveGuia guiaEnemigo = new  NaveGuia(unaPosicion,15,escenarioActual,5,1000);
		guiaEnemigo.setEquipo(equipoDeLaNave);
		VueloCompuesto vuelo = new VueloCompuesto(guiaEnemigo);
		vuelo.agregarVuelo(new VueloEnLineaRecta(guiaEnemigo,new Point(1,0)),50);
		VueloEnCirculos _vuelo = new VueloEnCirculos(guiaEnemigo,new Point(5,0),true);
		vuelo.agregarVuelo(_vuelo,1);
		vuelo.agregarVuelo(new VueloEnLineaRecta(guiaEnemigo,new Point(1,0)),40);
		guiaEnemigo.setVuelo(vuelo);
		
		return guiaEnemigo;
	}
	
	// Crea un helic�ptero federal en el escenario de la f�brica y con el equipo de la 
	// misma, en la posici�n recibida. El mismo tiene una energ�a de 1, un tama�o de 5 
	// y velocidad igual a 5. Su vuelo es: l�nea recta 30 unidades hacia abajo, un 
	// c�rculo antihorario con centro 10 unidades a la derecha, y salida hacia abajo. 
	// Su penalizaci�n por destrucci�n es de 200.
	public NaveCivil crearHelicopteroFederalEn(Point unaPosicion){
		
		NaveCivil helicopteroFederal = new NaveCivil(unaPosicion,5,escenarioActual,5,1);
		helicopteroFederal.setEquipo(equipoDeLaNave);
		VueloCompuesto vuelo = new VueloCompuesto(helicopteroFederal);
		vuelo.agregarVuelo(new VueloEnLineaRecta(helicopteroFederal,new Point(0,-1)),30);
		VueloEnCirculos _vuelo = new VueloEnCirculos(helicopteroFederal,new Point(10,0),true);
		vuelo.agregarVuelo(_vuelo,2 * (_vuelo.trayectoriaPorPeriodo()));
		vuelo.agregarVuelo(new VueloEnLineaRecta(helicopteroFederal,new Point(0,-1)),30);
		helicopteroFederal.setVuelo(vuelo);
		helicopteroFederal.setPenalizacion(200);
		
		return helicopteroFederal;
	}
	
	public void setEquipoDeLaNave(String nuevoEquipo){
		equipoDeLaNave = nuevoEquipo;
	}
	
	public void setEscenario(Escenario nuevoEscenario){
		
		escenarioActual = nuevoEscenario;
		
		if(fabricaDeArmas != null){
			fabricaDeArmas.setEscenario(nuevoEscenario);
		}
	}
	
	public void setFabricaDeArmas(FabricaDeArmas nuevaFabricaDeArmas){
		fabricaDeArmas = nuevaFabricaDeArmas;
		
	}
	
	public void setFlotaEnemiga(Flota nuevaFlota){
		flotaEnemiga = nuevaFlota;
	}	
}
