package cl.inacap.automovilModel.dto;

public class Automovil {
	
	private String patente;
	private int kilometraje;
	private String nombreContacto;
	private String tipoAtencion;
	private String tipoMotor;
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getTipoAtencion() {
		return tipoAtencion;
	}
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}
	public String getTipoMotor() {
		return tipoMotor;
	}
	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}
	@Override
	public String toString() {
		return  id +"  ["+"P="+ patente + " , K=" + kilometraje + ", NC=" + nombreContacto
				+ ", TA=" + tipoAtencion + ", TM=" + tipoMotor + "]";
	}
	
}