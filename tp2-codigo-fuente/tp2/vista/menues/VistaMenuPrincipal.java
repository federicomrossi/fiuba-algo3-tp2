package tp2.vista.menues;

import java.util.ArrayList;

import tp2.control.menu.ControlKeyPressMenuPrincipal;
import tp2.modelo.menues.*;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenuPrincipal extends Imagen {

	// Guardamos una referencia a la ventana en la que estamos.
	private VentanaPrincipal ventanaPrincipal;
	// En esta guardamos todos los objetos dibujables que contiene el men�.
	private ArrayList<Dibujable> objetosDibujablesDelMenu;
	// En esta guardamos solamente los objetos que son items del men�.
	private ArrayList<VistaMenuItem> itemsDelMenu;
	
	public VistaMenuPrincipal(VentanaPrincipal ventanaPrincipal, Imagen imagen) {
		super(imagen);
		objetosDibujablesDelMenu = new ArrayList<Dibujable>();
		this.itemsDelMenu = new ArrayList<VistaMenuItem>();
		this.ventanaPrincipal = ventanaPrincipal;
		this.inicializar();
	}
	
	private void inicializar() {
		
		// Item para opci�n "Nueva Partida"
		VistaMenuItem VistaItemNuevaPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemNuevaPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemNuevaPartidaOver());
		VistaItemNuevaPartida.setPosicionable(new MenuItemNuevaPartida());
		objetosDibujablesDelMenu.add(VistaItemNuevaPartida);
		itemsDelMenu.add(VistaItemNuevaPartida);
		VistaItemNuevaPartida.itemOver();
		
		// Item para opci�n "Cargar Partida"
		VistaMenuItem VistaItemCargarPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCargarPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCargarPartidaOver());
		VistaItemCargarPartida.setPosicionable(new MenuItemCargarPartida());
		objetosDibujablesDelMenu.add(VistaItemCargarPartida);
		itemsDelMenu.add(VistaItemCargarPartida);
		
		// Item para opci�n "Cr�ditos"
		VistaMenuItem VistaItemCreditos = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCreditosOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCreditosOver());
		VistaItemCreditos.setPosicionable(new MenuItemCreditos());
		objetosDibujablesDelMenu.add(VistaItemCreditos);
		itemsDelMenu.add(VistaItemCreditos);
		
		// Item para opci�n "Salir"
		VistaMenuItem VistaItemSalir = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemSalirOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemSalirOver());
		VistaItemSalir.setPosicionable(new MenuItemSalir());
		objetosDibujablesDelMenu.add(VistaItemSalir);
		itemsDelMenu.add(VistaItemSalir);
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del men� principal.
		this.ventanaPrincipal.setControlKeyPressActivo(new ControlKeyPressMenuPrincipal(this.itemsDelMenu));
		this.ventanaPrincipal.activarKeyPressObservador();
	}
	
	public ArrayList<Dibujable> getObjetosDibujablesPropios() {
		return this.objetosDibujablesDelMenu;
	}
	
	public void volverAMi() {
		
	}
}