package negocioImpl;

import daoImpl.PacienteDaoImpl;
import entidades.Paciente;
import negocio.IPacienteNegocio;

//Aca van las validaciones de los datos que vienen del servlet
public class PacienteNegocio implements IPacienteNegocio{

	PacienteDaoImpl pacienteImpl = new PacienteDaoImpl();
	
	public int agregarPaciente(Paciente paciente) {
		int filas = 0;
		filas = pacienteImpl.agregarPaciente(paciente);			
		return filas;
	}
}
