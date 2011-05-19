package tp2.modelo;

import tp2.auxiliares.Point;

// Define un arma, la cual puede disparar proyectiles en el escenario en donde est�.
public class Arma extends Movil {

	private Nave naveDuenia;
	private Proyectil modeloDeProyectil;
	private Integer frecuenciaDeDisparo;
	private Double tiempoRestante;
	private Boolean disparando;
	private Integer velocidadDeDisparo;
	private Point direccionDeDisparo;
	private ArmaIdentificacion identificacion;
	
	@Override
	// Ordena al arma actuar en el escenario durante el tiempo espec�ficado. Si no 
	// tiene, se levanta una excepci�n.
	public void actuarDurante(double tiempo) {
		
	}
	
	
	
}
