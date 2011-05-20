package tp2.modelo;

// Es un bono que da la energ�a m�xima de la nave due�a a aquella que lo use.
public class BonoDeArmas extends Bono {

	// Constructor
	// Inicializa el bono con el tama�o recibido.
	public BonoDeArmas(double tamanio) {
		super(tamanio);
	}
	
	@Override
	// La nave recibida toma las armas de la enemiga que tir� el bono. Si el bono 
	// ya se us� levanta una excepci�n.
	public void entregarBonoA(Nave unaNave) {
		
	}
}
