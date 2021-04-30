package ut7.Agenda.io;

import ut7.Agenda.modelo.AgendaContactos;
import ut7.Agenda.modelo.Contacto;
import ut7.Agenda.modelo.Personal;
import ut7.Agenda.modelo.Profesional;
import ut7.Agenda.modelo.Relacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 * Utilidades para cargar la agenda
 */
public class AgendaIO {

	public static int importar(AgendaContactos agenda, String nombre) {
		BufferedReader entrada = null;
		int errores = 0;
		try {
			File f = new File(nombre);
			entrada = new BufferedReader(new FileReader(f));
			String linea = entrada.readLine();
		while (linea != null) {
			Contacto nuevo = parsearLinea(linea);
			agenda.añadirContacto(nuevo);
		}
		}
		catch (FileNotFoundException e) {
			
			System.out.println("Error de IO " + e.getMessage());
			errores++;

		}
		catch (IOException e) {
			errores++;
			System.out.println("Error de IO " + e.getMessage());
		}

		finally {
			if (entrada != null) {
				try {
					entrada.close();
				}
				catch (IOException e) {
					errores++;
					System.out.println("Error de IO al cerrar el fichero");
				}
			}
		}
		return errores;

		
		

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
			Relacion parentesco;
			try {
				
				parentesco = Relacion.valueOf(datos[6]);
				Contacto nuevo = new Personal(datos[1], datos[2], datos[3], datos[4], datos[5], parentesco);
				return nuevo;
				
			} catch (EnumConstantNotPresentException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	public static void exportarPersonales(AgendaContactos agenda, String nombre) {
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
	                nombre));
			TreeMap<Relacion, String> ordenacion = agenda.personalesPorRelacion();
			writer.write("PADRE");
	        writer.newLine();
	        writer.write(ordenacion.get(Relacion.valueOf("PADRE")));
	        writer.newLine();
	        writer.write("AMIGOS");
	        writer.newLine();
	        writer.write(ordenacion.get(Relacion.valueOf("AMIGOS")));
	        writer.newLine();
	        writer.write("PAREJA");
	        writer.newLine();
	        writer.write(ordenacion.get(Relacion.valueOf("PAREJA")));
	        writer.newLine();
	        writer.write("HIJA");
	        writer.newLine();
	        writer.write(ordenacion.get(Relacion.valueOf("HIJA")));
	        writer.close();
			
	     
		}
		
		catch (FileNotFoundException e) {
			
			System.out.println("Error de IO " + e.getMessage());
		

		}
		catch (IOException e) {
			
			System.out.println("Error de IO " + e.getMessage());
		}
		

		
			
		
		
	}
}
