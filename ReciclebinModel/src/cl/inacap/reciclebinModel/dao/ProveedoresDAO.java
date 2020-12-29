package cl.inacap.reciclebinModel.dao;

import java.util.ArrayList;
import java.util.List;
import cl.inacap.reciclebinModel.dto.Proveedor;

public class ProveedoresDAO {
	private static List<Proveedor> proveedores = new ArrayList<Proveedor>();
	public void save(Proveedor pro) {
		proveedores.add(pro);
	}
	
	public static List<Proveedor> getAll(){
		return proveedores;
	}
	
	public void delete(Proveedor pro) {
		proveedores.remove(pro);
	}
	
	public void delete(int i) {
		proveedores.remove(i);
	}

	public Proveedor find(int indice) {
		return null;
	}
}
