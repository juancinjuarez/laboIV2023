package entidades;

public class Provincia {
	private int id;
	private String nombre;
	
	//CONSTRUCTORES
	public Provincia()
	{
		
	}
	
	public Provincia(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
}
