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
			Relacion parentesco = Relacion.valueOf(datos[6]);
			Contacto nuevo = new Personal(datos[1], datos[2], datos[3], datos[4], datos[5], parentesco);
			return nuevo;
		}
		
		return null;
	}
}
