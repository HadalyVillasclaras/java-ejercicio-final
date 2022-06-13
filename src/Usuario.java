
public class Usuario {
 
	private String nombre;
	private int edad;
	String DNI;
	 
	public Usuario() {
		this.nombre="";
		this.edad=0;
		this.DNI="";
	}
	
	//Getters & setters para nombre, edad y DNI 
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	} 


	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad=edad;
	}
	
	 
	
	//Comprobar si DNI correcto
	public boolean setDNI (String DNI) {
		if(DNI.matches("^[0-9]{8}[a-zA-Z]$")
				|| DNI.matches("^[0-9]{8}[-][a-zA-Z]$")) {
			this.DNI=DNI;
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	public String getDNI() {
		return DNI;
	}
		 
	 
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "/n" +
				"Edad: " + this.edad + "./n" +
				"DNI: " + this.DNI + ".";
	}
	
	
		
	
	
	
	
	
	
	
}
