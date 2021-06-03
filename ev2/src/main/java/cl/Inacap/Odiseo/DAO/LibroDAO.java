package cl.Inacap.Odiseo.DAO;

import java.util.ArrayList;
import java.util.List;

import cl.Inacap.Odiseo.DTO.Libro;

public class LibroDAO {
	
private static List<Libro> arrLibros= new ArrayList<Libro>();
	
	public void AddLibro(Libro l) {   
		arrLibros.add(l);
		
	}
	
	public List<Libro> getAllLibros(){   
		return arrLibros;
	}
	
	public void deleteLibro(int id) { 
		arrLibros.remove(id);
	}
	
	public Libro getLibrobyID(int id) { 
		return arrLibros.get(id);
	}
	
	
	public void updateLibro(Libro l,int id) {
		arrLibros.set(id,l);
	}
	
	
}