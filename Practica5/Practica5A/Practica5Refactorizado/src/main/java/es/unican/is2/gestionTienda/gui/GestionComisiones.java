package es.unican.is2.gestionTienda.gui;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import es.unican.is2.gestionTienda.Tienda;
import es.unican.is2.gestionTienda.Vendedor;
import fundamentos.Menu;
import fundamentos.Lectura;
import fundamentos.Mensaje;

/**
 * Gestión de las comisiones de vendedores de una tienda
 */
public class GestionComisiones {

	/**
	 * Programa principal basado en menu
	 */
	public static void main(String[] args) { // WMC +1
		// opciones del menu
		final int NUEVA_VENTA = 0;
		final int VENDEDOR_DEL_MES = 1;
		final int VENDEDORES = 2;

		// variables auxiliares
		String dni;
		Lectura lect;

		List<Vendedor> vendedores;
		String msj;

		// crea la tienda
		//Tienda tienda = new Tienda("C:\\Temp\\datosTienda.txt");
		Tienda tienda = new Tienda("C:\\Users\\mmurg\\practica3\\Practica5\\Practica5A\\Practica5Refactorizado\\datosTienda.txt");

		// crea la ventana de menu
		Menu menu = new Menu("Comisiones tienda");
		menu.insertaOpcion("Añadir venta", NUEVA_VENTA);
		menu.insertaOpcion("Vendedor del mes", VENDEDOR_DEL_MES);
		menu.insertaOpcion("Vendedores por ventas", VENDEDORES);
		int opcion;

		// lazo de espera de comandos del usuario
		while (true) { // WMC +1 CCog +1
			opcion = menu.leeOpcion();

			// realiza las acciones dependiendo de la opcion elegida
			switch (opcion) { // CCog +2
			case NUEVA_VENTA: // WMC +1
				lect = new Lectura("Datos Venta");
				lect.creaEntrada("Id Vendedor", "");
				lect.creaEntrada("Importe", "");
				lect.esperaYCierra();
				dni = lect.leeString("Id Vendedor");
				double importe = lect.leeDouble("Importe");
				try {
					if (!tienda.anhadeVenta(dni, importe)) { // WMC +1 CCog +3
						mensaje("ERROR", "El vendedor no existe");
					}
				} catch (IOException e) { // CCog +1
					mensaje("ERROR", "No se pudo guardar el cambio");
				}
				break;

			case VENDEDOR_DEL_MES: // WMC +1

				vendedores = tienda.vendedores();
				Collections.sort(vendedores, new ComparadorVendedorVentas());
				msj = "";
				msj += vendedores.get(0).getNombre() + "\n";
				mensaje("VENDEDORES DEL MES", msj);
				break;
			
			case VENDEDORES: // WMC +1
	
				vendedores = tienda.vendedores();
				System.out.println(vendedores.size());
				Collections.sort(vendedores, new ComparadorVendedorVentas());			
				msj = "";
				for (Vendedor vn : vendedores) { // WMC +1 CCog +3
					msj += vn.getNombre() + " " + vn.getTotalVentas() + "\n";
				}
				mensaje("VENDEDORES", msj);
				break;
				
			default:
				mensaje("FALLO", "Fallo al elegir opción");
				break;
			}
		}
	}

	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * @param titulo Titulo de la ventana
	 * @param txt Texto contenido en la ventana
	 */
	private static void mensaje(String titulo, String txt) { // WMC +1
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);

	}
	
	public static class ComparadorVendedorVentas implements Comparator<Vendedor>  { 

		public int compare(Vendedor o1, Vendedor o2) { // WMC +1
			if (o1.getTotalVentas()>o2.getTotalVentas()) // WMC +1 CCog +1
				return -1;
			else if (o1.getTotalVentas()<o2.getTotalVentas()) // WMC +1 CCog +1
				return 1;
			return 0;
		}
		
	}
	
	
}
