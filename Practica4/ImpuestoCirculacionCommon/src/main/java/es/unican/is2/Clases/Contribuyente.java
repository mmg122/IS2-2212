package es.unican.is2.Clases;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Contribuyente implements Serializable {

    private List<Vehiculo> vehiculos;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    
    public Contribuyente (String nom, String a1, String a2, String dni) {
    	this.nombre = nom;
    	this.apellido1 = a1;
    	this.apellido2 = a2;
    	this.dni = dni;
    	vehiculos = new LinkedList<Vehiculo>();
    }
    
    /**
     * Retorna el total a pagar por el impuesto 
     * de circulacion de todos sus vehiculos
     * @return Valor del impuesto a pagar
     */
    public double totalAPagar() {
    	double total = 0;
    	for (Vehiculo v: vehiculos) {
    		total += v.precioImpuesto(); 
    	}
    	return total;
    }
    
    /**
     * Retorna la lista de vehiculos del contribuyente
     * @return lista de vehiculos del contribuyente
     */
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	/**
	 * Retorna el valor del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna el valor del atributo apellido1
	 * @return primer apellido
	 */
	public String getApellido1() {
		return apellido1;
	}
	
	/**
	 * Retorna el valor del atributo apellido2
	 * @return segundo apellido
	 */
	public String getApellido2() {
		return apellido2;
	}
	
	/**
	 * Retorna el valor del dni del contribuyente
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
    
	
}
