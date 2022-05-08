package es.unican.is2.gestionTienda;


public class vendedorEnPracticas extends Vendedor {
	
	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public vendedorEnPracticas(String nombre, String id, String dni) { // WMC +1
		super(nombre, id, dni);
	}
	
	@Override
	public boolean equals(Object obj) { // WMC +1
		if (!(obj instanceof vendedorEnPracticas)) // WMC +1 CCog +1
			return false;
		return super.equals(obj);
	}
}
