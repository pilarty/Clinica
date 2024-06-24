package clinicaMedica;

import java.util.ArrayList;

import descuentosObraSocial.*;

public class Paciente implements Observer {
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    
    private String obraSocial;
    //obra social: ninguna(0%), basico(15%), medio(25%), premium(50%) o jubilado(75%)
    
    private CalculoDescuento DescuentoObraSocial;
    
    private String mail;
    private String fechaNac;
    private ArrayList<Tratamiento> tratamientos = new ArrayList<>();
    
    public Paciente(String nombre, String apellido, String dni, String direccion, String telefono, String obraSocial,
			String mail, String fechaNac) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		setCalculoDescuento(obraSocial);
		this.obraSocial = obraSocial;
		this.mail = mail;
		this.fechaNac = fechaNac;
		
	}
    
    private void setCalculoDescuento(String obraSocial) {
    	switch (obraSocial) {
        case "Basico":
            this.DescuentoObraSocial = new DescuentoBasico();
            break;
        case "Medio":
            this.DescuentoObraSocial = new DescuentoMedio();
            break;
        case "Premium":
            this.DescuentoObraSocial = new DescuentoPremium();
            break;
        case "Jubilado":
            this.DescuentoObraSocial = new DescuentoJubilado();
            break;
        default:
            this.DescuentoObraSocial = new DescuentoNinguna();
            break;
    	}
    }

    public double obtenerDescuento() {
        return DescuentoObraSocial.calcularDescuento();
    }

    public String obtenerDescuentoString() {
        return DescuentoObraSocial.obtenerDescuento();
    }
    
    
	public void AgregarTratamiento(Tratamiento tratamiento) {
    	this.tratamientos.add(tratamiento);
    }


	public ArrayList<Tratamiento> getTratamientos() {
		return tratamientos;
	}


	public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getObraSocial() {
		return obraSocial;
	}


	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
		setCalculoDescuento(obraSocial);
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	
	public void update(String mensaje) {
        System.out.println("Notificación para " + nombre + ": " + mensaje);
	}

}
