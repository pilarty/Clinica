package clinicaMedica;

import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;

public class Factura {
    private int numero;
    private String medioPago;
    private String descuento;
    private LocalDate fecha;
    private LocalTime hora;
    private double costoCita;
    private double costoTratamientos;
    private double costoEspecialidad;
    private double total;
    
	public Factura(String medioPago, double costoCita, double costoTratamientos, double costoEspecialidad, String descuento, double total) {
		super();
		Random rand = new Random();
		this.numero = rand.nextInt(99999);
		this.medioPago = medioPago;
		this.descuento = descuento;
		this.fecha=LocalDate.now();
		this.hora=LocalTime.now();
		this.costoCita = costoCita;
		this.costoTratamientos = costoTratamientos;
		this.costoEspecialidad = costoEspecialidad;
		this.total = total;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public double getCostoCita() {
		return costoCita;
	}

	public void setCostoCita(double costoCita) {
		this.costoCita = costoCita;
	}

	public double getCostoTratamientos() {
		return costoTratamientos;
	}

	public void setCostoTratamientos(double costoTratamientos) {
		this.costoTratamientos = costoTratamientos;
	}

	public double getCostoEspecialidad() {
		return costoEspecialidad;
	}

	public void setCostoEspecialidad(double costoEspecialidad) {
		this.costoEspecialidad = costoEspecialidad;
	}
	
	
	
    
    
}