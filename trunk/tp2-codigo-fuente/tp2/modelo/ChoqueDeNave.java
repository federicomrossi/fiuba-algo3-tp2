package tp2.modelo;

// Esta clase define el comportamiento receptor de una nave en un 
// choque frente a los dem�s objetos del espacio.
public class ChoqueDeNave extends ChoqueDeObjetoEspacial {
	
	// Inicializa el comportamiento de la nave recibida.
	public ChoqueDeNave(Nave unaNave) {
		super((ObjetoEspacial) unaNave);
	}
	
	@Override
	// Una nave se destruye cuando choca con una nave militar que no es aliada.
	public void sufrirChoqueDeNaveMilitar(NaveMilitar unaNaveMilitar) {
		Nave objeto = (Nave) this.getObjeto();
		if(!objeto.esAliadoDe(unaNaveMilitar)){
			objeto.destruir();
		}
	}
	
	@Override
	// Una nave recibe el da�o del proyectil con el que choca salvo que sea aliado.
	public void sufrirChoqueDeProyectil(Proyectil unProyectil) {
		Nave objeto = (Nave) this.getObjeto();
		if(!objeto.esAliadoDe(unProyectil)){
			objeto.recibirDanio(unProyectil.getDanio());
		}
	}
	
}