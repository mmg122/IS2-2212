package es.unican.is2.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import es.unican.is2.Clases.Turismo;

import es.unican.is2.Excepciones.OperacionNoValida;

class TurismoTest {

	@Test
	public void constructorTurismoTest() {
		Turismo t;
		
		// Casos válidos
		
		try {
			t = new Turismo("1111AA", LocalDate.of(2020, 1, 1), 6.5);
			assertTrue(t.precioImpuesto() == 25.24);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		try {
			t = new Turismo("1111AA", LocalDate.of(2020, 1, 1), 10.5);
			assertTrue(t.precioImpuesto() == 68.16);
		} catch (OperacionNoValida e) {
			fail("Caso 2: No debería lanzar la excepción");
		}
		
		try {
			t = new Turismo("1111AA", LocalDate.of(2020, 1, 1), 14.5);
			assertTrue(t.precioImpuesto() == 143.88);
		} catch (OperacionNoValida e) {
			fail("Caso 3: No debería lanzar la excepción");
		}
		
		try {
			t = new Turismo("1111AA", LocalDate.of(2020, 1, 1), 18.5);
			assertTrue(t.precioImpuesto() == 179.22);
		} catch (OperacionNoValida e) {
			fail("Caso 4: No debería lanzar la excepción");
		}
		
		try {
			t = new Turismo("1111AA", LocalDate.of(2020, 1, 1), 24.5);
			assertTrue(t.precioImpuesto() == 224);
		} catch (OperacionNoValida e) {
			fail("Caso 5: No debería lanzar la excepción");
		}
		
		try {
			t = new Turismo("1111AA", LocalDate.of(1990, 1, 1), 24.5);
			assertTrue(t.precioImpuesto() == 0);
		} catch (OperacionNoValida e) {
			fail("Caso 11: No debería lanzar la excepción");
		}
		
		// Casos no válidos
		
		try {
			t = new Turismo(null, LocalDate.of(1990, 1, 1), 24.5);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			t = new Turismo("1111AA", null, 24.5);
			fail("Caso 13: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			t = new Turismo("1111AA", LocalDate.now(), 24.5);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			t = new Turismo(null, LocalDate.now().plusMonths(5), 24.5);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			t = new Turismo("1111AA", LocalDate.of(1990, 1, 1), -5);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			t = new Turismo("1111AA", LocalDate.of(1990, 1, 1), 0);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
			
		
	}

}
