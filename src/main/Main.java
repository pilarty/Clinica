package main;

import java.util.ArrayList;
import java.util.Scanner;

import clinicaMedica.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Clinica clinica = Clinica.getInstance();
		while (true) {
			System.out.println("¿Qué desea hacer?");
			System.out.println("1. Iniciar sesión");
			System.out.println("2. Salir");

			while (!scanner.hasNextInt()) {
                System.out.println("Error: Por favor ingrese un número entero.");
                scanner.next(); 
            }
			
			int opcion = scanner.nextInt();
			
			if (opcion == 1) {
				System.out.println();
				System.out.println("¿Cómo desea ingresar?");
				System.out.println("1. Admin");
				System.out.println("2. Paciente");
				
				while (!scanner.hasNextInt()) {
	                System.out.println("Error: Por favor ingrese un número entero.");
	                scanner.next(); 
	            }
				
				int inicio = scanner.nextInt();
				if (inicio == 1) {
					System.out.println("Ingrese contraseña: "); //admin
					String contra = scanner.next();
					if (contra.equalsIgnoreCase("admin")) {
						//ADMIN
						while (true) {
							System.out.println();
							System.out.println("¿Qué desea hacer?");
							System.out.println("1. Agregar un paciente.");
							System.out.println("2. Agregar un médico.");
							System.out.println("3. Programar una cita.");
							System.out.println("4. Registrar tratamientos/procedimientos.");
							System.out.println("5. Imprimir el historial médico de un paciente.");
							System.out.println("6. Ver citas.");
							System.out.println("7. Ver pacientes.");
							System.out.println("8. Ver tratamientos.");
							System.out.println("9. Ver medicos.");
							System.out.println("10. Modificar una cita.");
							System.out.println("11. Ver citas inpagas.");
							System.out.println("12. Eliminar un paciente.");
							System.out.println("13. Eliminar un médico.");
							System.out.println("14. Eliminar una cita.");
							System.out.println("15. Salir.");
							System.out.println();
							
							while (!scanner.hasNextInt()) {
				                System.out.println("Error: Por favor ingrese un número entero.");
				                scanner.next();
				            }
							
							int opcion_admin = scanner.nextInt();
							if (opcion_admin == 1) {
						        agregarPacienteMain(scanner, clinica);
						    } 
							else if (opcion_admin == 2) {
								agregarMedicoMain(scanner, clinica);
							}
							else if (opcion_admin == 3) {
								boolean esPaciente = false;
								programarCitaMain(scanner, esPaciente, clinica);
							}
							else if (opcion_admin == 4) {
								registrarTratMain(scanner, clinica);
							}
							else if (opcion_admin == 5) {
								verHistorialPaciente(scanner, clinica);
							}
							else if (opcion_admin == 6) {
								System.out.println("¿Desea ver cita por médico, paciente, especialidad, fecha o todas? (M/P/E/F/T)");
								String opcionVer = scanner.next();
								if (opcionVer.equalsIgnoreCase("m")) {
									verCitasDoctorMain(scanner, clinica);
								}
								else if (opcionVer.equalsIgnoreCase("p")){
									verCitasPacienteMain(scanner, clinica);
								}
								else if (opcionVer.equalsIgnoreCase("e")){
									verCitasEspecialidadMain(scanner, clinica);
								}
								else if (opcionVer.equalsIgnoreCase("f")){
									verCitasFechaMain(scanner, clinica);
								}
								else if (opcionVer.equalsIgnoreCase("t")){
									verCitasGeneral(scanner, clinica);
								}
							}
							else if (opcion_admin == 7) {
								verPacientesMain(scanner, clinica);
							}
							else if (opcion_admin == 8) {
								verTratamientosMain(scanner, clinica);
							}
							else if (opcion_admin == 9) {
								verMedicosMain(scanner, clinica);
							}
							else if (opcion_admin == 10) {
								boolean esPaciente = false;
								modificarCitaMain(scanner, esPaciente, clinica);
							}
							else if (opcion_admin == 11) {
								boolean esPaciente = false;
								verCitasInpagas(scanner, esPaciente, clinica);
							}
							
							else if (opcion_admin == 12) {
								eliminarPacienteMain(scanner, clinica);
							}
							else if (opcion_admin == 13) {
								eliminarMedicoMain(scanner, clinica);
							}
							else if (opcion_admin == 14) {
								eliminarCitasMain(scanner, clinica);
							}
							else if (opcion_admin == 15) {
								break;
							}
							
							else if (opcion_admin == 100){
								agregarPredefinidos(clinica);
							}
							
							else {
								System.out.println("Error. Ingrese de nuevo.");
							}
						}
					}
					else {
						System.out.println("Contraseña incorrecta.");
					}
				}
				else if (inicio == 2) {
					//PACIENTE
					System.out.println("Ingrese su DNI: ");
					String dni = scanner.next();
					
					Paciente pacienteInicio = clinica.ObtenerPaciente(dni);
			    	while (pacienteInicio == null) {
			    	    System.out.println("Paciente no encontrado. Intente de nuevo: ");
			    	    dni = scanner.next();
			    	    pacienteInicio = clinica.ObtenerPaciente(dni);
			    	}
					
					while (true) {
						System.out.println();
						System.out.println("¿Qué desea hacer?");
						System.out.println("1. Solicitar una cita médica.");
						System.out.println("2. Ver mi historial médico.");
						System.out.println("3. Modificar una cita.");
						System.out.println("4. Ver mis citas médicas.");
						System.out.println("5. Pagar citas medicas.");
						System.out.println("6. Salir.");
						System.out.println();
						
						while (!scanner.hasNextInt()) {
			                System.out.println("Error: Por favor ingrese un número entero.");
			                scanner.next();
			            }
						
						int opcion_paciente = scanner.nextInt();
						if (opcion_paciente == 1) {
							boolean esPaciente = true;
							programarCitaMain(scanner, esPaciente, clinica);
					    } 
						else if (opcion_paciente == 2) {
							verHistorialPaciente(scanner, clinica);
						}
						else if (opcion_paciente == 3) {
							boolean esPaciente = true;
							modificarCitaMain(scanner, esPaciente, clinica);
						}
						else if (opcion_paciente == 4) {
							verCitasPacienteMain(scanner, clinica);
						}
						else if (opcion_paciente == 5) {
							boolean esPaciente = true;
							verCitasInpagas(scanner, esPaciente, clinica);
						}
						else if (opcion_paciente == 6) {
							break;
						}
						else {
							System.out.println("Error. Ingrese de nuevo.");
						}
					}
				}
				else {
					System.out.print("Error.");
				}
			}
			else if (opcion == 2){
				scanner.close();
				System.exit(0);
			}
			else {
				System.out.println("Error. Opción no válida.");
			}
		}
	}
	
	private static void eliminarPacienteMain(Scanner scanner, Clinica clinica) {
		System.out.println("Ingrese el DNI del paciente: ");
	    String dni = scanner.next();
        try {
        	clinica.EliminarPaciente(dni);
    	    System.out.println("Paciente eliminado correctamente");
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	private static void eliminarMedicoMain(Scanner scanner, Clinica clinica) {
		System.out.println("Ingrese el legajo del medico: ");
	    String legajo = scanner.next();
        try {
        	clinica.EliminarMedico(legajo);
     	    System.out.println("Medico eliminado correctamente");
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	private static void eliminarCitasMain(Scanner scanner, Clinica clinica) {
		System.out.println("Ingrese el id: ");
	    int id = scanner.nextInt();
        try {
        	clinica.EliminarCita(id);
    	    System.out.println("La cita se elimino correctamente");
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	private static void verCualquierListaDeCitas(ArrayList<CitaMedica> citas) {
		for (CitaMedica citaMedica : citas) {
        	System.out.println("Cita " + citaMedica.getId());
			System.out.println("Fecha: " + citaMedica.getFecha());
			System.out.println("Hora y minutos: " + citaMedica.getHoraMinutos());
			System.out.println("Motivo de consulta: " + citaMedica.getMotivoDeConsulta());
			System.out.println("Estado: " + citaMedica.getEstado());
			System.out.println("Pendiente de pago: " + citaMedica.isPendientePago());
			System.out.println("Nombre del médico: " + citaMedica.getMedico().getNombre());
			System.out.println();
		}
	}
	
	private static void verCitasInpagas(Scanner scanner, boolean esPaciente, Clinica clinica) {
		if (esPaciente) {
			System.out.println("Ingrese su DNI: ");
			String dni = scanner.next();
			
			Paciente pacienteInicio = clinica.ObtenerPaciente(dni);
	    	while (pacienteInicio == null) {
	    	    System.out.println("Paciente no encontrado. Intente de nuevo: ");
	    	    dni = scanner.next();
	    	    pacienteInicio = clinica.ObtenerPaciente(dni);
	    	}
	    	
	    	ArrayList<CitaMedica> citasDelPaciente = clinica.getCitasPorInpagasPorDni(dni);
	    	verCualquierListaDeCitas(citasDelPaciente);
	    	
	    	System.out.println("Ingrese el ID de la cita que desea pagar: ");
	    	int idPagar = scanner.nextInt();
	    	
	    	CitaMedica citaAPagar = clinica.ObtenerCita(idPagar);
	    	pagar(scanner, clinica.ObtenerPaciente(dni), esPaciente, citaAPagar);
	    	
		}
		else {
			ArrayList<CitaMedica> citasDelImpagas = clinica.getCitasPorInpagas();
			verCualquierListaDeCitas(citasDelImpagas);
		}
	}
	
	private static void verMedicosMain(Scanner scanner, Clinica clinica) {
		ArrayList<Medico> medicos = clinica.getMedicos();
	
        System.out.println("Lista de Medicos: ");
        int i=1;
        for (Medico med : medicos) {
        	System.out.println("Medico " + i);
			System.out.println("Nombre: " + med.getNombre());
			System.out.println("Apellido: " + med.getApellido());
			System.out.println("Especialidad: " + med.getEspecialidad());
			System.out.println("Legajo: " + med.getLegajo());
			System.out.println();
			i+=1;
        }
	}
        
	private static void verTratamientosMain(Scanner scanner, Clinica clinica) {
		ArrayList<Paciente> pacientes = clinica.getPacientes();
		System.out.println("Lista de tratamientos: ");
		int i=1;
        for (Paciente pac : pacientes) {
			for (Tratamiento tratamiento : pac.getTratamientos()) {
				System.out.println("Tratamiento " + i);
				System.out.println("Nombre: " + tratamiento.getNombre());
				System.out.println("Costo: " + tratamiento.getCosto());
				System.out.println("Medico asignado: " + tratamiento.getMedicoAsignado().getNombre());
				System.out.println();
				i+=1;
				}
        	}
		}
	
	private static void verCitasEspecialidadMain(Scanner scanner, Clinica clinica) {
		System.out.println("Especialidad: ");
        String especialidad = scanner.next();
        ArrayList<CitaMedica> citas = clinica.getCitasPorEspecialidad(especialidad);
        System.out.println("Lista de citas con especialidad " + especialidad + ": ");
        verCualquierListaDeCitas(citas);
	}
	
	
	private static void verCitasFechaMain(Scanner scanner, Clinica clinica) {
		System.out.println("Como desea que sea la comparacion antes de/ despues de/ igual que? (A/D/I)");
		String comparacion = scanner.next();
		System.out.println("Fecha: ");
        String fecha = scanner.next();
        ArrayList<CitaMedica> citas = new ArrayList<>();
        if (comparacion.equalsIgnoreCase("A")) {
        	citas = clinica.getCitasPorFecha(fecha, "antes");
        	System.out.println("Lista de citas con fecha antes de " + fecha + ": ");
        }
        else if (comparacion.equalsIgnoreCase("D")) {
        	citas = clinica.getCitasPorFecha(fecha, "despues");
        	System.out.println("Lista de citas con fecha despues de " + fecha + ": ");
        }
        else if (comparacion.equalsIgnoreCase("I")){
        	citas = clinica.getCitasPorFecha(fecha, "igual");
        	System.out.println("Lista de citas con fecha igual que " + fecha + ": ");
        }
        verCualquierListaDeCitas(citas);
	}

	
	private static void verHistorialPaciente(Scanner scanner, Clinica clinica) {
        System.out.println("Ingrese el DNI del paciente: ");
    	String dni = scanner.next();
    	
    	Paciente pac = clinica.ObtenerPaciente(dni);
    	
    	while (pac == null) {
    	    System.out.println("Paciente no encontrado. Ingrese el DNI del paciente válido: ");
    	    dni = scanner.next();
    	    pac = clinica.ObtenerPaciente(dni);
    	}

    	System.out.println("Datos del paciente:");
    	System.out.println("Nombre: " + pac.getNombre());
		System.out.println("Apellido: " + pac.getApellido());
		System.out.println("DNI: " + pac.getDni());
		System.out.println("Dirección: " + pac.getDireccion());
		System.out.println("Telefono: " + pac.getTelefono());
		System.out.println("Obra social: " + pac.getObraSocial());
		System.out.println("Mail: " + pac.getMail());
		System.out.println("Telefono: " + pac.getTelefono());
		System.out.println("Fecha de nacimiento: " + pac.getFechaNac());
    	System.out.println();
    	
    	ArrayList<CitaMedica> citasDelPaciente = clinica.getCitasPorPacientes(dni);
    	System.out.println("Citas:");
    	verCualquierListaDeCitas(citasDelPaciente);
    	
    	System.out.println("Tratamientos:");
    	int i=1;
    	for (Tratamiento t : pac.getTratamientos()) {
    		System.out.println("Tratamiento " + i);
			System.out.println("Nombre: " + t.getNombre());
			System.out.println("Costo: " + t.getCosto());
			System.out.println("Medico asignado: " + t.getMedicoAsignado().getNombre());
			System.out.println();
			i+=1;
		}
    	
    }
	
	
	private static void imprimirFactura(Factura factura) {
		System.out.println("+--------------------------------------------+");
        System.out.println("|                  Factura                   |");
        System.out.println("+--------------------------------------------+");
        System.out.println("| Fecha: " + factura.getFecha());
        System.out.println("|--------------------------------------------|");
        System.out.println("| Hora: " + factura.getHora());
        System.out.println("|--------------------------------------------|");
        System.out.println("| Costo cita: " + factura.getCostoCita());
        System.out.println("|--------------------------------------------|");
        System.out.println("| Costo tratamientos: " + factura.getCostoTratamientos());
        System.out.println("|--------------------------------------------|");
        System.out.println("| Costo especialidad: " + factura.getCostoEspecialidad());
        System.out.println("|--------------------------------------------|");
        System.out.println("| Descuento: " + factura.getDescuento());
        System.out.println("|--------------------------------------------|");
        System.out.println("| Medio de Pago: " + factura.getMedioPago());
        System.out.println("|--------------------------------------------|");
        System.out.println("| Importe Total: $" + factura.getTotal());
        System.out.println("+--------------------------------------------+");
	}
	
	
	private static void pagar(Scanner scanner, Paciente pac, boolean esPaciente, CitaMedica cita) {
	    System.out.println("Ingrese el medio de pago");
    	System.out.println("1. Tarjeta de crédito");
    	System.out.println("2. Tarjeta de debito");
    	System.out.println("3. Transferencia");
    	int opcion = scanner.nextInt();
    	String medio = "Medio";
    	while (opcion < 1 || opcion > 3) {
		     System.out.println("Error. Opción no válida. Vuelva a intentarlo");
		     opcion = scanner.nextInt();
			}
    	if (opcion == 1){
    		medio = "Crédito";
    	}
    	else if(opcion == 2) {
    		medio = "Debito";
    	}
    	else if(opcion == 3) {
    		medio = "Transferencia";
    	}
    	   	
    	double des = pac.obtenerDescuento();
    	String descuento = pac.obtenerDescuentoString();
    	
    	double costoCita = 10000;
    	double costoTratamientos = 0;
    	for (Tratamiento tratamiento : pac.getTratamientos()) {
    		costoTratamientos+=tratamiento.getCosto();
    	}
    	
    	String especialidad = cita.getMedico().getEspecialidad();
    	
    	double costoEspecialidad;
    	if (especialidad.equalsIgnoreCase("Dentista")) {
    		costoEspecialidad = 1000;
    	}
    	else if (especialidad.equalsIgnoreCase("Neurologo")) {
    		costoEspecialidad = 10000;
    	}
    	else if (especialidad.equalsIgnoreCase("Traumatologo")) {
    		costoEspecialidad = 5000;
    	}
		else if (especialidad.equalsIgnoreCase("Cardiologo")) {
			costoEspecialidad = 12000;	
		    	}
		else if (especialidad.equalsIgnoreCase("General")) {
			costoEspecialidad = 1000;
		}
		else
			costoEspecialidad = 0;
    	
    	double total = (costoCita + costoTratamientos + costoEspecialidad)*des;
    	Factura factura = new Factura(medio, costoCita, costoTratamientos, costoEspecialidad , descuento, total); 
    	
    	cita.setPendientePago(false);
    	
    	if (esPaciente) {
    		System.out.println("¿Qué desea hacer?");
        	System.out.println("1. Imprimir factura");
        	System.out.println("2. Mandar la factura por mail.");
        	System.out.println("3. Ambas");

        	opcion = scanner.nextInt();
        	while (opcion < 1 || opcion > 3) {
   		     System.out.println("Error. Opción no válida. Vuelva a intentarlo");
   		     opcion = scanner.nextInt();
   			}
	       	if (opcion == 1){
	       		imprimirFactura(factura);
	       	}
	       	else if(opcion == 2) {
	       		System.out.println("La factura se ha mandado al mail " + pac.getMail());
	       	}
	       	else if(opcion == 3) {
	       		System.out.println("La factura se ha mandado al mail " + pac.getMail());
	       		System.out.println();
	       		imprimirFactura(factura);
	       	}
    	}
    	else {
    		System.out.println("La factura se ha mandado al mail " + pac.getMail());
    		System.out.println("La factura se ha mandado al sistema de facturación.");
    	}
	}

	
	private static void verCitasGeneral(Scanner scanner, Clinica clinica) {
		ArrayList<CitaMedica> citas = clinica.getCitasGeneral();
		System.out.println("Lista de todas las citas: ");
		verCualquierListaDeCitas(citas);
	}
	
	
	private static void verPacientesMain(Scanner scanner, Clinica clinica) {
        ArrayList<Paciente> pacientes = clinica.getPacientes();
        System.out.println("Lista de pacientes: ");
        int i=1;
        for (Paciente pac : pacientes) {
        	System.out.println("Paciente " + i);
			System.out.println("Nombre: " + pac.getNombre());
			System.out.println("Apellido: " + pac.getApellido());
			System.out.println("DNI: " + pac.getDni());
			System.out.println("Dirección: " + pac.getDireccion());
			System.out.println("Telefono: " + pac.getTelefono());
			System.out.println("Obra social: " + pac.getObraSocial());
			System.out.println("Mail: " + pac.getMail());
			System.out.println("Telefono: " + pac.getTelefono());
			System.out.println("Fecha de nacimiento: " + pac.getFechaNac());
			System.out.println();
			System.out.println("Tratamientos:");
			int j=1;
			
			for (Tratamiento tratamiento : pac.getTratamientos()) {
				System.out.println("Tratamiento " + j);
				System.out.println("Nombre: " + tratamiento.getNombre());
				System.out.println("Costo: " + tratamiento.getCosto());
				System.out.println("Medico asignado: " + tratamiento.getMedicoAsignado().getNombre());
				System.out.println();
				j+=1;
			}
			i+=1;
		}
	}

	
	private static void verCitasPacienteMain(Scanner scanner, Clinica clinica) {
		System.out.println("DNI: ");
        String dni = scanner.next();
        ArrayList<CitaMedica> citas = clinica.getCitasPorPacientes(dni);
        System.out.println("Lista de citas del paciente con DNI " + dni + ": ");
        verCualquierListaDeCitas(citas);
	}
	
	
	private static void verCitasDoctorMain(Scanner scanner, Clinica clinica) {
		System.out.println("Legajo: ");
        String legajo = scanner.next();
        ArrayList<CitaMedica> citas = clinica.getCitasPorMedicos(legajo);
        System.out.println("Lista de citas del médico con legajo " + legajo + ": ");
        verCualquierListaDeCitas(citas);
	}
	
	
	private static void modificarCitaMain(Scanner scanner, boolean esPaciente, Clinica clinica) {
		if (esPaciente) {
			System.out.println("Ingrese su DNI: ");
			String dni = scanner.next();
			
			Paciente pacienteInicio = clinica.ObtenerPaciente(dni);
	    	while (pacienteInicio == null) {
	    	    System.out.println("Paciente no encontrado. Intente de nuevo: ");
	    	    dni = scanner.next();
	    	    pacienteInicio = clinica.ObtenerPaciente(dni);
	    	}
	    	
	    	ArrayList<CitaMedica> citas = clinica.getCitasPorPacientes(dni);
	    	verCualquierListaDeCitas(citas);
	    	
	    	System.out.println("¿Qué cita desea modificar? Ingrese ID: ");
			int id = scanner.nextInt();
			CitaMedica cita = clinica.ObtenerCita(id);
			
			while (true) {
				System.out.println("¿Qué queres modificar de la cita?");
				System.out.println("1. Fecha");
				System.out.println("2. Hora/minutos");
				System.out.println("3. Motivo");
				System.out.println("4. NADA");
				
				int opcion = scanner.nextInt();
				if (opcion == 1) {
					System.out.println("Ingrese nueva fecha: ");
					String fecha = scanner.next();
					try {
						cita.setFecha(fecha, clinica);
					}catch (RuntimeException e) {
			        	System.out.println(e.getMessage());
			        }
					
				}
				else if (opcion == 2) {
					System.out.println("Ingrese nueva Hora/minutos: ");
					String horaMin = scanner.next();
					try {
						cita.setHoraMinutos(horaMin, clinica);
					}catch (RuntimeException e) {
			        	System.out.println(e.getMessage());
			        }
					
				}
				else if (opcion == 3) {
					System.out.println("Ingrese nuevo motivo: ");
					String motivo = scanner.next();
					cita.setMotivoDeConsulta(motivo);
				}
				else if (opcion == 4) {
					break;
				}
			}
		}
		else {
			ArrayList<CitaMedica> citas = clinica.getCitasGeneral();
			verCualquierListaDeCitas(citas);
			
			System.out.println("¿Qué cita desea modificar? Ingrese ID: ");
			int id = scanner.nextInt();
			CitaMedica cita = clinica.ObtenerCita(id);
			
			while (true) {
				System.out.println("¿Qué queres modificar de la cita?");
				System.out.println("1. Fecha");
				System.out.println("2. Hora/minutos");
				System.out.println("3. Motivo");
				System.out.println("4. Estado");
				System.out.println("5. NADA");
				
				
				int opcion = scanner.nextInt();
				if (opcion == 1) {
					System.out.println("Ingrese nueva fecha: ");
					String fecha = scanner.next();
					try {
						cita.setFecha(fecha, clinica);
					}catch (RuntimeException e) {
			        	System.out.println(e.getMessage());
			        }
				}
				else if (opcion == 2) {
					System.out.println("Ingrese nueva Hora/minutos: ");
					String horaMin = scanner.next();
					try {
						cita.setHoraMinutos(horaMin, clinica);
					}catch (RuntimeException e) {
			        	System.out.println(e.getMessage());
			        }
				}
				else if (opcion == 3) {
					System.out.println("Ingrese nuevo motivo: ");
					String motivo = scanner.next();
					cita.setMotivoDeConsulta(motivo);
				}
				else if (opcion == 4) {
					System.out.println("¿Qué desea hacer?");
					System.out.println("1. Programar cita.");
					System.out.println("2. Cita realizada.");
					System.out.println("3. Cita cancelada.");

					
					int estado = scanner.nextInt();
					if (estado == 1) {
						cita.setEstado("Programada");
					}
					else if(estado == 2) {
						cita.setEstado("Realizada");
					}
					else if(estado == 3) {
						cita.setEstado("Cancelada");
					}
					else {
						cita.setEstado("Programada");
					}	
				}
				else if (opcion == 5) {
					break;
				}
			}
		}
	}
	
	
	
	private static void agregarPacienteMain(Scanner scanner, Clinica clinica) {
        System.out.println("Nombre: ");
        String nombre = scanner.next();
        System.out.println("Apellido: ");
        String apellido = scanner.next();
        System.out.println("DNI: ");
        String dni = scanner.next();
        System.out.println("Dirección: ");
        String direccion = scanner.next();
        System.out.println("Teléfono: ");
        String telefono = scanner.next();
        System.out.println("Obra social (Premium P/ Basica B/ Media M/ Jubilado J/ Ninguna N): ");
        String obraSocial = scanner.next();
        boolean valor = true;
        while (valor) {
        	if (obraSocial.equalsIgnoreCase("P")) {
                obraSocial = "Premium";
                valor = false;
        	}    else if (obraSocial.equalsIgnoreCase("B")) {
                obraSocial = "Basico";
                valor = false;
            } else if (obraSocial.equalsIgnoreCase("M")) {
                obraSocial = "Media";
                valor = false;
            } else if (obraSocial.equalsIgnoreCase("J")) {
                    obraSocial = "Jubilado";
                    valor = false;
            } else if (obraSocial.equalsIgnoreCase("N")) {
                obraSocial = "Ninguna";
                valor = false;
            } else {
                System.out.println("Obra social (Premium P/ Basica B/ Media M/ Jubilado J/ Ninguna N): ");
                obraSocial = scanner.next();
            }
        }
        System.out.println("Mail: ");
        String mail = scanner.next();
        System.out.println("Introduzca fecha de nacimiento en formato dd/mm/yyyy");
        String fechaNac = scanner.next();
        
        Paciente paciente = new Paciente(nombre, apellido, dni, direccion, telefono, obraSocial, mail, fechaNac);
        try {
        	clinica.AgregarPaciente(paciente);
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
    }	
	
    private static void agregarMedicoMain(Scanner scanner, Clinica clinica) {
        System.out.println("Nombre: ");
        String nombre = scanner.next();
        System.out.println("Apellido: ");
        String apellido = scanner.next();
        System.out.println("Especialidad: ");
        String especialidad = scanner.next();
        System.out.println("Legajo: ");
        String legajo = scanner.next();
        
        Medico medico = new Medico(nombre, apellido, especialidad, legajo);
        
        try {
        	clinica.AgregarMedico(medico);
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
    }
    

    private static void programarCitaMain(Scanner scanner, boolean esPaciente, Clinica clinica) {
    	System.out.println("Ingrese el DNI del paciente: ");
    	String dni = scanner.next();
    	Paciente pac = clinica.ObtenerPaciente(dni);
    	while (pac == null) {
    	    System.out.println("Paciente no encontrado. Ingrese el DNI del paciente válido: ");
    	    dni = scanner.next();
    	    pac = clinica.ObtenerPaciente(dni);
    	}
        
        System.out.println("Ingrese el legajo del médico: ");
        String legajo = scanner.next();
        Medico med = clinica.ObtenerMedico(legajo);
        while (med == (null)) {
            System.out.println("Médico no encontrado. Ingrese el legajo del médico válido: ");
            legajo = scanner.next();
            med = clinica.ObtenerMedico(legajo);
        }
        
        System.out.println("Introduzca fecha en formato dd/mm/yyyy");
        String fecha = scanner.next();
        
        System.out.println("Introduzca hora y minutos en formato HH:mm");       
        String horaMinutos = scanner.next();
        
        System.out.println("Motivo de consulta: ");
        String motivo = scanner.next();
        
        
        CitaMedica cita = new CitaMedica(fecha, horaMinutos, motivo, "Programada", true, med, pac);
        try {
        	clinica.ProgramarCita(cita);
            cita.addObserver(pac);
            System.out.println("Pagar la cita (s/n)");
            String pagar = scanner.next();
            if (pagar.equals("s")) {
            	pagar(scanner, pac, esPaciente, cita);
            }
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
        
    }
	
	private static void registrarTratMain(Scanner scanner, Clinica clinica) {
		System.out.println("Registrar Tratamiento/Procedimiento");
		System.out.println("Nombre: ");
		String nombre = scanner.next();
		
		System.out.println("Costo: ");
		int costo = scanner.nextInt();
    	
    	System.out.println("Ingrese el legajo del médico: ");
        String legajo = scanner.next();
        
        Medico med = clinica.ObtenerMedico(legajo);
        while (med.equals(null)) {
            System.out.println("Médico no encontrado. Ingrese el legajo del médico válido: ");
            legajo = scanner.next();
            med = clinica.ObtenerMedico(legajo);
        }
		
		System.out.println("Ingrese el DNI del paciente: ");
    	String dni = scanner.next();
    	
    	Paciente pac = clinica.ObtenerPaciente(dni);
    	
    	while (pac == null) {
    	    System.out.println("Paciente no encontrado. Ingrese el DNI del paciente válido: ");
    	    dni = scanner.next();
    	    pac = clinica.ObtenerPaciente(dni);
    	}
    	
    	Tratamiento tratamiento = new Tratamiento(nombre, costo, med);
    	pac.AgregarTratamiento(tratamiento);
    	System.out.println("Tratamiento agregado exitosamente.");
	}
	
	private static void agregarPredefinidos(Clinica clinica) {
		Paciente paciente = new Paciente("Pilar", "Garcia", "12345678", "Calle1", "11347258", "Medio", "pilar@gmail.com", "13/11/2003");
		clinica.AgregarPaciente(paciente);
        Paciente paciente2 = new Paciente("Christian", "Salleme", "15645655", "Calle2", "11347987", "Basico", "chris@gmail.com", "11/11/2003");
        clinica.AgregarPaciente(paciente2);
        Paciente paciente3 = new Paciente("Lola", "Diaz", "15288655", "Calle3", "11347923", "Ninguna", "lola@gmail.com", "19/02/2003" );
        clinica.AgregarPaciente(paciente3);
		
    	Medico medico = new Medico("Clemente", "Rodiguez", "Dentista", "1111");
    	clinica.AgregarMedico(medico);
        Medico medico2 = new Medico("Gustavo", "Lopez", "Neurologo", "2222");
        clinica.AgregarMedico(medico2);
        Medico medico3 = new Medico("Ivan", "Pillud", "Traumatologo", "3333");
        clinica.AgregarMedico(medico3);
        
        Tratamiento tratamiento = new Tratamiento("TerapiaAntiinflamatoria", 1500, medico);
    	paciente.AgregarTratamiento(tratamiento);
        Tratamiento tratamiento2 = new Tratamiento("TerapiaAnalgésica", 2000, medico);
    	paciente2.AgregarTratamiento(tratamiento2);
        Tratamiento tratamiento3 = new Tratamiento("TerapiaHormonal", 3000, medico2);
    	paciente3.AgregarTratamiento(tratamiento3);
    	
    	
        CitaMedica cita = new CitaMedica("11/11/2024", "11:30", "DolorMuela", "Programada", true, medico, paciente);
        cita.addObserver(paciente);
        clinica.ProgramarCita(cita);
        CitaMedica cita2 = new CitaMedica("14/09/2024", "19:15", "ChequeoAnual", "Programada", true, medico2, paciente2);
        cita2.addObserver(paciente2);
        clinica.ProgramarCita(cita2);
        CitaMedica cita3 = new CitaMedica("20/01/2025", "09:00", "FracturaExpuesta", "Programada", true, medico3, paciente3);
        cita3.addObserver(paciente3);
        clinica.ProgramarCita(cita3);
        CitaMedica cita4 = new CitaMedica("02/07/2024", "16:00", "DolorRodilla", "Programada", true, medico3, paciente);
        cita4.addObserver(paciente);
        clinica.ProgramarCita(cita4);
	}

}
