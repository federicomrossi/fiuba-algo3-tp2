package tp2.modelo.menues;

import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.MouseClickController;

public class MenuPrincipal implements MenuI, Posicionable  {

	private int alto;
	private int ancho;
	
	public MenuPrincipal(){
		this.alto = 500;
		this.ancho = 500;
	}
	
	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}
	
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	@Override
	public KeyPressedObservador getControlKeyPressed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MouseClickController getControlMouseClick() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Dibujable> getObjetosDibujablesPropios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void entrarEnEscena() {
		// TODO Auto-generated method stub
		
	}
	

}
