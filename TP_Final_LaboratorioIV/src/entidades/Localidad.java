package entidades;

public class Localidad {
	private int id;
	private String nombre;
	private Provincia id_provincia;

	//CONSTRUCTOR VACIO
	public Localidad()
	{
	
	}
	
	//CONSTRUCTOR CON PARAMETROS
	public Localidad(int id, String nombre, Provincia id_prov) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.id_provincia = id_prov;
	}
	
	//GETTERS AND SETTERS
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
	
	public Provincia getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(Provincia id_provincia) {
		this.id_provincia = id_provincia;
	}
	
	@Override
	public String toString() {
		return "Localidad [id=" + id + ", nombre=" + nombre + "]";
	}
}