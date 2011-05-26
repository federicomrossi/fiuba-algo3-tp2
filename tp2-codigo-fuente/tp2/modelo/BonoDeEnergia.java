package tp2.modelo;

import tp2.modelo.excepciones.*;

// Es un bono que al usarse, da las armas de la nave due�a del mismo a la que lo 
// haya usado.
public class BonoDeEnergia extends Bono {
	
	
	// Constructor
	// Inicializa el bono con el tama�o recibido.
	public BonoDeEnergia(double tamanio) {
		super(tamanio);
	}
	
	@Override
	// La nave recibida toma las armas de la enemiga que tir� el bono. Si el bono 
	// ya se us� levanta una excepci�n.
	public void entregarBonoA(NaveMilitar unaNaveMilitar) {
		if (this.fueUsado()){
			throw new BonoUtilizado("El bono ya ha sido utilizado previamente");
		}
		unaNaveMilitar.recuperarEnergiaEn(this.getNaveDuenia().getMaxEnergia());
		this.destruir();
	}	
}
