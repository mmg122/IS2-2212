package es.unican.is2.Clases;

import java.time.LocalDate;

import es.unican.is2.Excepciones.OperacionNoValida;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;
	
	public Motocicleta (String mat, LocalDate fecha, int c) throws OperacionNoValida {
		super(mat, fecha);
		if (c <= 0) {
			throw new OperacionNoValida(mat);
		}
		this.cilindrada = c;
	}

    /**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
  
	@Override
    public double precioImpuesto() {

		double precio = 0;
		
		if (!getFechaMatriculacion().plusYears(25).isAfter(LocalDate.now())) {
			return precio;			
		}
		
		if (cilindrada < 126) {
			precio = 8.84;
		} else if (cilindrada < 251) {
			precio = 15.14;
		} else if (cilindrada < 501) {
			precio = 30.3;
		} else if (cilindrada < 1001) {
			precio = 60.58;
		} else {
			precio = 121.16;
		}
		
		return precio;
    }
}
