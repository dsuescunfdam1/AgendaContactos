package ut7.Agenda.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Personal extends Contacto {
	private LocalDate fechaNacimiento;
	private Relacion parentesco;

	public Personal(String nombre, String apellidos, String telefono, String email, String fechaNacimiento, Relacion parentesco) {
		super(nombre, apellidos, telefono, email);
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.parentesco = parentesco;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public Relacion getParentesco() {
		return parentesco;
	}

	public void setParentesco(Relacion parentesco) {
		this.parentesco = parentesco;
	}

	public String getFirmaEmail() {
		
		String firma = "Un abrazo!!";
		return firma;
	}
	
	public boolean esCumpleaños() {
		
		return fechaNacimiento.getDayOfMonth() == LocalDate.now().getDayOfMonth() && fechaNacimiento.getMonthValue() == LocalDate.now().getMonthValue();
		
	}


	public String toString() {
		return super.toString() + "Fecha de Nacimiento: " + this.getFechaNacimiento() + "\n" + "Relación: " + this.getParentesco() + "\n" + "\n";
	}
	
	

	

}
