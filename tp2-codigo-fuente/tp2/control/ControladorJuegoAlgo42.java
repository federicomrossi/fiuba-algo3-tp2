package tp2.control;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class ControladorJuegoAlgo42 extends ControladorJuego {

	public ControladorJuegoAlgo42(boolean activarReproductor) {
		super(activarReproductor);
	}

	@Override
	public void comenzarJuego() {
		do {
			// ***L�gica adicional*** Falta implementar
			super.comenzarJuego(1);
			// ***L�gica adicional***
		} while (this.estaEnEjecucion());
	}

}
