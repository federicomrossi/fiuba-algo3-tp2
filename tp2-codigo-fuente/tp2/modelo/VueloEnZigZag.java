package tp2.modelo;

import tp2.auxiliares.Point;

// Define un vuelo en zig zag de 45�, de una amplitud dada.
public class VueloEnZigZag extends VueloCompuesto {

	// La direcci�n media que sigue el vuelo.
	private Point direccion;
	// Se usa para calcular qu� parte del zig zag es el siguiente.
	private boolean proximoSegmentoEsPar;
	// La longitud de cada segmento del zig zag (definida por la amplitud).
	private double trayectoriaPorSegmento;
	// Calcula cu�ndo recorrido del zig zag est� definido por delante de la 
	// posici�n del vuelo.
	private double trayectoriaRestante;
	
	
	// Constructor
	// Inicializa un vuelo en zig zag del objeto volador recibido, con la 
	// amplitud y direcci�n dadas.
	public VueloEnZigZag(ObjetoVolador unObjetoVolador, double amplitud, Point direccion) {
		super(unObjetoVolador);		
	}
	
	@Override
	// Avanza el vuelo en el tiempo recibido, y devuelve el desplazamiento del 
	// mismo respecto al estado anterior. Si el vuelo no comenz�, se levanta 
	// una excepci�n.
	public Point avanzarDurante(double unTiempo) {
		return null;
	}
	
	@Override
	// Inicia el vuelo compuesto.
	public void iniciar() {
		
	}
	
	@Override
	// No se puede agregar un vuelo (desde afuera) a un objeto de esta clase.
	public void agregarVuelo(Vuelo vuelo, double longitudTrayectoria) {
		
	}
	
	// Dibuja un segmento del zig-zag, del largo recibido, dependiendo del 
	// estado del atributo proximoSegmentoEsPar, que diferencia en cu�l de las 
	// dos direcciones del zig-zag va el segmento.
	public void dibujarSegmentoDeLargo(double unLargo) {
		
	}
	
	public double getAmplitud() {
		return 0;
	}
	
	// Cambia la amplitud del zig-zag. La misma debe ser mayor a cero.
	public void setAmplitud(double nuevaAmplitud) {
		
	}
	
	public Point getDireccion() {
		return this.direccion;
	}
	
	// Permite cambiar la direcci�n de vuelo del zig-zag. La misma debe ser 
	// distinta de (0,0).
	public void setDireccion() {
		
	}
	
}
