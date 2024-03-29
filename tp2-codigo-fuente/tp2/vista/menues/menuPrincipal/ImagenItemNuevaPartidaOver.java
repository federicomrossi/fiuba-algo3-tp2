package tp2.vista.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemNuevaPartidaOver extends Imagen {
	
	public static ImagenItemNuevaPartidaOver imagenPrincipal; 

	private ImagenItemNuevaPartidaOver() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-principal-item-over-nueva-partida.png");
	}

	private ImagenItemNuevaPartidaOver(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemNuevaPartidaOver();
	}
	
	public static ImagenItemNuevaPartidaOver nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemNuevaPartidaOver(imagenPrincipal);
	}
}