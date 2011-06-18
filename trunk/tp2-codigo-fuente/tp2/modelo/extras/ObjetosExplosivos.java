package tp2.modelo.extras;

import java.util.HashSet;
import java.util.Set;

import tp2.modelo.Visible;
import tp2.modelo.especificaciones.ValoresDeNaves;

public class ObjetosExplosivos {
	
	private static Set<String> idsExplosivos;
	
	public static Boolean esExplosivo(Visible objeto){
		if(idsExplosivos == null){
			generarIdsExplosivos();
		}
		return idsExplosivos.contains(objeto.getIdentificacion());
	}
	
	private static void generarIdsExplosivos(){
		idsExplosivos = new HashSet<String>();
		idsExplosivos.add(ValoresDeNaves.exploradorIdentificacion);
	}

}
