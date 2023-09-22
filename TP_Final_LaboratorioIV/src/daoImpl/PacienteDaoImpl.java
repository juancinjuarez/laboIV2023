package daoImpl;

import entidades.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dao.IPacienteDao;

//Aca van los desarrollos de los métodos 
public class PacienteDaoImpl implements IPacienteDao{
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbname = "bdtpfinal";
	
	public int agregarPaciente(Paciente paciente) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Connection cn = null;
		int cantFilas = 0;
		
		try {
			cn = DriverManager.getConnection(host+dbname,user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into paciente(DNI,nombre,apellido,sexo,nacionalidad,fechaNac,direccion,localidad)values('"+paciente.getDni()+"','"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+paciente.getSexo()+"','"+paciente.getNacionalidad()+"','"+paciente.getFechaNacimiento()+"','"+paciente.getDireccion()+"','"+paciente.getLocalidad()+"','"+paciente.getProvincia()+"','"+paciente.getCorreoElectronico()+"','"+paciente.getTelefono()	+"')";
			cantFilas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cantFilas;
	}
}
