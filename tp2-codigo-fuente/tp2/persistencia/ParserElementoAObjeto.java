package tp2.persistencia;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.Map;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;

public class ParserElementoAObjeto {

	@SuppressWarnings("unchecked")
	public static Object cargarObjeto(Node nodo, Class<?> clase) {
		try {
			if(clase.equals(String.class)){
				return nodo.getTextContent();
			}
			if(clase.equals(Integer.class)){
				return Integer.parseInt(nodo.getTextContent());
			}
			if(clase.equals(Double.class)){
				return Double.parseDouble(nodo.getTextContent());
			}
			if(clase.equals(Float.class)){
				return Float.parseFloat(nodo.getTextContent());
			}
			if(clase.equals(Boolean.class)){
				return Boolean.parseBoolean(nodo.getTextContent());
			}
			int i = 0;
			if(Collection.class.isAssignableFrom(clase)){
				try {
					Collection<Object> resultado = (Collection<Object>) clase.newInstance();
					Map<String, Node> nodosHijos = ReconstructorDesdeXml.construirMapaDeHijos(nodo);
					while(true){
						if(!nodosHijos.containsKey(String.format("elemento%d", i))){
							return resultado;
						}
						resultado.add(ReconstructorDesdeXml.generarObjeto(nodosHijos.get(String.format("elemento%d", i))));
						i++;
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(Map.class.isAssignableFrom(clase)){
				try {
					Map<Object, Object> resultado = (Map<Object, Object>) clase.newInstance();
					Map<String, Node> nodosHijos = ReconstructorDesdeXml.construirMapaDeHijos(nodo);
					while(true){
						if(!nodosHijos.containsKey(String.format("elemento%d", i))){
							return resultado;
						}
						Map<String, Node> subNodosHijos = ReconstructorDesdeXml.construirMapaDeHijos(nodosHijos.get(String.format("elemento%d", i)));
						Node clave = subNodosHijos.get("clave");
						Node valor = subNodosHijos.get("valor");
						resultado.put(ReconstructorDesdeXml.generarObjeto(clave), ReconstructorDesdeXml.generarObjeto(valor));
						i++;
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if(clase.equals(Rectangle.class)){
				Map<String, Node> nodosHijos = ReconstructorDesdeXml.construirMapaDeHijos(nodo);
				double x = (Double) ReconstructorDesdeXml.generarObjeto(nodosHijos.get("x"));
				double y = (Double) ReconstructorDesdeXml.generarObjeto(nodosHijos.get("y"));
				double ancho = (Double) ReconstructorDesdeXml.generarObjeto(nodosHijos.get("ancho"));
				double alto = (Double) ReconstructorDesdeXml.generarObjeto(nodosHijos.get("alto"));
				Rectangle resultado = new Rectangle();
				resultado.setRect(x, y, ancho, alto);
				return resultado;
			}
			if(clase.equals(Point.class)){
				Map<String, Node> nodosHijos = ReconstructorDesdeXml.construirMapaDeHijos(nodo);
				double x = (Double) ReconstructorDesdeXml.generarObjeto(nodosHijos.get("x"));
				double y = (Double) ReconstructorDesdeXml.generarObjeto(nodosHijos.get("y"));
				return new Point(x, y);
			}
			if(clase.equals(ParCadenaPosicion.class)){
				Map<String, Node> nodosHijos = ReconstructorDesdeXml.construirMapaDeHijos(nodo);
				String cadena = (String) ReconstructorDesdeXml.generarObjeto(nodosHijos.get("cadena"));
				Point posicion = (Point) ReconstructorDesdeXml.generarObjeto(nodosHijos.get("posicion"));
				return new ParCadenaPosicion(cadena, posicion);
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}
		// Ac� saltar�a error: falta agregar c�mo parsear cierta clase.
		return null;
	}
		
}
