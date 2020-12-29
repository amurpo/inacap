package cl.inacap.reciclebinModel.dto;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
	String nombre;
	String rut;
	String tipoEmpresa;
	boolean tieneConvenio;

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

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public boolean isTieneConvenio() {
		return tieneConvenio;
	}

	public void setTieneConvenio(boolean tieneConvenio) {
		this.tieneConvenio = tieneConvenio;
	}
	private List<Producto>  productos = new ArrayList<Producto>();
	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public String toString() {
		String texto="";
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
		texto+="RUT: " + this.getRut() + "\n";
		texto+="Nombre: " + this.getNombre() + "\n";
	
		return texto;
	}


	
}
