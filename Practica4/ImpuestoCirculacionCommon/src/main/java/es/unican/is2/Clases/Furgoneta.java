package es.unican.is2.Clases;
import java.io.Serializable;
import java.time.LocalDate;

import es.unican.is2.Excepciones.OperacionNoValida;
@SuppressWarnings("serial")
public class Furgoneta
    extends Turismo implements Serializable
{

    private boolean comercial;
    
    public Furgoneta (String mat, LocalDate fecha, double p, boolean comercial) throws OperacionNoValida {
    	super(mat, fecha, p);
    	this.comercial = comercial;
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
		
		double precio = super.precioImpuesto();
		
		if (comercial == true) {
			precio = precio * 0.8;
		}
		
		return precio;
    	
    }
}
