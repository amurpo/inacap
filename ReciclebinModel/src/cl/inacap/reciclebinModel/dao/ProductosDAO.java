package cl.inacap.reciclebinModel.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.reciclebinModel.dto.Producto;

public class ProductosDAO {
	
	private static List<Producto> productos = new ArrayList<Producto>();
	
	public void save(Producto p) {
		productos.add(p);
	}
	
	public List<Producto> getAll(){
		return productos;
	}
	
	public Producto find(int id) {
		return productos.get(id);
	}

}
