package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueDeProyectilTest {
	private Proyectil proyectil;
	private ChoqueDeObjetoEspacial comportamiento;
	private Nave aliado;
	private Nave enemigo;
	private Escenario escenario;
	
	@Before
	public void arrenge(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		proyectil = new Proyectil(new Point(0,0),0.1,0,10);
		proyectil.setEquipo("aliados");
		aliado = new NaveMilitar (new Point(0,0),1,escenario,1,100);
		aliado.setEquipo("aliados");
		enemigo = new NaveMilitar (new Point(0,0),1,escenario,1,100);
		enemigo.setEquipo("enemigos");
		comportamiento = proyectil.getComportamiento();
	}

	@Test
	public void testSufrirChoqueDeNaveMilitar1(){
		//Pedimos que el proyectil no sea destru�do al sufrir el choque del aliado
		comportamiento.sufrirChoqueDeNaveMilitar((NaveMilitar) aliado);
		Assert.assertFalse(proyectil.estaDestruido());
	}

	@Test
	public void testSufrirChoqueDeNaveMilitar2(){
		//Pedimos que el proyectil sea destru�do al sufrir el choque del enemigo
		comportamiento.sufrirChoqueDeNaveMilitar((NaveMilitar) enemigo);
		Assert.assertTrue(proyectil.estaDestruido());
	}
}
