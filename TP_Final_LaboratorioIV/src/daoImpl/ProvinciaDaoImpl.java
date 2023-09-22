package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.IProvinciaDao;
import entidades.Provincia;

public class ProvinciaDaoImpl implements IProvinciaDao{

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbname = "bdtpfinal";
	
	public ResultSet listarProvincias() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Connection cn = null;
		ResultSet rs = null;
		Provincia prov = new Provincia();
		
		try {
			cn = DriverManager.getConnection(host+dbname,user,pass);
			String query = "SELECT * FROM provincias";
			PreparedStatement pst = cn.prepareStatement(query);
			
			rs = pst.executeQuery();
			rs.next();
		
			prov.setId(rs.getInt("ID"));
			prov.setNombre(rs.getString("nombre"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
