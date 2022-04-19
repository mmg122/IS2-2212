package es.unican.is2.Clases;
import java.io.Serializable;
import java.time.LocalDate;

import es.unican.is2.Excepciones.OperacionNoValida;


@SuppressWarnings("serial")
public abstract class Vehiculo implements Serializable{
  
    private String matricula;
	private LocalDate fechaMatriculacion;
	
	public Vehiculo(String mat, LocalDate fecha) throws OperacionNoValida {
		if (mat == null) {
			throw new OperacionNoValida(mat);
		}
		if (fecha == null || !fecha.isBefore(LocalDate.now())) {
			throw new OperacionNoValida(mat);
		}
		
		this.matricula = mat;
		this.fechaMatriculacion = fecha;
	}

	/**
     * Retorna el valor del impuesto de circulacion
     *  @return valor del impuesto circulacion
     */
	public abstract double precioImpuesto (); 


	/**
	 * Retorna la matricula del vehiculo
	 * @return matricula
	 */
    public String getMatricula() {
		return matricula;
	}

    /**
     * Retorna la fecha de matriculacion del vehiculo
     * @return fecha de matriculacion
     */
	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}

}
