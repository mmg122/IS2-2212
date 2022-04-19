package es.unican.is2.test;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.DAO.ContribuyentesDAO;
import es.unican.is2.DAO.VehiculosDAO;
import es.unican.is2.Gestion.GestionImpuestoCirculacion;
import es.unican.is2.Vistas.VistaFuncionario;

public class VistaFuncionarioTest {

	// Componentes capa DAO
	private ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
	private VehiculosDAO vehiculosDAO = new VehiculosDAO();
	
	// Componentes capa negocio
	private GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
	
	private FrameFixture demo;

	@Before
	public void setUp() {
		VistaFuncionario gui = new VistaFuncionario(negocio, negocio, negocio);
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnBuscar").requireText("Buscar");
		
		//  Prueba dni correcto
		// Escribimos un nombre
		demo.textBox("txtDniContribuyente").enterText("11111111A");
		// Pulsamos el botón
		demo.button("btnBuscar").click();		
		// Comprobamos la salida
		demo.textBox("txtNombreContribuyente").requireText("Pepe López Martínez");
		demo.textBox("txtTotalContribuyente").requireText("403.20");
		
		// Prueba dni incorrecto
		demo.textBox("txtDniContribuyente").deleteText();
		demo.textBox("txtDniContribuyente").enterText("22222BBBB");
		// Pulsamos el botón
		demo.button("btnBuscar").click();		
		// Comprobamos la salida
		demo.textBox("txtNombreContribuyente").requireText("DNI No Válido");
		demo.textBox("txtTotalContribuyente").requireText("0");
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
