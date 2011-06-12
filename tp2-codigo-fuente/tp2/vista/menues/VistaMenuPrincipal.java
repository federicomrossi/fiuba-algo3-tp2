package tp2.vista.menues;

import java.util.ArrayList;
import tp2.control.menu.ControlKeyPressMenuPrincipal;
import tp2.modelo.menues.*;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenuPrincipal extends Imagen {

	private VentanaPrincipal ventanaPrincipal;
	private ArrayList<Dibujable> objetosDibujablesDelMenu;
	
	public VistaMenuPrincipal(VentanaPrincipal ventanaPrincipal, Imagen imagen) {
		super(imagen);
		objetosDibujablesDelMenu = new ArrayList<Dibujable>();
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaPrincipal.setControlKeyPressActivo(new ControlKeyPressMenuPrincipal(this));
		this.inicializar();
	}
	
	private void inicializar() {
		
		// Item para opci�n "Nueva Partida"
		VistaMenuItem VistaItemNuevaPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemNuevaPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemNuevaPartidaOver());
		VistaItemNuevaPartida.setPosicionable(new MenuNuevaPartida());
		objetosDibujablesDelMenu.add(VistaItemNuevaPartida);
		
		// Item para opci�n "Cargar Partida"
		VistaMenuItem VistaItemCargarPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCargarPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCargarPartidaOver());
		VistaItemCargarPartida.setPosicionable(new MenuCargarPartida());
		objetosDibujablesDelMenu.add(VistaItemCargarPartida);
		
		// Item para opci�n "Cr�ditos"
		VistaMenuItem VistaItemCreditos = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCreditosOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCreditosOver());
		VistaItemCreditos.setPosicionable(new MenuCreditos());
		objetosDibujablesDelMenu.add(VistaItemCreditos);
		
		// Item para opci�n "Salir"
		VistaMenuItem VistaItemSalir = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemSalirOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemSalirOver());
		VistaItemSalir.setPosicionable(new MenuSalir());
		objetosDibujablesDelMenu.add(VistaItemSalir);
	}
	
	public ArrayList<Dibujable> getObjetosDibujablesPropios() {
		return this.objetosDibujablesDelMenu;
	}
}