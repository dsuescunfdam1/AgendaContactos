package ut7.Agenda.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {
		agenda = new TreeMap<>();
		
	}

	public void añadirContacto() {
		

	}

	public HashSet<Contacto> contactosEnLetraPersonal(char letra) {
		
		HashSet<Contacto> total = new HashSet<>();
		Iterator<Contacto> it = agenda.get(letra).iterator();
		while(it.hasNext()) {
			if(it.next() instanceof Personal) {
				total.add(it.next());
			}
			
		}
		return total;
	}

	public int totalContactos() {
		int total = 0;
		for(Character letra: agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(letra).iterator();
			while(it.hasNext()) {
				total ++;
			}
		}
		
		return total;
	}

	public String toString() {

		return null;
	}

	public List<Contacto> buscarContactos(String texto) {
		ArrayList<Contacto> buscar = new ArrayList<>();
		for(Character letra: agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(letra).iterator();
			while(it.hasNext()) {
				if(it.next().getNombre().contains(texto) || it.next().getApellidos().contains(texto)) {
				buscar.add(it.next());
			}
		}
		}
		
		return buscar;

	}

	public List<Personal> personalesEnLetra(char letra) {
		ArrayList<Personal> personales = new ArrayList<>();
		if(agenda.containsKey(letra)) {
		Iterator<Contacto> it = agenda.get(letra).iterator();
		while(it.hasNext()) {
			if(it.next() instanceof Personal) {
				personales.add((Personal) it.next());
		}
		
		}
		 return personales;
		}
		else {
			return null;
		}
	}

	public List<Personal> felicitar() {
		ArrayList<Personal> felizCumpleaños = new ArrayList<>();
		for(Character letra: agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(letra).iterator();
			while(it.hasNext()) {
				if(((Personal) it.next()).esCumpleaños()) {
				felizCumpleaños.add((Personal) it.next());
			}
		}
		}
		return felizCumpleaños;
	}

	public void personalesPorRelacion() {
		TreeMap<Relacion, String> ordenacion = new TreeMap<>();
		for(Character letra: agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(letra).iterator();
			while(it.hasNext()) {
				if(it.next() instanceof Personal) {
					String nombre = it.next().getNombre() + " " + it.next().getNombre();
				ordenacion.put(((Personal) it.next()).getParentesco(), nombre);
				}
		}
		}
	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
		ArrayList<Personal> fecha = new ArrayList<>();
		if(agenda.containsKey(letra)) {
		Iterator<Contacto> it = agenda.get(letra).iterator();
		while(it.hasNext()) {
			if(it.next() instanceof Personal) {
				fecha.add((Personal) it.next());
		}
			
		}
		Collections.sort(fecha, new Comparator<Personal>() {
     		public int compare(Personal p1, Personal p2)
            {
     			
                return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
                        
                

            }
     	
     	});
		return fecha;

	}
		else {
			return null;
		}
		
		}

}
