package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Paciente;
import negocioImpl.PacienteNegocio;

/**
 * Servlet implementation class ServletPaciente
 */
@WebServlet("/ServletPaciente")
public class ServletPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filas = 0;
		if(request.getParameter("btnAgregar")!=null)
		{
			Paciente paciente = new Paciente();
			PacienteNegocio pacNego = new PacienteNegocio();
			
			paciente.setDni(Integer.parseInt(request.getParameter("txtDni")));
			paciente.setNombre(request.getParameter("txtNombre"));
			paciente.setApellido(request.getParameter("txtApellido"));
			paciente.setSexo(request.getParameter("sexo"));
			paciente.setNacionalidad(request.getParameter("txtNacionalidad"));
			paciente.setFechaNacimiento(request.getParameter("txtFechaNac"));
			paciente.setDireccion(request.getParameter("txtDireccion"));
			paciente.setLocalidad(request.getParameter("txtLocalidad"));
			paciente.setProvincia(request.getParameter("txtProvincia"));
			paciente.setCorreoElectronico(request.getParameter("txtCorreoElectronico"));
			paciente.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
			filas = pacNego.agregarPaciente(paciente);
		}
		
		request.setAttribute("cantFilas", filas);
		RequestDispatcher rd = request.getRequestDispatcher("Ejemplo1.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
