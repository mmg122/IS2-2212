package Clases;
import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{

	private double potencia;
	
	public Turismo (String mat, LocalDate fecha, double p) {
		super(mat, fecha);
		this.potencia = p;
	}
	
	/**
	 * Retorna la potencia del turismo
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
       
    
    /**
     * Retorna el precio del impuesto a pagar
     *  @return precio
     */
	@Override
    public double precioImpuesto() {
		double precio = 0;

		if (!getFechaMatriculacion().plusYears(25).isAfter(LocalDate.now())) {
			return precio;			
		}
		
		if (potencia < 8) {
			precio = 25.24;
		} else if (potencia < 12) {
			precio = 68.16;
		} else if (potencia < 16) {
			precio = 143.88;
		} else if (potencia < 20) {
			precio = 179.22;
		} else {
			precio = 224;
		}
		
    	return precio;
    }
    
}
