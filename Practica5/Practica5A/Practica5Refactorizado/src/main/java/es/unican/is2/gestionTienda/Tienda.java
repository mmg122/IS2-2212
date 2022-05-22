package es.unican.is2.gestionTienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores.
 * Gestiona las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como parámetro al crear la tienda
 */
public class Tienda {

	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;
	
	private static final String NOMBRE_STRING = "  Nombre: ";
	private static final String ID = " Id: ";
	private static final String DNI = " DNI: ";
	private static final String TOTAL = " TotalVentasMes: ";
	

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) { // WMC +1
		this.datos = datos;
	}

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	public String direccion() { // WMC +1
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() { // WMC +1
		return nombre;
	}

	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
	public boolean anhade(Vendedor nuevoVendedor) throws IOException { // WMC +1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) { // WMC +1 CCog +1
			return false;
		}
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como parámetro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ningún vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException { // WMC +1
		Vendedor v = buscaVendedor(id);
		if (v == null) { // WMC +1 CCog +1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * Añade una venta a un vendedor
	 * @param id Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se añade la venta 
	 *         false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException { // WMC +1
		Vendedor v = buscaVendedor(id);
		if (v == null) { // WMC +1 CCog +1
			return false;
		}
		double importeFinal = importe;
		if (v instanceof VendedorEnPlantilla) { // WMC +1 CCog +1
			switch (((VendedorEnPlantilla) v).tipo()) { // CCog +2
			case JUNIOR: // WMC +1
				importeFinal += importeFinal * 0.005;
				break;
			case SENIOR: // WMC +1
				importeFinal += importeFinal * 0.01;
				break;
			}
		}
		v.anhade(importeFinal);
		vuelcaDatos();
		return true;
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) { // WMC +1
		for (Vendedor v : vendedores()) { // WMC +1 CCog +1
			if (v.getId().equals(id)) { // WMC +1 CCog +2
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() { // WMC +1
		lista = new LinkedList<Vendedor>();

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
			while (in.hasNext() && !in.next().equals("Junior")) { // WMC +2 CCog +2

				String nom = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nom, idIn, dni, TipoVendedor.SENIOR);
				ven.setTotal(totalVentas);
				lista.add(ven);
			}
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Prácticas")) { // WMC +2 CCog +2
				String nom = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nom, idIn, dni, TipoVendedor.JUNIOR);
				ven.setTotal(totalVentas);
				lista.add(ven);
			}
			while (in.hasNext()) { // WMC +1 CCog +1
				in.next();
				String nom = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPracticas(nom, idIn, dni);
				ven.setTotal(totalVentas);
				lista.add(ven);
			}
		} catch (FileNotFoundException e) { // CCog +1

		} finally {
			if (in != null) { // WMC +1 CCog +1
				in.close();
			}
		} // try

		return lista;

	}

	/**
	 * Método que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 */
	private void vuelcaDatos() throws IOException { // WMC +1
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : lista) { // WMC +1 CCog +1
			if (v instanceof VendedorEnPracticas) { // WMC +1 CCog +2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) { // WMC +1 CCog +1
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR)) // WMC +1 CCog +3
					junior.add(vp);
				else // CCog +1
					senior.add(vp);
			}
		}

		try {

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("Senior");
			for (Vendedor v : senior) { // WMC +1 CCog +1
				VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
				out.println(NOMBRE_STRING + v1.getNombre() + ID + v1.getId() + DNI+ v1.getDni()+TOTAL
						+ v1.getTotalVentas());
			}
			out.println();
			out.println("Junior");
			for (Vendedor v : junior) { // WMC +1 CCog +1
				VendedorEnPlantilla v2 = (VendedorEnPlantilla) v;
				out.println(NOMBRE_STRING + v2.getNombre() + ID + v2.getId() + DNI+ v2.getDni()+TOTAL
						+ v2.getTotalVentas());
			}
			out.println();
			out.println("Prácticas");
			for (Vendedor v : practicas) { // WMC +1 CCog +1
				VendedorEnPracticas v3 = (VendedorEnPracticas) v;
				out.println(NOMBRE_STRING + v3.getNombre() + ID + v3.getId() + DNI+ v3.getDni()+TOTAL
						+ v3.getTotalVentas());
			}

		} finally {
			if (out != null) // WMC +1 CCog +1
				out.close();
		}
	}

}
