package clinicaMedica;

import org.junit.Test;


public class Tests {
	Clinica clinica = Clinica.getInstance();
	@Test
	public void agregarMedicoTest() {
        try {
        	System.out.println("agregarMedicoTest");
        	Medico medico1 = new Medico("Clara", "Guitierrez", "Dentista", "8888");
        	clinica.AgregarMedico(medico1);
            Medico medico2 = new Medico("Clara", "Guitierrez", "Dentista", "8888");
            clinica.AgregarMedico(medico2);
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
        System.out.println();
	}
	
	@Test
	public void agregarPacienteTest() {
        try {
        	System.out.println("agregarPacienteTest");
        	Paciente paciente = new Paciente("Pilar", "Garcia", "12345678", "Calle1", "11347258", "Medio", "pilar@gmail.com", "13/11/2003");
        	clinica.AgregarPaciente(paciente);
            Paciente paciente2 = new Paciente("Pilar", "Garcia", "12345678", "Calle1", "11347258", "Medio", "pilar@gmail.com", "13/11/2003");
            clinica.AgregarPaciente(paciente2);
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
        System.out.println();
	}
	
	@Test
	public void eliminarPacienteTest() {
		try {
			System.out.println("eliminarPacienteTest");
			clinica.EliminarPaciente(null);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	@Test
	public void eliminarMedicoTest() {
		try {
			System.out.println("eliminarMedicoTest");
			clinica.EliminarMedico(null);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	@Test
	public void eliminarCitaTest() {
		try {
			System.out.println("eliminarCitaTest");
			clinica.EliminarCita(-1);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	
	@Test
	public void agregarCitaNoDisponibleMedico() {
		try {
			System.out.println("agregarCitaNoDisponibleMedico");
			Paciente paciente = new Paciente("Pilar", "Garcia", "12345678", "Calle1", "11347258", "Medio", "pilar@gmail.com", "13/11/2003");
			Paciente paciente2 = new Paciente("Christian", "Salleme", "15645655", "Calle2", "11347987", "Basico", "chris@gmail.com", "11/11/2003");
			Medico medico1 = new Medico("Clara", "Guitierrez", "Dentista", "8888");
			CitaMedica cita = new CitaMedica("11/11/2024", "11:30", "DolorMuela", "Programada", true, medico1, paciente);
			clinica.ProgramarCita(cita);
			CitaMedica cita2 = new CitaMedica("11/11/2024", "11:30", "Dolor", "Programada", true, medico1, paciente2);
			clinica.ProgramarCita(cita2);
		}catch (RuntimeException e) {
    		System.out.println(e.getMessage());
    	}
		System.out.println();
	}
	
	@Test
	public void agregarCitaNoDisponiblePaciente() {
		try {
			System.out.println("agregarCitaNoDisponiblePaciente");
			Paciente paciente = new Paciente("Pilar", "Garcia", "12345678", "Calle1", "11347258", "Medio", "pilar@gmail.com", "13/11/2003");
			Medico medico = new Medico("Clemente", "Rodiguez", "Dentista", "1111");
			Medico medico2 = new Medico("Gustavo", "Lopez", "Neurologo", "2222");
			CitaMedica cita = new CitaMedica("11/11/2024", "11:30", "DolorMuela", "Programada", true, medico, paciente);
			clinica.ProgramarCita(cita);
			CitaMedica cita2 = new CitaMedica("11/11/2024", "11:30", "Dolor", "Programada", true, medico2, paciente);
			clinica.ProgramarCita(cita2);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	@Test
	public void modificarCitaNoDisponiblePaciente() {
		try {
			System.out.println("modificarCitaNoDisponiblePaciente");
			Paciente paciente = new Paciente("Pilar", "Garcia", "12345678", "Calle1", "11347258", "Medio", "pilar@gmail.com", "13/11/2003");
			Medico medico = new Medico("Clemente", "Rodiguez", "Dentista", "1111");
			Medico medico2 = new Medico("Gustavo", "Lopez", "Neurologo", "2222");
			CitaMedica cita = new CitaMedica("11/11/2024", "11:30", "DolorMuela", "Programada", true, medico, paciente);
			clinica.ProgramarCita(cita);
			CitaMedica cita2 = new CitaMedica("12/11/2024", "11:30", "Dolor", "Programada", true, medico2, paciente);
			clinica.ProgramarCita(cita2);
			cita2.setFecha("11/11/2024", clinica);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	@Test
	public void modificarCitaNoDisponibleMedico() {
		try {
			System.out.println("modificarCitaNoDisponibleMedico");
			Paciente paciente = new Paciente("Pilar", "Garcia", "12345678", "Calle1", "11347258", "Medio", "pilar@gmail.com", "13/11/2003");
			Paciente paciente2 = new Paciente("Christian", "Salleme", "15645655", "Calle2", "11347987", "Basico", "chris@gmail.com", "11/11/2003");
			Medico medico1 = new Medico("Clara", "Guitierrez", "Dentista", "8888");
			CitaMedica cita = new CitaMedica("11/11/2024", "11:30", "DolorMuela", "Programada", true, medico1, paciente);
			clinica.ProgramarCita(cita);
			CitaMedica cita2 = new CitaMedica("12/11/2024", "11:30", "Dolor", "Programada", true, medico1, paciente2);
			clinica.ProgramarCita(cita2);
			cita2.setFecha("11/11/2024", clinica);
		}catch (RuntimeException e) {
    		System.out.println(e.getMessage());
    	}
		System.out.println();
	}
}
