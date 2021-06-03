package cl.Inacap.Odiseo.DTO;

public class Libro {

	private int id;
	private String nombre;
	private String autor;
	private int numpag;
	private boolean destacado;
	private int estrellas;
	private String portada;
	
	public Libro(int id, String nombre, String autor, int numpag, boolean destacado, int estrellas, String portada) {
		super();
		this.id=id;
		this.nombre=nombre;
		this.autor=autor;
		this.numpag=numpag;
		this.destacado=destacado;
		this.estrellas=estrellas;
		this.portada=portada;
	}
	
	public Libro() {};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumpag() {
		return numpag;
	}
	public void setNumpag(int numpag) {
		this.numpag = numpag;
	}
	public boolean isDestacado() {
		return destacado;
	}
	public void setDestacado(boolean destacado) {
		this.destacado = destacado;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	
}