package es.unican.is2.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import es.unican.is2.Clases.Furgoneta;
import es.unican.is2.Excepciones.OperacionNoValida;

class FurgonetaTest {

	@Test
	public void constructorFurgonetaTest() {
		
		Furgoneta f;
		
		// Casos v�lidos
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 6.5, false);
			assertTrue(f.precioImpuesto() == 25.24);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 10.5, false);
			assertTrue(f.precioImpuesto() == 68.16);
		} catch (OperacionNoValida e) {
			fail("Caso 2: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 14.5, false);
			assertTrue(f.precioImpuesto() == 143.88);
		} catch (OperacionNoValida e) {
			fail("Caso 3: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 18.5, false);
			assertTrue(f.precioImpuesto() == 179.22);
		} catch (OperacionNoValida e) {
			fail("Caso 4: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 24.5, false);
			assertTrue(f.precioImpuesto() == 224);
		} catch (OperacionNoValida e) {
			fail("Caso 5: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 6.5, true);
			assertTrue(f.precioImpuesto() == (25.24 * 0.8));
		} catch (OperacionNoValida e) {
			fail("Caso 6: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 10.5, true);
			assertTrue(f.precioImpuesto() == (68.16 * 0.8));
		} catch (OperacionNoValida e) {
			fail("Caso 7: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 14.5, true);
			assertTrue(f.precioImpuesto() == (143.88 * 0.8));
		} catch (OperacionNoValida e) {
			fail("Caso 8: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 18.5, true);
			assertTrue(f.precioImpuesto() == (179.22 * 0.8));
		} catch (OperacionNoValida e) {
			fail("Caso 9: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(2020, 1, 1), 24.5, true);
			assertTrue(f.precioImpuesto() == (224 * 0.8));
		} catch (OperacionNoValida e) {
			fail("Caso 10: No deber�a lanzar la excepci�n");
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(1990, 1, 1), 24.5, true);
			assertTrue(f.precioImpuesto() == 0);
		} catch (OperacionNoValida e) {
			fail("Caso 11: No deber�a lanzar la excepci�n");
		}
		
		// Casos no v�lidos
		
		try {
			f = new Furgoneta(null, LocalDate.of(1990, 1, 1), 24.5, true);
			fail("Caso 12: Deber�a lanzar la excepci�n");
		} catch (OperacionNoValida e) {
		}
		
		try {
			f = new Furgoneta("1111AA", null, 24.5, true);
			fail("Caso 13: Deber�a lanzar la excepci�n");
		} catch (OperacionNoValida e) {
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.now(), 24.5, true);
			fail("Caso 12: Deber�a lanzar la excepci�n");
		} catch (OperacionNoValida e) {
		}
		
		try {
			f = new Furgoneta(null, LocalDate.now().plusMonths(5), 24.5, true);
			fail("Caso 12: Deber�a lanzar la excepci�n");
		} catch (OperacionNoValida e) {
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(1990, 1, 1), -5, true);
			fail("Caso 12: Deber�a lanzar la excepci�n");
		} catch (OperacionNoValida e) {
		}
		
		try {
			f = new Furgoneta("1111AA", LocalDate.of(1990, 1, 1), 0, true);
			fail("Caso 12: Deber�a lanzar la excepci�n");
		} catch (OperacionNoValida e) {
		}
		
	}

}
