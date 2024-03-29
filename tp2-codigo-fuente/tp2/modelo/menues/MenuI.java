package tp2.modelo.menues;

import java.util.Map;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;
import tp2.vista.menues.VistaMenuI;

public interface MenuI {

	public VistaMenuI getVistaMenu();
	public KeyPressedObservador getControlKeyPress();
	public MouseClickObservador getControlMouseClick();
	
	public MenuI getMenuPadre();
	public Map<String, MenuI> getListaMenuesHijos();
	
	public void mostrar();
	public void ocultar();
	public void resetear();
	public void activarControl();
	public void desactivarControl();
	
	// Define acciones propias de cada menu que deben realizarse al mostrar el mismo.
	public void realizarAlMostrar();
	// Define acciones propias de cada menu que deben realizarse al ocultar el mismo.
	public void realizarAlOcultar();
}
