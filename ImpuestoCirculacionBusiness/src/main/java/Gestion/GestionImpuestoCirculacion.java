package Gestion;

import Clases.Contribuyente;
import Clases.Vehiculo;
import Excepciones.OperacionNoValida;
import IDAO.IContribuyentesDAO;
import IDAO.IVehiculosDAO;
import Interfaces.IGestionContribuyentes;
import Interfaces.IGestionVehiculos;
import Interfaces.IInfoImpuestoCirculacion;

/**
 * Clase que implementa la capa de negocio de la aplicacion
 */
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	
	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}
	
	public Contribuyente altaContribuyente(Contribuyente c) {
		// TODO
		return null;
	}

	
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida {
		// TODO
		return null;		
	 }
	
	public Contribuyente contribuyente(String dni) {
		// TODO
		return null;
	}

	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		// TODO
		return null;
	}

	@Override
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		// TODO
		return null;
	}

	@Override
	public Vehiculo vehiculo(String matricula) {
		// TODO
		return null;
	}	
}

