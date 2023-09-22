<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de pacientes</title>
<script type="text/javascript">
	function combo_localidad()
	{
		
	}
</script>
</head>
<body>
<jsp:useBean id="lc" class="daoImpl.LocalidadDaoImpl" scope="page"></jsp:useBean>
<jsp:useBean id="pv" class="daoImpl.ProvinciaDaoImpl" scope="page"></jsp:useBean>
<form action="ServletPaciente" method="post" id="data">

	Ingrese su DNI: <input type="text" name="txtDni"><br>
	Ingrese su nombre: <input type="text" name="txtNombre"><br>
	Ingrese su apellido: <input type="text" name="txtApellido"><br>
	Ingrese su genero: <select name="sexo">
					   <option>Femenino</option>
					   <option>Masculino</option>
					   </select><br>
	Ingrese su nacionalidad: <input type="text" name="txtNacionalidad"><br>
	Ingrese su fecha de nacimiento: <input type="date" name="txtFechaNac"><br>
	Ingrese su dirección: <input type="text" name="txtDireccion"><br>
	
						  <%ResultSet rsp = pv.listarProvincias(); %>
	Ingrese su provincia: <select  name="provincia" onchange="combo_localidad()">
						  <option value="">--seleccione--</option>
						  <%while (rsp.next()){ %>
						   <option value="<%=rsp.getString("nombre")%>"><%=rsp.getString("nombre") %></option>
						  <%} %>
						  </select>
						  <br>
						  <%-- <%ResultSet rs = lc.listarLocalidad(); %> --%>
	Ingrese su localidad: <select name="localidad" id="id_localidad">
						  <option value="">--seleccione--</option>
						  <%-- <%while (rs.next()){ %>
						  	<option value="<%=rs.getString("nombre")%>"><%=rs.getString("nombre") %></option>
						  <%} %> --%>
						  </select><br>
	Ingrese su e-mail: <input type="text" name="txtCorreoElectronico"><br>
	Ingrese su teléfono: <input type="text" name="txtTelefono"><br>
	<input type="submit" name="btnAgregar" value="Agregar Paciente">
</form>

<%
	int filas = 0;
	if(request.getAttribute("cantFilas")!=null)
		filas = (int)request.getAttribute("cantFilas");
		
%>

<%if(filas==1)
	{ %>
	¡Paciente agregado con exito!
<%}%>
	

</body>
</html> 