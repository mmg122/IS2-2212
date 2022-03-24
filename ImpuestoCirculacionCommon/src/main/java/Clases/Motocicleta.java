package Clases;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;
	
	public Motocicleta (String mat, LocalDate fecha, int c) {
		super(mat, fecha);
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
