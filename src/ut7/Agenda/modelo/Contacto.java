package ut7.Agenda.modelo;


public abstract class Contacto {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Contacto(String nombre, String apellidos, String telefono,
			String email) {
		this.nombre = nombre.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.telefono = telefono;
		this.email = email.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public char getPrimeraLetra() {
		
		return apellidos.charAt(0);
		
	}
	
	public boolean equals(Contacto otro) {
		if (this.getClass() == otro.getClass() && apellidos.equalsIgnoreCase(otro.getApellidos()) && nombre.equalsIgnoreCase(otro.getNombre()) && email.equalsIgnoreCase(otro.getEmail()))
		{
		return true;
		}
		else {
			return false;
		}
		}
	
	public int compare(Contacto c1, Contacto c2)
    {
		if(!c1.getApellidos().equalsIgnoreCase(c2.getApellidos())) {
        return c1.getApellidos().compareToIgnoreCase(c2.getApellidos());
		}
		else {
			return c1.getNombre().compareToIgnoreCase(c2.getNombre());
		}
                
        

    }
	
	public abstract String getFirmaEmail();

	@Override
	public int hashCode() {
		return email.hashCode();

	}

	@Override
	public String toString() {
		return this.getApellidos().toUpperCase() + ", " + nombre.toUpperCase() + "(" + this.getClass() + ")" + "\n" + "Tfno: " + this.getTelefono() + " |  email: " + this.getEmail() + "\n";
	}
	
	

}
