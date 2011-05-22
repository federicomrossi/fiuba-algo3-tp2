package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.*;

import tp2.modelo.*;
import tp2.modelo.excepciones.*;
import tp2.auxiliares.*;

public class VueloIdaYVueltaTest {

	@Test
	public void testAvanzarDurante(){
		Escenario escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		Point posicionActual = new Point (0,0);
		int velocidad = 1;
		ObjetoVolador objetoVolador = new ObjetoVolador (posicionActual,1,escenario,velocidad);
		VueloDeIdaYVuelta vuelo = new VueloDeIdaYVuelta (objetoVolador,new Point(4,3));
		
		//Intentamos avanzar el vuelo sin iniciarlo
		try {
			vuelo.avanzarDurante(1);
			Assert.fail("El vuelo avanz� sin estar iniciado");
		}	
		catch(VueloNoIniciado e){
			Assert.assertTrue(true);
		}
		catch(Exception e){
				 Assert.fail("Falla con una excepccion invalida");
		}
		
		//Verificamos que el vuelo siga la ruta esperada		
		ArrayList posiciones = new ArrayList();
		posicionActual = posicionActual + (vuelo.avanzarDurante(3));
		posiciones.add(posicionActual);
		posicionActual = posicionActual + (vuelo.avanzarDurante(2));
		posiciones.add(posicionActual);
		posicionActual = posicionActual + (vuelo.avanzarDurante(10));
		posiciones.add(posicionActual);
		Assert.assertTrue(((Point)posiciones.get(1)).distance(new Point(4,3))*(3/5) <= 1E-10);
		Assert.assertTrue(((Point)posiciones.get(2)).distance(new Point(4,3)) <= 1E-10);
		Assert.assertTrue(((Point)posiciones.get(3)).distance(new Point(-4,-3)) <= 1E-10);
	}
}