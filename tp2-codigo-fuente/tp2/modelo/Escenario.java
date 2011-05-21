package tp2.modelo;

import java.awt.Rectangle;
import java.util.*;

// El escenario es el lugar en donde viven todos los objetos espaciales que 
// pueden actuar e interactuar entre s�. Un objeto de esta clase puede simular 
// la vida de dichos objetos a lo largo del tiempo, y ellos a la vez pueden 
// comunicarse con �l.
public class Escenario {

	// Es el �rea rectangular asignada de combate.
	private Rectangle areaDeCombate;
	// los objetos tienen un id para interactuar entre s� en un �nico sentido 
	// (y que no existan colisiones dobles).
	private int proximoId;
	// Es un diccionario, que tiene como clave a los objetos y como valor el id 
	// del mismo.
	private Map<ObjetoEspacial,String> objetos;
	// La puntuaci�n lograda en dicho escenario.
	private int puntuacion;
	

	// Constructor
	// Crea un nuevo escenario cuya �rea de combate est� definida por el
	// rect�ngulo recibido. 
	public Escenario(Rectangle areaDeCombate) {
		
	}
	
	// Agrega un objeto al escenario, el cual ya tiene asignado dicho escenario.
	// El mismo debe estar preparado para actuar cuando sea necesario, de lo 
	// contrario se corre el riesgo de que se levante una excepci�n en el 
	// futuro. Si el objeto no tiene asignado este escenario, entonces se 
	// levanta una excepci�n. Si el objeto ya estaba agregado al escenario, no 
	// pasa nada.
	public void agregarObjeto(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	// Borra definitivamente al objeto del escenario. Si el objeto no tiene 
	// asignado este escenario, entonces se levanta una excepci�n. 
	public void borrarObjeto(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	// Devuelve si el objeto recibido se encuentra en el escenario.
	public boolean contieneObjeto(ObjetoEspacial unObjetoEspacial) {
		return false;
	}
	
	// Devuelve si el objeto se encuentra dentro del �rea de combate.
	public boolean tieneEnCombateA(ObjetoEspacial unObjetoEspacial) {
		return false;
	}
	
	// Hace que avance el tiempo, y le ordena a todos los objetos 
	// pertenecientes al escenarios que act�en durante dicho tiempo. En el caso 
	// que alg�n objeto no tenga pueda actuar y tire una excepci�n, se levantar�
	// la misma.
	public void avanzarTiempoEn(double unTiempo) {
		
	}
	
	// Agrega o quita (si la diferencia es negativa) la cantidad de puntos 
	// recibida a la puntuaci�n actual del escenario. La puntuaci�n se mantiene 
	// m�nimamente en cero.
	public void modificarPuntuacionEn(int unaDiferencia) {
		
	}
	
	// Cambia el �rea de combate al rect�ngulo recibido.
	public void setAreaDeCombate(Rectangle nuevaArea) {
		
	}
	
	// Devuelve un diccionario, que tiene como clave a los objetos y como valor  
	// el id del mismo.
	public Map<ObjetoEspacial,String> getObjetos() {
		return null;
	}
	
	// Recibe la referencia a un objeto del escenario. Devuelve una colecci�n 
	// de aquellos otros objetos que est�n colisionando con el mismo y que 
	// fueron agregados al escenario despu�s de este (es decir, detecta 
	// colisiones en un solo sentido).
	public List<ObjetoEspacial> getObjetosEnColisionCon(ObjetoEspacial unObjetoEspacial) {
		return null;
	}
	
	public int getPuntuacion() {
		return 0;
	}
	
}
