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
import java.util.TreeSet;


public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;

	public AgendaContactos() {
		agenda = new TreeMap<>();
		
	}

	public void añadirContacto(Contacto nuevo) {
		
		if(agenda.containsKey(nuevo.getPrimeraLetra())) {
			boolean repe = false;
			Iterator<Contacto> it = agenda.get(nuevo.getPrimeraLetra()).iterator();
			while(it.hasNext()) {
				if(it.next().equals(nuevo)) {
					repe = true;
				}
				
			}
			if(!repe) {
			agenda.get(nuevo.getPrimeraLetra()).add(nuevo);
			}
			else {
				System.out.println("Error, no se ha podido incluir el contacto porque ya se encontraba en la lista");
			}
		}
		else {
			Set<Contacto> lista = new TreeSet<>();
			lista.add(nuevo);
			agenda.put(nuevo.getPrimeraLetra(), lista);
		}
		

	}

	public HashSet<Contacto> contactosEnLetraPersonal(char letra) {
		
		HashSet<Contacto> total = new HashSet<>();
		Iterator<Contacto> it = agenda.get(letra).iterator();
		while(it.hasNext()) {
			Contacto nuevo = it.next();
			if(nuevo instanceof Personal) {
				total.add(nuevo);
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
		String listado = "AGENDA DE CONTACTOS" + "\n";
		for(Character letra: agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(letra).iterator();
			listado += letra + "  " + "(" + agenda.get(letra).size() + "contacto/s);" + "\n" + "-------------------" + "\n";
			
			while(it.hasNext()) {
				listado += it.next().toString();
			}
		}
		
		return listado;
	}

	public List<Contacto> buscarContactos(String texto) {
		ArrayList<Contacto> buscar = new ArrayList<>();
		for(Character letra: agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(letra).iterator();
			while(it.hasNext()) {
				Contacto mirar = it.next();
				if(mirar.getNombre().contains(texto) || mirar.getApellidos().contains(texto)) {
				buscar.add(mirar);
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
			Contacto mirar = it.next();
			if(mirar instanceof Personal) {
				personales.add((Personal) mirar);
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
				Contacto feliz = it.next();
				if(((Personal) feliz).esCumpleaños()) {
				felizCumpleaños.add((Personal) feliz);
			}
		}
		}
		return felizCumpleaños;
	}

	public TreeMap<Relacion, String> personalesPorRelacion() {
		TreeMap<Relacion, String> ordenacion = new TreeMap<>();
		for(Character letra: agenda.keySet()) {
			Iterator<Contacto> it = agenda.get(letra).iterator();
			while(it.hasNext()) {
				Contacto comprobar = it.next();
				if(it.next() instanceof Personal) {
					String nombre = comprobar.getNombre() + " " + comprobar.getApellidos();
				ordenacion.put(((Personal) comprobar).getParentesco(), nombre);
				}
		}
		}
		return ordenacion;
	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
		ArrayList<Personal> fecha = new ArrayList<>();
		if(agenda.containsKey(letra)) {
		Iterator<Contacto> it = agenda.get(letra).iterator();
		while(it.hasNext()) {
			
			Contacto orden = it.next();
			if(orden instanceof Personal) {
				fecha.add((Personal) orden);
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
