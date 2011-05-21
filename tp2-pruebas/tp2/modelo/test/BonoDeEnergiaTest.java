package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class BonoDeEnergiaTest {	
	
	private Bono bono;
	private NaveEnemiga nave;
	private NaveMilitarControlada naveReceptora;
	private Escenario escenario;	

	@Before 
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		nave = new NaveEnemiga(new Point(243,71),1,escenario,1,50);
		naveReceptora = new NaveMilitarControlada(new Point(2,271),1,escenario,1,200);
		naveReceptora.recibirDanio(100);
		bono = new BonoDeEnergia(1);
		nave.setBono(bono);
	}
	
	@Test
	public void testEntregarBonoA(){
		//Le damos el bono a la nave receptora, y vemos si efectivamente recibi� la energ�a
		bono.entregarBonoA(naveReceptora);
		Assert.assertTrue(naveReceptora.getEnergia() == 150);
	}

}
