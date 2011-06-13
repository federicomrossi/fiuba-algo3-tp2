package tp2.vista.menues.menuPrincipal;

import java.util.ArrayList;

import tp2.modelo.menues.menuPrincipal.*;
import tp2.vista.menues.VistaMenuI;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenuPrincipal extends Imagen implements VistaMenuI {

	// En esta guardamos todos los objetos dibujables que contiene el men�.
	private ArrayList<Dibujable> objetosDibujablesDelMenu;
	// En esta guardamos solamente los objetos que son items del men�.
	private ArrayList<VistaMenuItem> itemsDelMenu;
	
	public VistaMenuPrincipal() {
		
		super((Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenFondoMenuPrincipal());
		
		objetosDibujablesDelMenu = new ArrayList<Dibujable>();
		this.itemsDelMenu = new ArrayList<VistaMenuItem>();
		this.inicializar();
	}
	
	private void inicializar() {
		
		// Item para opci�n "Nueva Partida"
		VistaMenuItem VistaItemNuevaPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemNuevaPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemNuevaPartidaOver());
		VistaItemNuevaPartida.setPosicionable(new MenuPrincipalItemNuevaPartida());
		objetosDibujablesDelMenu.add(VistaItemNuevaPartida);
		itemsDelMenu.add(VistaItemNuevaPartida);
		VistaItemNuevaPartida.itemOver();
		
		// Item para opci�n "Cargar Partida"
		VistaMenuItem VistaItemCargarPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCargarPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCargarPartidaOver());
		VistaItemCargarPartida.setPosicionable(new MenuPrincipalItemCargarPartida());
		objetosDibujablesDelMenu.add(VistaItemCargarPartida);
		itemsDelMenu.add(VistaItemCargarPartida);
		
		// Item para opci�n "Cr�ditos"
		VistaMenuItem VistaItemCreditos = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCreditosOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCreditosOver());
		VistaItemCreditos.setPosicionable(new MenuPrincipalItemCreditos());
		objetosDibujablesDelMenu.add(VistaItemCreditos);
		itemsDelMenu.add(VistaItemCreditos);
		
		// Item para opci�n "Salir"
		VistaMenuItem VistaItemSalir = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemSalirOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemSalirOver());
		VistaItemSalir.setPosicionable(new MenuPrincipalItemSalir());
		objetosDibujablesDelMenu.add(VistaItemSalir);
		itemsDelMenu.add(VistaItemSalir);		
	}
	
	public ArrayList<VistaMenuItem> getItemsDelMenu() {
		return itemsDelMenu;
	}

	public ArrayList<Dibujable> getObjetosDibujables() {
		return this.objetosDibujablesDelMenu;
	}
}