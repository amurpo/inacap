package cl.inacap.detective.classes;

public class Detective {
	
	private String nombre;
	private String rut;
	private int telefono;
	private String direccion;
	private int nivel;
	
	//Constructor por defecto
	public Detective(String nombre, String rut, int telefono, String direccion, int nivel) {
	this.nombre = nombre;
	this.rut = rut;
	this.telefono = telefono;
	this.direccion = direccion;
	this.nivel = nivel;
		
	}
	//Constructor 2
	public Detective() {
		this.nombre = "Juan Perez";
		this.rut = "00000000-0";
		this.telefono = 000000000;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public String toString() {
		
		return nombre + " " + rut + " " + direccion + " " + telefono + " ";
	}
		


}
