package cl.inacap.reciclebinModel.dto;

public class Lata extends Producto{
	private String tipo;
	private int resistencia;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
	public String toString() {
		return "Lata [nombre=" + nombre + ",tipo=" + tipo + ", alto=" + alto + ", ancho=" + ancho
				+ ", valor=" + valorMercado + "]";
	}
	
}
