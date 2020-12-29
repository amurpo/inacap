package cl.inacap.reciclebinModel.dao;

import java.util.ArrayList;
import java.util.List;
import cl.inacap.reciclebinModel.dto.Reciclaje;

public class ReciclajesDAO {
	private static List<Reciclaje> reciclajes = new ArrayList<Reciclaje>();
	public void save(Reciclaje r) {
		reciclajes.add(r);
	}
	
	public static List<Reciclaje> getAll(){
		return reciclajes;
	}
	
	public void delete(Reciclaje r) {
		reciclajes.remove(r);
	}
	
	public void delete(int i) {
		reciclajes.remove(i);
	}

}
