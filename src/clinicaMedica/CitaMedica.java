package clinicaMedica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;


public class CitaMedica implements Observable{
	private ArrayList<Observer> observers;
	private int id;
    private String fecha;
    private String horaMinutos;
    private String motivoDeConsulta;
    private String estado;
    private boolean pendientePago;
    private Medico medico;
    private Paciente paciente;
    
    
    public CitaMedica(String fecha, String horaMinutos, String motivoDeConsulta, String estado, boolean pendientePago,
			Medico medico, Paciente paciente) {
		super();
		
		Random rand = new Random();
		
		this.id = rand.nextInt(9999);
		this.fecha = fecha;
		this.horaMinutos = horaMinutos;
		this.motivoDeConsulta = motivoDeConsulta;
		this.estado = estado;
		this.medico = medico;
		this.pendientePago = pendientePago;
		this.paciente = paciente;
		this.observers = new ArrayList<>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha, Clinica clinica) {
		ArrayList<CitaMedica> citas = clinica.getCitasGeneral();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (CitaMedica cit : citas) {
			try {
			
                LocalDate date1 = LocalDate.parse(cit.getFecha(), formatter);
                LocalDate date2 = LocalDate.parse(fecha, formatter);
                if (date1.isEqual(date2)) {
                	LocalTime Time1 = LocalTime.parse(cit.getHoraMinutos(), formatter2);
                    LocalTime Time2 = LocalTime.parse(this.horaMinutos, formatter2);
                    if (Time1.equals(Time2)) {
                    	if (cit.getMedico().getLegajo().equals(this.medico.getLegajo())) {
                    		throw new RuntimeException("Error: El medico ya tiene una cita a ese horario.");
                    	}
                    	else if (cit.getPaciente().getDni().equals(this.paciente.getDni())){
                    		throw new RuntimeException("Error: El paciente ya tiene una cita a ese horario.");
                    	}
                    }
                }
        	} catch (DateTimeParseException e) {
    			throw new RuntimeException("Formato de fecha inválido");
        	}
    	}
		this.fecha = fecha;
		notifyObservers("La fecha de la cita ha sido cambiada a: " + fecha);	
	}

	public String getHoraMinutos() {
		return horaMinutos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setHoraMinutos(String horaMinutos, Clinica clinica) {
		ArrayList<CitaMedica> citas = clinica.getCitasGeneral();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			for (CitaMedica cit : citas) {
                LocalDate date1 = LocalDate.parse(cit.getFecha(), formatter);
                LocalDate date2 = LocalDate.parse(this.fecha, formatter);
                if (date1.isEqual(date2)) {
                	LocalTime Time1 = LocalTime.parse(cit.getHoraMinutos(), formatter2);
                    LocalTime Time2 = LocalTime.parse(horaMinutos, formatter2);
                    if (Time1.equals(Time2)) {
                    	if (cit.getMedico().getLegajo().equals(this.medico.getLegajo())) {
                    		throw new RuntimeException("Error: El medico ya tiene usa cita a ese horario.");
                    	}
                    	else if (cit.getPaciente().getDni().equals(this.paciente.getDni())){
                    		throw new RuntimeException("Error: El paciente ya tiene usa cita a ese horario.");
                    	}
                    }
                }
        	} 
		}catch (DateTimeParseException e){
    		throw new RuntimeException("Formato de fecha inválido");
    	}
		this.horaMinutos = horaMinutos;
		notifyObservers("La hora de la cita ha sido cambiada a: " + horaMinutos);
	}

	public String getMotivoDeConsulta() {
		return motivoDeConsulta;
	}

	public void setMotivoDeConsulta(String motivoDeConsulta) {
		this.motivoDeConsulta = motivoDeConsulta;
		notifyObservers("El motivo de la cita ha sido cambiado a: " + motivoDeConsulta);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
		notifyObservers("El medico de la cita ha sido cambiada a: " + medico.getNombre());
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public boolean isPendientePago() {
		return pendientePago;
	}

	public void setPendientePago(boolean pendientePago) {
		this.pendientePago = pendientePago;
		if (pendientePago) {
			notifyObservers("Tu cita tiene el pago pendiente");
		}
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String mensaje) {
        for (Observer o : observers) {
            o.update(mensaje);
        }
    }
    
 
    
}
