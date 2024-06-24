package clinicaMedica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Clinica {
	private static Clinica instance;
    private ArrayList<Paciente> Pacientes;
    private ArrayList<CitaMedica> Citas;
    private ArrayList<Medico> Medicos;
    
    private Clinica() {
        Pacientes = new ArrayList<>();
        Citas = new ArrayList<>();
        Medicos = new ArrayList<>();
    }
    //Singleton
    public static synchronized Clinica getInstance() {
        if (instance == null) {
            instance = new Clinica();
        }
        return instance;
    }
    
    public void EliminarMedico(String legajo) {
    	boolean existe = false;
        for (Medico med : Medicos) {
            if (med.getLegajo().equals(legajo)) {
            	Medicos.remove(med);
            	existe = true;
            	break;
            }
        }
        if (! existe) {
       	 throw new RuntimeException("Error: Medico no encontrado");
       }
    }
    
    public void EliminarPaciente(String dni) {
    	boolean existe = false;
        for (Paciente pac : Pacientes) {
            if (pac.getDni().equals(dni)) {
            	Pacientes.remove(pac);
            	existe = true;
            	break;
            }
        }
        if (! existe) {
        	 throw new RuntimeException("Error: Paciente no encontrado");
        }
       
    }
    
    public void EliminarCita(int id) {
    	boolean existe = false;
        for (CitaMedica cit : Citas) {
            if (cit.getId() == id) {
            	Citas.remove(cit);
            	existe = true;
            	break;
            }
        }
        if (! existe) {
       	 throw new RuntimeException("Error: Cita no encontrada");
       }
    }
    
    public CitaMedica ObtenerCita(int id) {
        for (CitaMedica cit : Citas) {
            if (cit.getId() == id) {
                return cit; 
            }
        }
        return null; 
    }
   
    
    public Paciente ObtenerPaciente(String dni) {
        for (Paciente pac : Pacientes) {
            if (pac.getDni().equals(dni)) {
                return pac; 
            }
        }
        return null; 
    }
    
    public Medico ObtenerMedico(String legajo) {
        for (Medico med : Medicos) {
            if (med.getLegajo().equals(legajo)) {
                return med;
            }
        }
        return null; 
    }
    
    
    public void AgregarMedico(Medico medico) {
        for (Medico med : Medicos) {
            if (med.getLegajo().equals(medico.getLegajo())) {
                throw new RuntimeException("Error: Medico ya agregado.");
            }
        }
        Medicos.add(medico);
        System.out.println("Médico agregado exitosamente.");
    }
    
    public void AgregarPaciente(Paciente paciente) {
        for (Paciente pac : Pacientes) {
            if (pac.getDni().equals(paciente.getDni())) {
                throw new RuntimeException("Error: Paciente ya agregado.");
            }
        }
        Pacientes.add(paciente);
        System.out.println("Paciente agregado exitosamente.");
    }
    
    
    public void ProgramarCita(CitaMedica cita) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
    	try {
    		for (CitaMedica cit : Citas) {
                LocalDate date1 = LocalDate.parse(cit.getFecha(), formatter);
                LocalDate date2 = LocalDate.parse(cita.getFecha(), formatter);
                if (date1.isEqual(date2)) {
                	LocalTime Time1 = LocalTime.parse(cit.getHoraMinutos(), formatter2);
                    LocalTime Time2 = LocalTime.parse(cita.getHoraMinutos(), formatter2);
                    if (Time1.equals(Time2)) {
                    	if (cit.getMedico().getLegajo().equals(cita.getMedico().getLegajo())) {
                    		throw new RuntimeException("Error: El medico ya tiene una cita a ese horario.");
                    	}
                    	else if (cit.getPaciente().getDni().equals(cita.getPaciente().getDni())){
                    		throw new RuntimeException("Error: El paciente ya tiene una cita a ese horario.");
                    	}
                    }
                }
        	} 
        }catch (DateTimeParseException e){
        	throw new RuntimeException("Formato de fecha inválido");
        }
        Citas.add(cita);
        System.out.println("Cita agregada exitosamente.");
    }
    
    public ArrayList<CitaMedica> getCitasPorPacientes(String dni){
    	ArrayList<CitaMedica> citasDelPaciente = new ArrayList<>();
    	for (CitaMedica c : Citas) {
    		if (c.getPaciente().getDni().equals(dni)) {
    			citasDelPaciente.add(c);
    		}
    	}
    	return citasDelPaciente;
    }
    
    public ArrayList<CitaMedica> getCitasPorMedicos(String legajo){
    	ArrayList<CitaMedica> citasDelMedico =new ArrayList<>();
    	for (CitaMedica c : Citas) {
    		if (c.getMedico().getLegajo().equals(legajo)) {
    			citasDelMedico.add(c);
    		}
    	}
    	return citasDelMedico;
    }
    
    public ArrayList<CitaMedica> getCitasGeneral(){
    	return Citas;
    }
    
    public ArrayList<Paciente> getPacientes(){
    	return Pacientes;
    }
    
    public ArrayList<Medico> getMedicos(){
    	return Medicos;
    }
    
    public ArrayList<CitaMedica> getCitasPorEspecialidad(String especialidad){
    	ArrayList<CitaMedica> citasEsp =new ArrayList<>();
    	for (CitaMedica c : Citas) {
    		if (c.getMedico().getEspecialidad().equals(especialidad)) {
    			citasEsp.add(c);
    		}
    	}
    	return citasEsp;
    }
    
    public ArrayList<CitaMedica> getCitasPorInpagasPorDni(String dni){ //paciente
    	ArrayList<CitaMedica> citasInpagasDni =new ArrayList<>();
    	ArrayList<CitaMedica> citasDelPaciente = getCitasPorPacientes(dni);
	    	for (CitaMedica c : citasDelPaciente) {
	    		if (c.isPendientePago()) {
	    			citasInpagasDni.add(c);
	    		}
	    	}
    	return citasInpagasDni;
    }
    
    public ArrayList<CitaMedica> getCitasPorInpagas(){ //admin
    	ArrayList<CitaMedica> citasInpagas =new ArrayList<>();
    	for (CitaMedica c : Citas) {
    		if (c.isPendientePago()) {
    			citasInpagas.add(c);
    		}
    	}
    	return citasInpagas;
    }
    
    public ArrayList<CitaMedica> getCitasPorFecha(String fecha, String comparacion){
    	ArrayList<CitaMedica> citasFecha =new ArrayList<>();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	try {
            LocalDate date1 = LocalDate.parse(fecha, formatter);
  
			for (CitaMedica c : Citas) {
				LocalDate date2 = LocalDate.parse(c.getFecha(), formatter);
				if (comparacion.equals("antes")) {
					if (date1.isAfter(date2)) {
						citasFecha.add(c);
					}
				}
				else if (comparacion.equals("despues")) {
					if (date1.isBefore(date2)) {
						citasFecha.add(c);
					}
				}
				else if (comparacion.equals("igual")) {
					if (date1.isEqual(date2)) {
						citasFecha.add(c);
					}
				}
			}
    	} catch (DateTimeParseException e){
    		System.out.println("Formato de fecha inválido");
    	}
    	return citasFecha;
    }
    

    
}
