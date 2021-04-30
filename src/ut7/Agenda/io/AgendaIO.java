package ut7.Agenda.io;

import ut7.Agenda.modelo.AgendaContactos;
import ut7.Agenda.modelo.Contacto;
import ut7.Agenda.modelo.Personal;
import ut7.Agenda.modelo.Profesional;
import ut7.Agenda.modelo.Relacion;

/**
 * Utilidades para cargar la agenda
 */
public class AgendaIO {

	public static void importar(AgendaContactos agenda) {
		for(String lineas: obtenerLineasDatos()){
			Contacto nuevo = parsearLinea(lineas);
			agenda.añadirContacto(nuevo);
		}
		
		

	}

	private static Contacto parsearLinea(String linea) {
		String[] datos = linea.split(",");
		for(String quitar: datos) {
			quitar.trim();
		}
		if(Integer.parseInt(datos[0]) == 1) {
			Contacto nuevo = new Profesional(datos[1], datos[2], datos[3], datos[4], datos[5]);
			return nuevo;
		}
		else if(Integer.parseInt(datos[0]) == 2) {
			Relacion parentesco = null;
			if(datos[6].equalsIgnoreCase("amigos")) {
				parentesco = Relacion.AMIGOS;
			}
			else if(datos[6].equalsIgnoreCase("hija")) {
				parentesco = Relacion.HIJA;
			}
			else if(datos[6].equalsIgnoreCase("hijo")) {
				parentesco = Relacion.HIJO;
			}
			else if(datos[6].equalsIgnoreCase("madre")) {
				parentesco = Relacion.MADRE;
			}
			else if(datos[6].equalsIgnoreCase("padre")) {
				parentesco = Relacion.PADRE;
			}
			else if(datos[6].equalsIgnoreCase("pareja")) {
				parentesco = Relacion.PAREJA;
			}
			Contacto nuevo = new Personal(datos[1], datos[2], datos[3], datos[4], datos[5], parentesco);
			return nuevo;
		}
		
		return null;
	}

	/**
	 * 
	 * @return un array de String con todas las líneas de información de todos
	 *         los contactos. 1 significa contacto profesional, 2 significa
	 *         contacto personal
	 */
}
