package cl.inacap.reciclebinModel.dto;

import java.util.ArrayList;
import java.util.List;

public class Reciclaje {
	private String fecha;
	private int valorPagado;
	public String getFecha() {
		return fecha;
	}
	
	private List<Producto>  productos = new ArrayList<Producto>();
	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getValorPagado() {
		return productos.stream().mapToInt(p->p.getValorMercado()).sum();
	}
	
	public String toString() {
		String texto="";
		texto += "Productos:\n";
		for(Producto p: productos) {
			if(p instanceof BotellaPlastica) {
				BotellaPlastica b = (BotellaPlastica)p;
				texto+= b 
						+"\n";

			} else if(p instanceof Lata) {
				Lata l = (Lata)p;
				texto+= l
						+"\n";

			}
		}
		texto+="Total: " + this.getValorPagado() + "\n";
		texto+="Fecha Registro: " + this.getFecha() + "\n";
	
		return texto;
	}
}
