package es.unican.is2.gestionTienda;


public class VendedorEnPlantilla extends Vendedor {
	
	private TipoVendedor tipo;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) { // WMC +1
		super(nombre, id, dni);
		this.tipo = tipo;
	}
	
	public TipoVendedor tipo() { // WMC +1
		return tipo;
	}
	
	@Override
	public boolean equals(Object obj) { // WMC +1
		if (!(obj instanceof VendedorEnPlantilla)) // WMC +1 CCog +1
			return false;
		return super.equals(obj);
	}
}
