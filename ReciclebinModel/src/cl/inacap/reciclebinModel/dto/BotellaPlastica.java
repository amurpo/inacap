package cl.inacap.reciclebinModel.dto;

public class BotellaPlastica extends Producto{
	private int espesor;
	private String capacidad;
	public int getEspesor() {
		return espesor;
	}
	public void setEspesor(int espesor) {
		this.espesor = espesor;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String toString() {
		return "Botella [nombre=" + nombre + ",espesor=" + espesor + ", capacidad=" + capacidad + ", valor=" + valorMercado + "]";
	}
	
}
