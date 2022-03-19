package Clases;
import java.io.Serializable;
import java.time.LocalDate;
@SuppressWarnings("serial")
public class Furgoneta
    extends Turismo implements Serializable
{

    private boolean comercial;
    
    public Furgoneta (String mat, LocalDate fecha, double p) {
    	super(mat, fecha, p);
    	comercial = false;
    }
    
   /**
    * Retorna el valor del atributo comercial
    * @return true si la furgoneta es de uso comercial
    *         false si no es de uso comercial
    */
    public boolean getComercial() {
    	return comercial;
    }
  
	@Override
    public double precioImpuesto() {
		double precio = 0;
		double p = this.getPotencia();

		if (!getFechaMatriculacion().plusYears(25).isAfter(LocalDate.now())) {
			return precio;			
		}
		
		if (p < 8) {
			precio = 25.24;
		} else if (p < 12) {
			precio = 68.16;
		} else if (p < 16) {
			precio = 143.88;
		} else if (p < 20) {
			precio = 179.22;
		} else {
			precio = 224;
		}
		
		if (comercial) {
			precio = precio * 0.8;
		}
		
		return precio;
    	
    }
	
	public void cambiaComercial (boolean comercial) {
		this.comercial = comercial;
	}
}
