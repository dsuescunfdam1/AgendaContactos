package ut7.Agenda.test;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import ut7.Agenda.io.AgendaIO;
import ut7.Agenda.modelo.AgendaContactos;
import ut7.Agenda.modelo.Contacto;
import ut7.Agenda.modelo.Personal;
import ut7.Agenda.modelo.Relacion;

public class TestAgenda {

	public static void main(String[] args) {
		AgendaContactos agenda = new AgendaContactos();
		AgendaIO.importar(agenda, "agenda.csv");
		System.out.println(agenda);
		separador();

		buscarContactos(agenda, "acos");
		separador();

		buscarContactos(agenda, "don");
		separador();

		felicitar(agenda);
		separador();

		personalesOrdenadosPorFecha(agenda, 'm');
		separador();
		personalesOrdenadosPorFecha(agenda, 'e');
		separador();
		personalesOrdenadosPorFecha(agenda, 'w');
		separador();

		personalesPorRelacion(agenda);
		separador();

	}

	private static void buscarContactos(AgendaContactos agenda, String texto) {
		List<Contacto> resultado = agenda.buscarContactos(texto);
		System.out.println("Contactos que contienen \"" + texto + "\"");
		if (resultado.isEmpty()) {
			System.out.println("No hay contactos coincidentes");
		} else {
			resultado.forEach(contacto -> System.out.println(contacto));
		}

	}

	private static void felicitar(AgendaContactos agenda) {
		System.out.println("Fecha actual: " + LocalDate.now());
		List<Personal> resultado = agenda.felicitar();
		if (resultado.isEmpty()) {
			System.out.println("Hoy no cumple nadie");
		} else {
			System.out.println("Hoy hay que felicitar a ");
			resultado.forEach(contacto -> System.out.println(contacto));
		}

	}

	private static void personalesOrdenadosPorFecha(AgendaContactos agenda,
			char letra) {
		System.out.println("Personales en letra " + letra
				+ " ordenados de < a > fecha de nacimiento");
		List<Personal> personales = agenda.personalesEnLetra(letra);
		if (personales == null) {
			System.out.println(letra + " no está en la agenda");
		} else {
			agenda.personalesOrdenadosPorFechaNacimiento(letra)
					.forEach(contacto -> System.out.println(contacto));
		}

	}

	private static void personalesPorRelacion(AgendaContactos agenda) {
		Map<Relacion, String> map = agenda.personalesPorRelacion();
		map.forEach((key, value) -> System.out.println(key + "\n\t" + value));
	}

	private static void separador() {
		System.out.println(
				"------------------------------------------------------------");

	}

}
