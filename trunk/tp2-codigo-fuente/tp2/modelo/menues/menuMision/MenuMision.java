package tp2.modelo.menues.menuMision;

import tp2.control.menues.menuMision.ControlKeyPressMenuMision;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuMision.VistaMenuMision;
import tp2.vista.menues.menuPrincipal.VistaMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuMision extends Menu {

	public MenuMision(VentanaPrincipal ventanaPrincipal, MenuI menuPadre) {
		super(ventanaPrincipal, menuPadre);
		// Creamos la vista del menu de misi�n.
		this.setVistaMenu(new VistaMenuMision());
		this.getVistaMenu().setPosicionable(this);		
	}

	@Override
	public void resetear() {
		
	}

	@Override
	public void activarControl() {
		this.setControlKeyPress(new ControlKeyPressMenuMision(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
}
