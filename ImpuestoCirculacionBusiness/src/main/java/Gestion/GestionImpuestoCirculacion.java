package Gestion;

import java.util.List;

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
		return contribuyentes.creaContribuyente(c);
	}

	
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.eliminaContribuyente(dni);
		if (c != null && !c.getVehiculos().isEmpty()) {
			contribuyentes.creaContribuyente(c);
			throw new OperacionNoValida(dni);
		}
		return c;		
	 }
	
	public Contribuyente contribuyente(String dni) {
		return contribuyentes.contribuyente(dni);
	}

	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		if (c == null) {
			return null;
		}
		Vehiculo vNuevo = vehiculos.creaVehiculo(v);
		if (vNuevo == null) {
			throw new OperacionNoValida(v.getMatricula());
		}
		c.getVehiculos().add(vNuevo);
		contribuyentes.actualizaContribuyente(c);
		return vNuevo;
	}


	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		Vehiculo v = vehiculos.vehiculo(matricula);
		if (c == null || v == null) {
			return null;
		}
		if (!c.getVehiculos().contains(v)) {
			throw new OperacionNoValida(matricula);
		}
		c.getVehiculos().remove(v);
		contribuyentes.actualizaContribuyente(c);
		return v;
	}


	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
	}	
}

