package clinicaMedica;

public class Tratamiento {
	private String nombre;
    private int costo;
    private Medico medicoAsignado;
    
    
	public Tratamiento(String nombre, int costo, Medico medicoAsignado) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.medicoAsignado = medicoAsignado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public Medico getMedicoAsignado() {
		return medicoAsignado;
	}


	public void setMedicoAsignado(Medico medicoAsignado) {
		this.medicoAsignado = medicoAsignado;
	}

	
	
    
    
    
}
