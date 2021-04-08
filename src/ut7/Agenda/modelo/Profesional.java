package ut7.Agenda.modelo;

public class Profesional extends Contacto {
	private String nombreEmpresa;

	

	public Profesional(String nombreEmpresa, String nombre, String apellidos, String telefono, String email) {
		super(nombre, apellidos, telefono, email);
		this.nombreEmpresa = capitalizar(nombreEmpresa);
	
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	private String capitalizar (String nombreEmpresa){
		 
		if (nombreEmpresa.length() == 0 ) {
			return nombreEmpresa;
		}
		return nombreEmpresa.substring(0, 1).toUpperCase() +
				nombreEmpresa.substring(1).toLowerCase();
	 
	}
	

	
	public String getFirmaEmail() {
		String[] Firmas = new String["Atentamente", "Saludos"];
		
		return null;
	}

}
