package es.unican.is2.Main;

import es.unican.is2.DAO.ContribuyentesDAO;
import es.unican.is2.DAO.VehiculosDAO;
import es.unican.is2.Gestion.*;
import es.unican.is2.Vistas.*;

/**
 * Clase principal que construye la aplicaci�n de tres capas y lanza su ejecuci�n
 */
public class Runner {

	public static void main(String[] args) {
		// Componentes capa DAO
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
		
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		// Componentes casa presentacion
		VistaFuncionario vista = new VistaFuncionario(negocio, negocio, negocio);
		
		// Lanza ejecuci�n
		vista.setVisible(true);
	}

}
