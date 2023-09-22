package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.ILocalidadDao;
import entidades.Localidad;

public class LocalidadDaoImpl implements ILocalidadDao{

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbname = "bdtpfinal";
	
	public ResultSet listarLocalidad() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Connection cn = null;
		Localidad loc = new Localidad();
		ResultSet rs = null;
		try {
			cn = DriverManager.getConnection(host+dbname,user,pass);
			String query = "SELECT * FROM localidades";
			PreparedStatement pst = cn.prepareStatement(query); 
			
			rs = pst.executeQuery();
			rs.next();
			
			loc.setNombre(rs.getString("Nombre"));
			loc.setId(rs.getInt("ID"));		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}