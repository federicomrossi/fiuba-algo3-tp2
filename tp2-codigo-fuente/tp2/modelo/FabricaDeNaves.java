package tp2.modelo;

import tp2.auxiliares.Point;

// La f�brica de armas puede crear las naves particulares del juego.
public class FabricaDeNaves {

	private Escenario escenarioActual;
	private String equipoDeLaNave;
	private Flota flotaEnemiga;
	private FabricaDeArmas fabricaDeArmas;
	
	// Constructor
	public FabricaDeNaves(Escenario unEscenario,String unEquipo, Flota unaFlotaEnemiga){
		
	}
	
	// Crea un Algo42 en el escenario de la f�brica y con el equipo de la 
	// misma, en la posici�n recibida. El mismo tiene una energ�a de 500, 
	// un tama�o de 7, velocidad igual a 25 y un ca��n l�ser. Su vuelo es en 
	// zig zag hacia abajo. Su vuelo (inicialmente quieto) y disparos pueden 
	// controlarse y puede adquirir bonos de otras naves.
	public NaveMilitarControlada crearAlgo42En(Point unaPosicion){
		return null;
	}
	
	// Crea un avi�n civil en el escenario de la f�brica y con el equipo de la 
	// misma, en la posici�n recibida. El mismo tiene una energ�a de 1, un tama�o 
	// de 5 y velocidad igual a 5. Su vuelo es en l�nea recta hacia abajo. Su 
	// penalizaci�n por destrucci�n es de 300.
	public NaveCivil crearAvionCivilEn(Point unaPosicion){
		return null;
	}
	
	// Crea una avioneta en el escenario de la f�brica y con el equipo de la misma, 
	// en la posici�n recibida. La misma tiene una energ�a de 10, un tama�o de 3, 
	// velocidad igual a 15 y un ca��n l�ser. Su vuelo es de ida 80 unidades hacia 
	// abajo, y luego de vuelta hacia arriba. Su puntuaci�n por destrucci�n es de 20.
	public NaveEnemiga crearAvionetaEn(Point unaPosicion){
		return null;
	}
	
	// Crea un bombardero en el escenario de la f�brica y con el equipo de la misma, 
	// en la posici�n recibida. El mismo tiene una energ�a de 100, un tama�o de 7, 
	// velocidad igual a 7 y un ca��n l�ser, un lanzacohetes y un lanzatorpedos 
	// dirigido. Su vuelo es en zig zag hacia abajo. Su puntuaci�n por destrucci�n 
	// es de 30.
	public NaveEnemiga crearBombarderoEn(Point unaPosicion){
		return null;
	}
	
	// Crea un explorador en el escenario de la f�brica y con el equipo de la misma, 
	// en la posici�n recibida. El mismo tiene una energ�a de 1, un tama�o de 5, 
	// velocidad igual a 12 y ninguna arma. Su vuelo es 40 unidades hacia la derecha, 
	// luego dos c�rculos horarios con centro 20 unidades m�s abajo, y finalmente salida
	// hacia la derecha. Su puntuaci�n por destrucci�n es de 50.
	public NaveEnemiga crearExploradorEn(Point unaPosicion){
		return null;
	}
	
	// Crea un grupo de tres cazas en el escenario de la f�brica y con el equipo de 
	// la misma, en la posici�n recibida. El mismo tiene una energ�a de 30, un tama�o
	// de 6, velocidad igual a 10 y un lanzatorpedos no dirigido. Su vuelo es en V 
	// hacia abajo. Su puntuaci�n por destrucci�n es de 30. Devuelve la colecci�n de 
	// los cazas.
	public NaveEnemiga[] crearGrupoCazaEn(Point unaPosicion){
		return null;
	}
	
	// Crea un gu�a enemigo en el escenario de la f�brica y con el equipo de la misma,
	// en la posici�n recibida. El mismo tiene una energ�a de 1000, un tama�o de 15, 
	// velocidad igual a 5 y ninguna arma. Su vuelo es: entra 50 unidades hacia abajo 
	// y luego se mueve en peque�os c�rculos de centro: 5 unidades a la derecha y 
	// antihorario.
	public NaveGuia crearGuiaEnemigoEn(Point unaPosicion){
		return null;
	}
	
	// Crea un helic�ptero federal en el escenario de la f�brica y con el equipo de la 
	// misma, en la posici�n recibida. El mismo tiene una energ�a de 1, un tama�o de 5 
	// y velocidad igual a 5. Su vuelo es: l�nea recta 30 unidades hacia abajo, un 
	// c�rculo antihorario con centro 10 unidades a la derecha, y salida hacia abajo. 
	// Su penalizaci�n por destrucci�n es de 200.
	public NaveCivil crearHelicopteroFederalEn(Point unaPosicion){
		return null;
	}
	
	public void setEquipoDeLaNave(String nuevoEquipo){

	}
	
	protected void setEscenario(Escenario nuevoEscenario){
		
	}
	
	public void setFabricaDeArmas(FabricaDeArmas nuevaFabricaDeArmas){
		
	}
	
	protected void setFlotaEnemiga(Flota nuevaFlota){
		
	}	
}
